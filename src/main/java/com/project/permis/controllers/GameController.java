package com.project.permis.controllers;

import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.permis.entities.Game;
import com.project.permis.entities.Mission;
import com.project.permis.entities.Student;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
@Controller
public class GameController extends AbstractController
{
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public ModelAndView list()
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();		
		model.addAttribute("page", "Liste des épreuves");
		
		HashSet<Game> games = new HashSet<Game>();
		model.addAttribute("games", games);
		
		for(int i = 0; i < 40; i++)
		{
			Game add = new Game();
			add.setName("game " + i);
			
			HashSet<Mission> missions = new HashSet<Mission>();
			missions.add(new Mission("Mission", null, null));
			add.setMissions(missions);
			
			HashSet<Student> students = new HashSet<Student>();
			students.add(new Student());
			add.setStudents(students);
			
			games.add(add);
		}
		
		return this.render("game/list", model);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/games/add", method = RequestMethod.GET)
	public ModelAndView addMission()
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();
		model.addAttribute("page", "Ajouter une épreuve");
		
		return this.render("game/form", model);
	}
}
