package com.project.permis.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public abstract class HibernateUtil
{
	/**
	 * The Hibernate session factory.
	 */
	protected static SessionFactory SESSION_FACTORY;
	
	/**
	 * A thread-local instance of an Hibernate session.
	 */
	protected static ThreadLocal<Session> SESSION;
	
	/**
	 * Initializes the Hibernate session factory.
	 */
	static
	{
		HibernateUtil.SESSION_FACTORY =
			new Configuration()
			.configure()
			.buildSessionFactory()
		;
		HibernateUtil.SESSION = new ThreadLocal<Session>();
	}
	
	/**
	 * Gets the current Hibernate session or opens a new one if there aren't any yet.
	 * 
	 * @return The Hibernate session.
	 * @throws org.hibernate.HibernateException If the session can't be opened.
	 */
	public static Session getSession()
	throws HibernateException
	{
		Session session = (Session) HibernateUtil.SESSION.get();
		
		if(null == session)
		{
			// The session doesn't exist yet, open one
			session = HibernateUtil.SESSION_FACTORY.openSession();
			HibernateUtil.SESSION.set(session);
		}
		
		return session;
	}
	
	/**
	 * Closes the Hibernate session if there is one.
	 * 
	 * @throws org.hibernate.HibernateException If the session can't be closed.
	 */
	public static void closeSession()
	throws HibernateException
	{
		Session session = (Session) HibernateUtil.SESSION.get();
		
		if(null != session)
		{
			HibernateUtil.SESSION.set(null);
			session.close();
		}
	}
}
