package com.project.permis.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.permis.entities.Flag;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class FlagRepository extends AbstractRepository
{
	/**
	 * Fetches a single existing flag from the database.
	 * 
	 * @param id The flag's id.
	 * @return The flag, or {@code null} if there are no matching flag.
	 * @throws com.project.permis.repositories.RepositoryException If the flag can't
	 * be properly fetched.
	 */
	public Flag fetch(int id)
	throws RepositoryException
	{
		// Fetch the flag
		try
		{
			Query query = this.getSession().createQuery(
				"FROM Flag AS f WHERE f.id = :id"
			);
			query.setInteger("id", id);
			
			return (Flag) query.uniqueResult();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				String.format(
					"Impossible de récupérer l'option #%d.",
					id
				)
			);
		}
	}
	
	/**
	 * Fetches every existing flag from the database.
	 * 
	 * @return The list of flags.
	 * @throws com.project.permis.repositories.RepositoryException If the flags can't
	 * be properly fetched.
	 */
	@SuppressWarnings("unchecked")
	public List<Flag> fetchAll()
	throws RepositoryException
	{
		// Fetch the flags
		try
		{
			Query query = this.getSession().createQuery(
				"FROM Flag AS f"
			);
			
			return (List<Flag>) query.list();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer la liste des options."
			);
		}
	}
	
	/**
	 * Saves a flag into the database.
	 * 
	 * @param flag The flag to save.
	 * @throws com.project.permis.repositories.RepositoryException If the flag can't
	 * be properly saved.
	 */
	public void save(Flag flag)
	throws RepositoryException
	{
		// Initialize vars
		Session session = this.getSession();
		Transaction transaction = null;
		
		// Save the flag
		try
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(flag);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de sauvegarder une option."
			);
		}
	}
	
	/**
	 * Removes a flag from the database.
	 * 
	 * @param flag The flag to delete.
	 * @throws com.project.permis.repositories.RepositoryException If the flag can't
	 * be properly deleted.
	 */
	public void delete(Flag flag)
	throws RepositoryException
	{
		// Initialize vars
		Session session = this.getSession();
		Transaction transaction = null;
		
		// Delete the flag
		try
		{
			transaction = session.beginTransaction();
			session.delete(flag);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de supprimer une option."
			);
		}
	}
}
