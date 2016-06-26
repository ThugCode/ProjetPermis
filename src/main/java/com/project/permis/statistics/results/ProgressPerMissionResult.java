package com.project.permis.statistics.results;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class ProgressPerMissionResult
{
	/**
	 * The total number of actions for a mission.
	 */
	protected int actionsNumber;
	
	/**
	 * The number of actions a user has carried out for a mission.
	 */
	protected int carriedOutActionsNumber;
	
	/**
	 * Creates a new result for a mission's progress.
	 * 
	 * @param actionsNumber The total number of actions for a mission.
	 * @param carriedOutActionsNumber The number of actions a user has carried out for a mission.
	 */
	public ProgressPerMissionResult(int actionsNumber, int carriedOutActionsNumber)
	{
		// Initialize properties
		this.actionsNumber = actionsNumber;
		this.carriedOutActionsNumber = carriedOutActionsNumber;
	}
	
	/**
	 * Gets the total number of actions for a mission.
	 * 
	 * @return The total number of actions for a mission.
	 */
	public int getActionsNumber()
	{
		return this.actionsNumber;
	}
	
	/**
	 * Gets the number of actions a user has carried out for a mission.
	 * 
	 * @return The number of actions a user has carried out for a mission.
	 */
	public int getCarriedOutActionsNumber()
	{
		return this.carriedOutActionsNumber;
	}
	
	/**
	 * Computes the percentage of progress for a mission.
	 * 
	 * @return The progress, in percentage, for a mission.
	 */
	public int getPercentage()
	{
		return 0 != this.actionsNumber ? (int) (((double) this.carriedOutActionsNumber / this.actionsNumber) * 100) : 0;
	}
}
