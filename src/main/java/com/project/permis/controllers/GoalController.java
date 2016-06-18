package com.project.permis.controllers;

import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.permis.entities.Goal;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
@Controller
public class GoalController extends AbstractController
{
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/goals", method = RequestMethod.GET)
	public ModelAndView list()
	{
		ModelMap model = new ModelMap();
		
		model.addAttribute("page", "Objectifs");
		
		HashSet<Goal> goals = new HashSet<Goal>();
		for(int i=0;i<40;i++) {
			Goal add = new Goal();
			add.setName("Objectif "+i);
			goals.add(add);
		}
		
		model.addAttribute("goals", goals);
		
		return this.render("goal/list", model);
	}
	
	@RequestMapping(value = "/goals/add", method = RequestMethod.GET)
	public ModelAndView addGoal()
	{
		ModelMap model = new ModelMap();
		
		model.addAttribute("page", "Ajouter un objectif");
		
		return this.render("goal/form", model);
	}
}
