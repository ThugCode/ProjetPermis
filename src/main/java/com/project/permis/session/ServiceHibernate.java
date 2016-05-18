package com.project.permis.session;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.project.permis.ServiceHibernateException;

public class ServiceHibernate {

	private static final SessionFactory sessionFactory;

	static {
		try {
			// on lit la configuration du fichier hibernate.cfg.xml
			sessionFactory = new Configuration().configure().buildSessionFactory();
		} catch (HibernateException ex) {
			
			System.out.println(ex.getMessage());
			throw new ServiceHibernateException(ex, "Impossible de construire la SessionFactory: ", ex.getMessage());
		}
	}
	public static final ThreadLocal session = new ThreadLocal();

	public static Session currentSession() throws ServiceHibernateException {
		Session s = null;
		try {
			s = (Session) session.get();
			// Open a new Session, if this Thread has none yet
			if (s == null) {
				s = sessionFactory.openSession();
				session.set(s);
			}
		} catch (HibernateException ex) {
			throw new ServiceHibernateException(ex, "Impossible d'accéder à la SessionFactory: ", ex.getMessage());
		}
		return s;
	}

	public static void closeSession() throws ServiceHibernateException {
		try {
			Session s = (Session) session.get();
			session.set(null);
			if (s != null)
				s.close();
		} catch (HibernateException ex) {
			throw new ServiceHibernateException(ex, "Impossible de fermer la SessionFactory: ",ex.getMessage());
		}
	}
}
