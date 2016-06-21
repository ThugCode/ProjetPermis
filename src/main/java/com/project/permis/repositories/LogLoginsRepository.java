package com.project.permis.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.permis.entities.LogLogins;
import com.project.permis.utils.HibernateUtil;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class LogLoginsRepository
{
	/**
	 * Fetches a single existing login log from the database.
	 * 
	 * @param id The login log's id.
	 * @return The login log, or {@code null} if there are no matching login log.
	 * @throws com.project.permis.repositories.RepositoryException If the login log can't
	 * be properly fetched.
	 */
	public LogLogins fetch(int id)
	throws RepositoryException
	{
		// Fetch the login log
		try
		{
			Query query = HibernateUtil.getSession().createQuery(
				"FROM LogLogins AS l WHERE l.id = :id"
			);
			query.setInteger("id", id);
			
			return (LogLogins) query.uniqueResult();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				String.format(
					"Impossible de récupérer l'entrée d'historique de connexion #%d.",
					id
				)
			);
		}
	}
	
	/**
	 * Fetches every existing login log from the database.
	 * 
	 * @return The list of login logs.
	 * @throws com.project.permis.repositories.RepositoryException If the login logs can't
	 * be properly fetched.
	 */
	@SuppressWarnings("unchecked")
	public List<LogLogins> fetchAll()
	throws RepositoryException
	{
		// Fetch the login logs
		try
		{
			Query query = HibernateUtil.getSession().createQuery(
				"FROM LogLogins AS l"
			);
			
			return (List<LogLogins>) query.list();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer l'historique de connexion."
			);
		}
	}
	
	/**
	 * Saves a login log into the database.
	 * 
	 * @param log The login log to save.
	 * @throws com.project.permis.repositories.RepositoryException If the login log can't
	 * be properly saved.
	 */
	public void save(LogLogins log)
	throws RepositoryException
	{
		// Initialize vars
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		// Save the login log
		try
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(log);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de sauvegarder une entrée d'historique de connexion."
			);
		}
	}
	
	/**
	 * Removes a login log from the database.
	 * 
	 * @param log The login log to delete.
	 * @throws com.project.permis.repositories.RepositoryException If the login log can't
	 * be properly deleted.
	 */
	public void delete(LogLogins log)
	throws RepositoryException
	{
		// Initialize vars
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		// Delete the login log
		try
		{
			transaction = session.beginTransaction();
			session.delete(log);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de supprimer une entrée d'historique de connexion."
			);
		}
	}
}
