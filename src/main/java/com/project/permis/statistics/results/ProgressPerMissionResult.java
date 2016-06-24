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
	 * 
	 */
	protected int actionsNumber;
	
	/**
	 * 
	 */
	protected int carriedOutActionsNumber;
	
	/**
	 * 
	 * @param actionsNumber
	 * @param carriedOutActionsNumber
	 */
	public ProgressPerMissionResult(int actionsNumber, int carriedOutActionsNumber)
	{
		// Initialize properties
		this.actionsNumber = actionsNumber;
		this.carriedOutActionsNumber = carriedOutActionsNumber;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getActionsNumber()
	{
		return this.actionsNumber;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getCarriedOutActionsNumber()
	{
		return this.carriedOutActionsNumber;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPercentage()
	{
		return 0 != this.actionsNumber ? (int) (((double) this.carriedOutActionsNumber / this.actionsNumber) * 100) : 0;
	}
}
