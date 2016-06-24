package com.project.permis.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.permis.entities.Goal;
import com.project.permis.utils.HibernateUtil;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class GoalRepository
{
	/**
	 * Fetches a single existing goal from the database.
	 * 
	 * @param id The goal's id.
	 * @return The goal, or {@code null} if there are no matching goal.
	 * @throws com.project.permis.repositories.RepositoryException If the goal can't
	 * be properly fetched.
	 */
	public Goal fetch(int id)
	throws RepositoryException
	{
		// Fetch the goal
		try
		{
			Query query = HibernateUtil.getSession().createQuery(
				"FROM Goal AS g WHERE g.id = :id"
			);
			query.setInteger("id", id);
			query.setMaxResults(1);
			
			return (Goal) query.uniqueResult();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				String.format(
					"Impossible de récupérer l'objectif #%d.",
					id
				)
			);
		}
	}
	
	/**
	 * Fetches every existing goal from the database.
	 * 
	 * @return The list of goals.
	 * @throws com.project.permis.repositories.RepositoryException If the goals can't
	 * be properly fetched.
	 */
	@SuppressWarnings("unchecked")
	public List<Goal> fetchAll()
	throws RepositoryException
	{
		// Fetch the goals
		try
		{
			Query query = HibernateUtil.getSession().createQuery(
				"FROM Goal AS g"
			);
			
			return (List<Goal>) query.list();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer la liste des objectifs."
			);
		}
	}
	
	/**
	 * Saves a goal into the database.
	 * 
	 * @param goal The goal to save.
	 * @throws com.project.permis.repositories.RepositoryException If the goal can't
	 * be properly saved.
	 */
	public void save(Goal goal)
	throws RepositoryException
	{
		// Initialize vars
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		// Save the goal
		try
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(goal);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de sauvegarder un objectif."
			);
		}
	}
	
	/**
	 * Removes a goal from the database.
	 * 
	 * @param goal The goal to delete.
	 * @throws com.project.permis.repositories.RepositoryException If the goal can't
	 * be properly deleted.
	 */
	public void delete(Goal goal)
	throws RepositoryException
	{
		// Initialize vars
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		// Delete the goal
		try
		{
			transaction = session.beginTransaction();
			session.delete(goal);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de supprimer un objectif."
			);
		}
	}
}
