package com.project.permis.repositories;

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
public abstract class AbstractRepository
{
	/**
	 * The Hibernate session factory.
	 */
	protected static SessionFactory sessionFactory;
	
	/**
	 * A thread-local instance of an Hibernate session.
	 */
	protected final ThreadLocal<Session> localSession = new ThreadLocal<Session>();
	
	/**
	 * Initializes the Hibernate session factory.
	 */
	static
	{
		try
		{
			AbstractRepository.sessionFactory =
				new Configuration()
				.configure()
				.buildSessionFactory()
			;
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(ex, "Impossible d'ouvrir une session Hibernate"); 
		}
	}
	
	/**
	 * Gets the current Hibernate session or opens a new one if there aren't any yet.
	 * 
	 * @return The Hibernate session.
	 * @throws com.project.permis.repositories.RepositoryException If the session
	 * can't be opened.
	 */
	public Session getSession()
	throws RepositoryException
	{
		Session session = null;
		
		try
		{
			session = (Session) this.localSession.get();
			
			if(null == session)
			{
				// The session doesn't exist yet, open one
				session = AbstractRepository.sessionFactory.openSession();
				this.localSession.set(session);
			}
			
			return session;
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(ex, "Impossible d'ouvrir une session Hibernate.");
		}
	}
	
	/**
	 * Closes the Hibernate session if there is one.
	 * 
	 * @throws com.project.permis.repositories.RepositoryException If the session
	 * can't be closed.
	 */
	public void closeSession()
	throws RepositoryException
	{
		Session session = (Session) this.localSession.get();
		
		if(null != session)
		{
			this.localSession.set(null);
			
			try
			{
				session.close();
			}
			catch(HibernateException ex)
			{
				throw new RepositoryException(ex, "Impossible de fermer la session Hibernate.");
			}
		}
	}
}
