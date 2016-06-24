package com.project.permis.repositories;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

import com.project.permis.utils.HibernateUtil;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class StatisticsRepository
{
	/**
	 * Computes statistics about the number of students per game.
	 * The game's name is accessible by casting the first row to a string and
	 * the game's number of students is accessible by casting the second row
	 * as an integer or a long.
	 * 
	 * @return The list of formations with the associated number of students.
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> studentsPerGame()
	{
		// Fetch the statistics
		try
		{
			// Execute query
			SQLQuery query = HibernateUtil.getSession().createSQLQuery(
				"SELECT g.`name`, COUNT(sg.`id_student`) AS `count` " +
				"FROM `game` g " +
				"INNER JOIN `student_game` sg " +
				"ON sg.`id_game` = g.`id` " +
				"GROUP BY g.`id` " +
				"ORDER BY COUNT(sg.`id_student`) DESC"
			);
			query.addScalar("name", new StringType());
			query.addScalar("count", new LongType());
			
			return (List<Object[]>) query.list();
		}
		catch(Exception ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer la liste des missions."
			);
		}
	}
	
	/**
	 * Computes statistics about the mean completion per game.
	 * 
	 * @return The list of formations with the associated mean completion.
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> meanCompletion()
	{
		// Fetch the statistics
		try
		{
			// Execute query
			SQLQuery query = HibernateUtil.getSession().createSQLQuery(
				"SELECT g.`name`, COUNT(DISTINCT ga.`id_action`) AS `count` " +
				"FROM `game` g " +
				"INNER JOIN `game_mission` gm ON gm.`id_game` = g.`id` " +
				"INNER JOIN `student_game` sg ON gm.`id_game` = sg.`id_game` " +
				"INNER JOIN `mission_goal` mg ON mg.`id_mission` = gm.`id_mission` " +
				"INNER JOIN `action_goal` ga ON mg.`id_goal` = ga.`id_goal` " +
				"GROUP BY g.`id` "
			);
			query.addScalar("name", new StringType());
			query.addScalar("count", new LongType());
			System.out.println("yo "+query.list().size());
			
			for(Object[] abc : (List<Object[]>)query.list()) {
				System.out.println(abc[0]+" : "+abc[1]);
			}
			
			return (List<Object[]>) query.list();
		}
		catch(Exception ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer la liste des missions."
			);
		}
	}
	
	/**
	 * Computes statistics about the number of students per game.
	 * The game's name is accessible by casting the first row to a string and
	 * the game's number of students is accessible by casting the second row
	 * as an integer or a long.
	 * 
	 * @return The list of formations with the associated number of students.
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> totalCompletion()
	{
		// Fetch the statistics
		try
		{
			// Execute query
			SQLQuery query = HibernateUtil.getSession().createSQLQuery(
				"SELECT g.`name`, COUNT(sg.`id_student`) AS `count` " +
				"FROM `game` g " +
				"INNER JOIN `student_game` sg " +
				"ON sg.`id_game` = g.`id` " +
				"GROUP BY g.`id` " +
				"ORDER BY COUNT(sg.`id_student`) DESC"
			);
			query.addScalar("name", new StringType());
			query.addScalar("count", new LongType());
			
			return (List<Object[]>) query.list();
		}
		catch(Exception ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer la liste des missions."
			);
		}
	}
}
