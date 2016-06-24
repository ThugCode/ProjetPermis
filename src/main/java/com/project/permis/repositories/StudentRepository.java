package com.project.permis.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.permis.entities.Student;
import com.project.permis.utils.HibernateUtil;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class StudentRepository
{
	/**
	 * Fetches a single existing student from the database.
	 * 
	 * @param id The student's id.
	 * @return The student, or {@code null} if there are no matching student.
	 * @throws com.project.permis.repositories.RepositoryException If the student can't
	 * be properly fetched.
	 */
	public Student fetch(int id)
	throws RepositoryException
	{
		// Fetch the student
		try
		{
			Query query = HibernateUtil.getSession().createQuery(
				"FROM Student AS s WHERE s.id = :id"
			);
			query.setInteger("id", id);
			query.setMaxResults(1);
			
			return (Student) query.uniqueResult();
		}
		catch(Exception ex)
		{
			throw new RepositoryException(
				ex,
				String.format(
					"Impossible de récupérer l'étudiant #%d.",
					id
				)
			);
		}
	}
	
	/**
	 * Fetches every existing student from the database.
	 * 
	 * @return The list of students.
	 * @throws com.project.permis.repositories.RepositoryException If the students can't
	 * be properly fetched.
	 */
	@SuppressWarnings("unchecked")
	public List<Student> fetchAll()
	throws RepositoryException
	{
		// Fetch the students
		try
		{
			Query query = HibernateUtil.getSession().createQuery(
				"FROM Student AS s"
			);
			
			return (List<Student>) query.list();
		}
		catch(Exception ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer la liste des étudiants."
			);
		}
	}
	
	/**
	 * Fetches a single existing student from the database according to their mail address.
	 * 
	 * @param mail The student's mail.
	 * @return The student, or {@code null} if there are no matching student.
	 * @throws com.project.permis.repositories.RepositoryException If the student can't
	 * be properly fetched.
	 */
	public Student findByMail(String mail)
	{
		// Fetch the student
		try
		{
			Query query = HibernateUtil.getSession().createQuery(
				"FROM Student AS s WHERE s.mail = :mail"
			);
			query.setString("mail", mail);
			
			return (Student) query.uniqueResult();
		}
		catch(Exception ex)
		{
			throw new RepositoryException(
				ex,
				String.format(
					"Impossible de récupérer l'étudiant dont l'adresse email est %s.",
					mail
				)
			);
		}
	}
	
	/**
	 * Saves a student into the database.
	 * 
	 * @param student The student to save.
	 * @throws com.project.permis.repositories.RepositoryException If the student can't
	 * be properly saved.
	 */
	public void save(Student student)
	throws RepositoryException
	{
		// Initialize vars
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		// Save the student
		try
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(student);
			transaction.commit();
		}
		catch(Exception ex)
		{
			transaction.rollback();
			
			throw new RepositoryException(
				ex,
				"Impossible de sauvegarder un étudiant."
			);
		}
	}
	
	/**
	 * Removes a student from the database.
	 * 
	 * @param student The student to delete.
	 * @throws com.project.permis.repositories.RepositoryException If the student can't
	 * be properly deleted.
	 */
	public void delete(Student student)
	throws RepositoryException
	{
		// Initialize vars
		Session session = HibernateUtil.getSession();
		Transaction transaction = null;
		
		// Delete the student
		try
		{
			transaction = session.beginTransaction();
			session.delete(student);
			transaction.commit();
		}
		catch(Exception ex)
		{
			transaction.rollback();
			
			throw new RepositoryException(
				ex,
				"Impossible de supprimer un étudiant."
			);
		}
	}
}
