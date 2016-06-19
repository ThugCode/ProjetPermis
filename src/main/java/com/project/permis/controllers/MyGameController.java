package com.project.permis.controllers;

import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.permis.entities.Game;
import com.project.permis.entities.Mission;

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
		
		HashSet<Game> games = new HashSet<Game>();
		model.addAttribute("games", games);
		
		for(int i = 0; i < 10; i++)
		{
			Game add = new Game();
			add.setId(i);
			add.setName("Game " + i);
			games.add(add);
		}
		
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
    	
    	// Build model
		ModelMap model = new ModelMap();
		
		Game game = new Game();
		game.setName("Game "+id);
		
		HashSet<Mission> missions = new HashSet<Mission>();
		missions.add(new Mission("Mission 1", null, null));
		missions.add(new Mission("Mission 2", null, null));
		missions.add(new Mission("Mission 3", null, null));
		game.setMissions(missions);
		
		model.addAttribute("game", game);
		model.addAttribute("page", "Épreuve");
		
		return this.render("mygame/view", model);
	}
}
