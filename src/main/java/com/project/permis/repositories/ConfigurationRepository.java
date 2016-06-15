package com.project.permis.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.permis.entities.Configuration;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class ConfigurationRepository extends AbstractRepository
{
	/**
	 * Fetches a single existing configuration from the database.
	 * 
	 * @param id The configuration's id.
	 * @return The configuration, or {@code null} if there are no matching configuration.
	 * @throws com.project.permis.repositories.RepositoryException If the configuration can't
	 * be properly fetched.
	 */
	public Configuration fetch(int id)
	throws RepositoryException
	{
		// Fetch the configuration
		try
		{
			
			Query query = this.getSession().createQuery(
				"FROM Configuration AS c WHERE c.id = :id"
			);
			query.setInteger("id", id);
			
			return (Configuration) query.uniqueResult();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				String.format(
					"Impossible de récupérer le paramètre #%d.",
					id
				)
			);
		}
	}
	
	/**
	 * Fetches every existing configuration from the database.
	 * 
	 * @return The list of configurations.
	 * @throws com.project.permis.repositories.RepositoryException If the configurations can't
	 * be properly fetched.
	 */
	@SuppressWarnings("unchecked")
	public List<Configuration> fetchAll()
	throws RepositoryException
	{
		// Fetch the configurations
		try
		{
			Query query = this.getSession().createQuery(
				"FROM Configuration AS c"
			);
			
			return (List<Configuration>) query.list();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer la liste des paramètres."
			);
		}
	}
	
	/**
	 * Saves a configuration into the database.
	 * 
	 * @param configuration The configuration to save.
	 * @throws com.project.permis.repositories.RepositoryException If the configuration can't
	 * be properly saved.
	 */
	public void save(Configuration configuration)
	throws RepositoryException
	{
		// Initialize vars
		Session session = this.getSession();
		Transaction transaction = null;
		
		// Save the configuration
		try
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(configuration);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de sauvegarder un paramètre."
			);
		}
	}
	
	/**
	 * Removes a configuration from the database.
	 * 
	 * @param configuration The configuration to delete.
	 * @throws com.project.permis.repositories.RepositoryException If the configuration can't
	 * be properly deleted.
	 */
	public void delete(Configuration configuration)
	throws RepositoryException
	{
		// Initialize vars
		Session session = this.getSession();
		Transaction transaction = null;
		
		// Delete the configuration
		try
		{
			transaction = session.beginTransaction();
			session.delete(configuration);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de supprimer un paramètre."
			);
		}
	}
}
