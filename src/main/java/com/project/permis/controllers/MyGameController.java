package com.project.permis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.project.permis.entities.Game;
import com.project.permis.repositories.GameRepository;

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
    	
    	// Build model
		ModelMap model = new ModelMap();
		GameRepository gameRepository = new GameRepository();
		
		Game game = gameRepository.fetch(id);
		
		model.addAttribute("game", game);
		model.addAttribute("page", "Épreuve");
		
		return this.render("mygame/view", model);
	}
}
