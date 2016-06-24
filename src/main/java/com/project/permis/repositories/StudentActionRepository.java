package com.project.permis.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.permis.entities.StudentAction;
import com.project.permis.entities.StudentActionId;
import com.project.permis.utils.HibernateUtil;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class StudentActionRepository
{
	/**
	 * Fetches a single existing student's action from the database.
	 * 
	 * @param id The student's action's id.
	 * @return The student's action, or {@code null} if there are no matching student's action.
	 * @throws com.project.permis.repositories.RepositoryException If the student's action can't
	 * be properly fetched.
	 */
	public StudentAction fetch(StudentActionId id)
	throws RepositoryException
	{
		// Fetch the rule
		try
		{
			Query query = HibernateUtil.getSession().createQuery(
				"FROM StudentAction AS a WHERE a.id.idStudent = :student_id AND a.id.idAction = :action_id"
			);
			query.setInteger("student_id", id.getIdStudent());
			query.setInteger("action_id", id.getIdAction());
			query.setMaxResults(1);
			
			return (StudentAction) query.uniqueResult();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				String.format(
					"Impossible de récupérer l'action d'étudiant #%d.",
					id
				)
			);
		}
	}
	
	/**
	 * Fetches every existing student's action from the database.
	 * 
	 * @return The list of student's actions.
	 * @throws com.project.permis.repositories.RepositoryException If the student's actions can't
	 * be properly fetched.
	 */
	@SuppressWarnings("unchecked")
	public List<StudentAction> fetchAll()
	throws RepositoryException
	{
		// Fetch the student's actions
		try
		{
			Query query = HibernateUtil.getSession().createQuery(
				"FROM StudentAction AS a"
			);
			
			return (List<StudentAction>) query.list();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer la liste des actions des étudiants."
			);
		}
	}
	
	/**
	 * Saves a student's action into the database.
	 * 
	 * @param action The student's action to save.
	 * @throws com.project.permis.repositories.RepositoryException If the student's action can't
	 * be properly saved.
	 */
	public void save(StudentAction action)
	throws RepositoryException
	{
		// Initialize vars
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		// Save the student's action
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
				"Impossible de sauvegarder une action d'étudiant."
			);
		}
	}
	
	/**
	 * Removes a student's action from the database.
	 * 
	 * @param action The student's action to delete.
	 * @throws com.project.permis.repositories.RepositoryException If the student's action can't
	 * be properly deleted.
	 */
	public void delete(StudentAction action)
	throws RepositoryException
	{
		// Initialize vars
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		// Delete the student's action
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
				"Impossible de supprimer une action d'étudiant."
			);
		}
	}
}
