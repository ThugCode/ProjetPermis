package com.project.permis.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.permis.entities.Game;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class GameRepository extends AbstractRepository
{
	/**
	 * Fetches a single existing game from the database.
	 * 
	 * @param id The game's id.
	 * @return The game, or {@code null} if there are no matching game.
	 * @throws com.project.permis.repositories.RepositoryException If the game can't
	 * be properly fetched.
	 */
	public Game fetch(int id)
	throws RepositoryException
	{
		// Fetch the game
		try
		{
			
			Query query = this.getSession().createQuery(
				"FROM Game AS g WHERE g.id = :id"
			);
			query.setInteger("id", id);
			
			return (Game) query.uniqueResult();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				String.format(
					"Impossible de récupérer le jeu #%d.",
					id
				)
			);
		}
	}
	
	/**
	 * Fetches every existing game from the database.
	 * 
	 * @return The list of games.
	 * @throws com.project.permis.repositories.RepositoryException If the games can't
	 * be properly fetched.
	 */
	@SuppressWarnings("unchecked")
	public List<Game> fetchAll()
	throws RepositoryException
	{
		// Fetch the games
		try
		{
			Query query = this.getSession().createQuery(
				"FROM Game AS g"
			);
			
			return (List<Game>) query.list();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer la liste des jeux."
			);
		}
	}
	
	/**
	 * Saves a game into the database.
	 * 
	 * @param game The game to save.
	 * @throws com.project.permis.repositories.RepositoryException If the game can't
	 * be properly saved.
	 */
	public void save(Game game)
	throws RepositoryException
	{
		// Initialize vars
		Session session = this.getSession();
		Transaction transaction = null;
		
		// Save the game
		try
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(game);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de sauvegarder un jeu."
			);
		}
	}
	
	/**
	 * Removes a game from the database.
	 * 
	 * @param game The game to delete.
	 * @throws com.project.permis.repositories.RepositoryException If the game can't
	 * be properly deleted.
	 */
	public void delete(Game game)
	throws RepositoryException
	{
		// Initialize vars
		Session session = this.getSession();
		Transaction transaction = null;
		
		// Delete the game
		try
		{
			transaction = session.beginTransaction();
			session.delete(game);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de supprimer un jeu."
			);
		}
	}
}
