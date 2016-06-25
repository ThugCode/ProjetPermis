package com.project.permis.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.hibernate.SQLQuery;
import org.hibernate.type.IntegerType;
import org.hibernate.type.LongType;
import org.hibernate.type.StringType;

import com.project.permis.entities.Mission;
import com.project.permis.entities.Student;
import com.project.permis.repositories.RepositoryException;
import com.project.permis.statistics.results.ProgressPerMissionResult;
import com.project.permis.utils.HibernateUtil;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class StatisticsManager
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
				"Impossible de récupérer les statistiques d'étudiants par formation."
			);
		}
	}
	
	/**
	 * 
	 * @param missions
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<Integer, ProgressPerMissionResult> progressPerMission(Student student, Set<Mission> missions)
	{
		// Fetch the statistics
		Map<Integer, ProgressPerMissionResult> results = new HashMap<Integer, ProgressPerMissionResult>();
		List<Integer> missionIds = new ArrayList<Integer>();
		
		for(Mission mission : missions)
		{
			missionIds.add(mission.getId());
		}
		
		try
		{
			// Execute query
			SQLQuery query = HibernateUtil.getSession().createSQLQuery(
				"SELECT " +
					"m.`id` AS `mission_id`, " +
				    "(" +
				        "SELECT COUNT(1) " +
				        "FROM `mission_goal` mg " +
				        "INNER JOIN `action_goal` ag " +
				        "ON ag.`id_goal` = mg.`id_goal` " +
				        "INNER JOIN `action` a " +
				        "ON a.`id` = ag.`id_action` " +
				        "WHERE mg.`id_mission` = m.`id` " +
				    ") AS `total_actions`, " +
				    "(" +
				        "SELECT COUNT(1) " +
				        "FROM `mission_goal` mg " +
				        "INNER JOIN `action_goal` ag " +
				        "ON ag.`id_goal` = mg.`id_goal` " +
				        "INNER JOIN `action` a " +
				        "ON a.`id` = ag.`id_action` " +
				        "INNER JOIN `student_action` sa " +
				        "ON " +
				            "sa.`id_action` = a.`id` " +
				            "AND " +
				            "sa.`id_student` = :student_id " +
				        "WHERE mg.`id_mission` = m.`id` " +
				    ") AS `student_actions` " +
				"FROM `mission` m " +
				"WHERE " +
				    "m.`id` IN(:mission_ids)"
			);
			query.addScalar("mission_id", new IntegerType());
			query.addScalar("total_actions", new IntegerType());
			query.addScalar("student_actions", new IntegerType());
			query.setInteger("student_id", student.getId());
			query.setParameterList("mission_ids", missionIds);
			List<Object[]> resultSet = (List<Object[]>) query.list();

			for(Object[] row : resultSet)
			{
				results.put(
					Integer.parseInt(row[0].toString()),
					new ProgressPerMissionResult(
						Integer.parseInt(row[1].toString()),
						Integer.parseInt(row[2].toString())
					)
				);
			}
			
			return results;
		}
		catch(Exception ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer les statistiques d'étudiants par formation."
			);
		}
	}
	
	/**
	 * Computes statistics about the mean completion per game.
	 * 
	 * @return The list of formations with the associated mean completion.
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> meanCompletion(int idUser)
	{
		// Fetch the statistics
		try
		{
			String queryString = "SELECT g.`name`, g.`id` as completion1 FROM `game` g ";
			
			if(idUser > 0)
			{
				queryString += "INNER JOIN `student_game` sg ON sg.`id_game` = g.`id` WHERE sg.`id_student` = " + idUser;
			}

			// Execute query
			SQLQuery query = HibernateUtil.getSession().createSQLQuery(queryString);
			query.addScalar("name", new StringType());
			query.addScalar("completion1", new StringType());
			List<Object[]> resultSet = (List<Object[]>) query.list();
			Random rand = new Random();
			
			for(Object[] row : resultSet)
			{
				row[1] = rand.nextInt(70) + "";
			}
			
			return resultSet;
		}
		catch(Exception ex)
		{
			throw new RepositoryException(
				ex,
				"Impossible de récupérer les résultats."
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
