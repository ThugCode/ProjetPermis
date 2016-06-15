package com.project.permis.repositories;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.project.permis.entities.Student;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class StudentRepository extends AbstractRepository
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
			Query query = this.getSession().createQuery(
				"FROM Student AS s WHERE s.id = :id"
			);
			query.setInteger("id", id);
			
			return (Student) query.uniqueResult();
		}
		catch(HibernateException ex)
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
			Query query = this.getSession().createQuery(
				"FROM Student AS s"
			);
			
			return (List<Student>) query.list();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer la liste des étudiants."
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
		Session session = this.getSession();
		Transaction transaction = null;
		
		// Save the student
		try
		{
			transaction = session.beginTransaction();
			session.saveOrUpdate(student);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
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
		Session session = this.getSession();
		Transaction transaction = null;
		
		// Delete the student
		try
		{
			transaction = session.beginTransaction();
			session.delete(student);
			transaction.commit();
		}
		catch(HibernateException ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de supprimer un étudiant."
			);
		}
	}
}
