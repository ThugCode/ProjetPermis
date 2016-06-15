package com.project.permis.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.permis.entities.Action;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class ActionRepository extends AbstractRepository
{
	/**
	 * Fetches a single existing action from the database.
	 * 
	 * @param id The action's id.
	 * @return The action, or {@code null} if there are no matching action.
	 * @throws com.project.permis.repositories.RepositoryException If the action can't
	 * be properly fetched.
	 */
	public Action fetch(int id)
	throws RepositoryException
	{
		// Fetch the action
		try
		{
			Query query = this.getSession().createQuery(
				"FROM Action AS a WHERE a.id = :id"
			);
			query.setInteger("id", id);
			
			return (Action) query.uniqueResult();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				String.format(
					"Impossible de récupérer l'action #%d.",
					id
				)
			);
		}
	}
	
	/**
	 * Fetches every existing action from the database.
	 * 
	 * @return The list of actions.
	 * @throws com.project.permis.repositories.RepositoryException If the actions can't
	 * be properly fetched.
	 */
	@SuppressWarnings("unchecked")
	public List<Action> fetchAll()
	throws RepositoryException
	{
		// Fetch the actions
		try
		{
			Query query = this.getSession().createQuery(
				"FROM Action AS a"
			);
			
			return (List<Action>) query.list();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer la liste des actions."
			);
		}
	}
	
	/**
	 * Saves an action into the database.
	 * 
	 * @param action The action to save.
	 * @throws com.project.permis.repositories.RepositoryException If the action can't
	 * be properly saved.
	 */
	public void save(Action action)
	throws RepositoryException
	{
		// Initialize vars
		Session session = this.getSession();
		Transaction transaction = null;
		
		// Save the action
		try
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(action);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de sauvegarder une action."
			);
		}
	}
	
	/**
	 * Removes an action from the database.
	 * 
	 * @param action The action to delete.
	 * @throws com.project.permis.repositories.RepositoryException If the action can't
	 * be properly deleted.
	 */
	public void delete(Action action)
	throws RepositoryException
	{
		// Initialize vars
		Session session = this.getSession();
		Transaction transaction = null;
		
		// Delete the action
		try
		{
			transaction = session.beginTransaction();
			session.delete(action);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de supprimer une action."
			);
		}
	}
}
