package com.project.permis.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class UserRepository extends AbstractRepository
{
	/**
	 * Fetches a single existing user from the database.
	 * 
	 * @param id The user's id.
	 * @return The user, or {@code null} if there are no matching user.
	 * @throws com.project.permis.repositories.RepositoryException If the user can't
	 * be properly fetched.
	 * @todo Replace {@code Object} by the actual type.
	 * @todo Write the actual HQL.
	 */
	public Object fetch(int id)
	throws RepositoryException
	{
		// Initialize vars
		Object user = null;
		
		// Fetch the user
		try
		{
			
			Query query = this.getSession().createQuery(
				"FROM User AS u WHERE u.id = :id"
			);
			query.setInteger("id", id);
			
			user = (Object) query.uniqueResult();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				String.format(
					"Impossible de récupérer l'utilisateur #%d.",
					id
				)
			);
		}
		
		return user;
	}
	
	/**
	 * Fetches every existing user from the database.
	 * 
	 * @return The list of users.
	 * @throws com.project.permis.repositories.RepositoryException If the users can't
	 * be properly fetched.
	 * @todo Replace {@code Object} by the actual type.
	 * @todo Write the actual HQL.
	 */
	@SuppressWarnings("unchecked")
	public List<Object> fetchAll()
	throws RepositoryException
	{
		// Initialize vars
		List<Object> users = null;
		
		// Fetch the users
		try
		{
			Query query = this.getSession().createQuery(
				"FROM User"
			);
			
			users = (List<Object>) query.list();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer la liste des utilisateurs."
			);
		}
		
		return users;
	}
	
	/**
	 * Saves an user into the database.
	 * 
	 * @param user The user to save.
	 * @throws com.project.permis.repositories.RepositoryException If the user can't
	 * be properly saved.
	 * @todo Replace {@code Object} by the actual type.
	 */
	public void save(Object user)
	throws RepositoryException
	{
		// Initialize vars
		Session session = this.getSession();
		Transaction transaction = null;
		
		// Save the user
		try
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(user);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de sauvegarder un utilisateur."
			);
		}
	}
	
	/**
	 * Removes an user from the database.
	 * 
	 * @param user The user to delete.
	 * @throws com.project.permis.repositories.RepositoryException If the user can't
	 * be properly deleted.
	 * @todo Replace {@code Object} by the actual type.
	 */
	public void delete(Object user)
	throws RepositoryException
	{
		// Initialize vars
		Session session = this.getSession();
		Transaction transaction = null;
		
		// Delete the user
		try
		{
			transaction = session.beginTransaction();
			session.delete(user);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de sauvegarder un utilisateur."
			);
		}
	}
}
