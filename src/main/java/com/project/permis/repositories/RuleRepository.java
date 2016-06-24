package com.project.permis.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.permis.entities.Rule;
import com.project.permis.utils.HibernateUtil;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class RuleRepository
{
	/**
	 * Fetches a single existing rule from the database.
	 * 
	 * @param id The rule's id.
	 * @return The rule, or {@code null} if there are no matching rule.
	 * @throws com.project.permis.repositories.RepositoryException If the rule can't
	 * be properly fetched.
	 */
	public Rule fetch(int id)
	throws RepositoryException
	{
		// Fetch the rule
		try
		{
			Query query = HibernateUtil.getSession().createQuery(
				"FROM Rule AS r WHERE r.id = :id"
			);
			query.setInteger("id", id);
			query.setMaxResults(1);
			
			return (Rule) query.uniqueResult();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				String.format(
					"Impossible de récupérer la règle #%d.",
					id
				)
			);
		}
	}
	
	/**
	 * Fetches every existing rule from the database.
	 * 
	 * @return The list of rules.
	 * @throws com.project.permis.repositories.RepositoryException If the rules can't
	 * be properly fetched.
	 */
	@SuppressWarnings("unchecked")
	public List<Rule> fetchAll()
	throws RepositoryException
	{
		// Fetch the rules
		try
		{
			Query query = HibernateUtil.getSession().createQuery(
				"FROM Rule AS r"
			);
			
			return (List<Rule>) query.list();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer la liste des règles."
			);
		}
	}
	
	/**
	 * Saves a rule into the database.
	 * 
	 * @param rule The rule to save.
	 * @throws com.project.permis.repositories.RepositoryException If the rule can't
	 * be properly saved.
	 */
	public void save(Rule rule)
	throws RepositoryException
	{
		// Initialize vars
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		// Save the rule
		try
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(rule);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de sauvegarder une règle."
			);
		}
	}
	
	/**
	 * Removes a rule from the database.
	 * 
	 * @param rule The rule to delete.
	 * @throws com.project.permis.repositories.RepositoryException If the rule can't
	 * be properly deleted.
	 */
	public void delete(Rule rule)
	throws RepositoryException
	{
		// Initialize vars
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		// Delete the rule
		try
		{
			transaction = session.beginTransaction();
			session.delete(rule);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de supprimer une règle."
			);
		}
	}
}
