package com.project.permis.controllers;

import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.permis.entities.Action;
import com.project.permis.entities.Calendar;
import com.project.permis.entities.Game;
import com.project.permis.entities.Goal;
import com.project.permis.entities.Mission;
import com.project.permis.entities.StudentAction;
import com.project.permis.entities.StudentActionId;
import com.project.permis.repositories.GameRepository;
import com.project.permis.repositories.MissionRepository;
import com.project.permis.repositories.StudentActionRepository;
import com.project.permis.statistics.StatisticsManager;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
@Controller
public class MyGameController extends AbstractController
{
	private int currentGameId;
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/mygames", method = RequestMethod.GET)
	public ModelAndView list()
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();
		
		model.addAttribute("page", "Mes formations");
		model.addAttribute("games", this.getUser().getGames());
		
		return this.render("mygame/list", model);
	}
	
	/**
	 * 
	 * @return 
	 */
	@RequestMapping(value = "/mygames/{id}", method = RequestMethod.GET)
	public ModelAndView practice(@PathVariable("id")int id)
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	currentGameId = id;
    	
    	// Build model
    	GameRepository gameRepository = new GameRepository();
    	Game game = gameRepository.fetch(id);
    	StatisticsManager statisticsManager = new StatisticsManager();
		ModelMap model = new ModelMap();
		
		model.addAttribute("game", game);
		model.addAttribute("page", StringEscapeUtils.escapeHtml(game.getName()));
		model.addAttribute("progress", statisticsManager.progressPerMission(this.getUser(), game.getMissions()));
		
		return this.render("mygame/view", model);
	}
	
	/**
	 * 
	 * @return 
	 */
	@RequestMapping(value = "/mygames/mission/{id}", method = RequestMethod.GET)
	public ModelAndView mission(@PathVariable("id")int id)
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
    	MissionRepository missionRepository = new MissionRepository();
    	Mission mission = missionRepository.fetch(id);
    	
    	StudentActionRepository asRepository = new StudentActionRepository();
    	for(Goal goal : (Set<Goal>)mission.getGoals()) {
    		for(Action action : (Set<Action>)goal.getActions()) {
    			StudentActionId key = new StudentActionId();
    			StudentAction studentAction = new StudentAction();
    			studentAction.setId(key);
    			studentAction.setStudent(this.getUser());
    			studentAction.setAction(action);
    			studentAction.setCalendar(new Calendar());
    			studentAction.setValue(100);
    			asRepository.save(studentAction);
        	}
    	}
		
		return this.redirect("/mygames/"+currentGameId);
	}
}
