package com.project.permis.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.permis.entities.Mission;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class MissionRepository extends AbstractRepository
{
	/**
	 * Fetches a single existing mission from the database.
	 * 
	 * @param id The mission's id.
	 * @return The mission, or {@code null} if there are no matching mission.
	 * @throws com.project.permis.repositories.RepositoryException If the mission can't
	 * be properly fetched.
	 */
	public Mission fetch(int id)
	throws RepositoryException
	{
		// Fetch the mission
		try
		{
			
			Query query = this.getSession().createQuery(
				"FROM Mission AS m WHERE m.id = :id"
			);
			query.setInteger("id", id);
			
			return (Mission) query.uniqueResult();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				String.format(
					"Impossible de récupérer la mission #%d.",
					id
				)
			);
		}
	}
	
	/**
	 * Fetches every existing mission from the database.
	 * 
	 * @return The list of missions.
	 * @throws com.project.permis.repositories.RepositoryException If the missions can't
	 * be properly fetched.
	 */
	@SuppressWarnings("unchecked")
	public List<Mission> fetchAll()
	throws RepositoryException
	{
		// Fetch the missions
		try
		{
			Query query = this.getSession().createQuery(
				"FROM Mission AS m"
			);
			
			return (List<Mission>) query.list();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer la liste des missions."
			);
		}
	}
	
	/**
	 * Saves a mission into the database.
	 * 
	 * @param mission The mission to save.
	 * @throws com.project.permis.repositories.RepositoryException If the mission can't
	 * be properly saved.
	 */
	public void save(Mission mission)
	throws RepositoryException
	{
		// Initialize vars
		Session session = this.getSession();
		Transaction transaction = null;
		
		// Save the mission
		try
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(mission);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de sauvegarder une mission."
			);
		}
	}
	
	/**
	 * Removes a mission from the database.
	 * 
	 * @param mission The mission to delete.
	 * @throws com.project.permis.repositories.RepositoryException If the mission can't
	 * be properly deleted.
	 */
	public void delete(Mission mission)
	throws RepositoryException
	{
		// Initialize vars
		Session session = this.getSession();
		Transaction transaction = null;
		
		// Delete the mission
		try
		{
			transaction = session.beginTransaction();
			session.delete(mission);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de supprimer une mission."
			);
		}
	}
}
