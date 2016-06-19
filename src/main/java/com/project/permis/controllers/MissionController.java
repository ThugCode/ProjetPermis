package com.project.permis.controllers;

import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.permis.entities.Goal;
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
public class MissionController extends AbstractController
{
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/missions", method = RequestMethod.GET)
	public ModelAndView list()
	{
		ModelMap model = new ModelMap();
		
		model.addAttribute("page", "Liste des missions");
		
		HashSet<Mission> missions = new HashSet<Mission>();
		for(int i=0;i<40;i++) {
			Mission add = new Mission();
			add.setTitle("mission "+i);
			
			HashSet<Goal> goals = new HashSet<Goal>();
			goals.add(new Goal("objectif", null, null));
			add.setGoals(goals);
			missions.add(add);
		}
		
		model.addAttribute("missions", missions);
		
		return this.render("mission/list", model);
	}
	
	@RequestMapping(value = "/missions/add", method = RequestMethod.GET)
	public ModelAndView addMission()
	{
		ModelMap model = new ModelMap();
		
		model.addAttribute("page", "Ajouter une mission");
		
		return this.render("mission/form", model);
	}
}
