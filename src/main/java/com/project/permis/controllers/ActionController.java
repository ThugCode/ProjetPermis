package com.project.permis.controllers;

import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.permis.entities.Action;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
@Controller
public class ActionController extends AbstractController
{
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/actions", method = RequestMethod.GET)
	public ModelAndView list()
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();
		model.addAttribute("page", "Liste des actions");
		
		HashSet<Action> actions = new HashSet<Action>();
		model.addAttribute("actions", actions);
		
		for(int i = 0; i < 40; i++)
		{
			Action add = new Action();
			add.setName("Action " + i);
			actions.add(add);
		}
		
		return this.render("action/list", model);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/actions/add", method = RequestMethod.GET)
	public ModelAndView addGoal()
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();
		model.addAttribute("page", "Ajouter une action");
		
		return this.render("action/form", model);
	}
}
