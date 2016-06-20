package com.project.permis.controllers;

import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.permis.entities.Goal;
import com.project.permis.repositories.GoalRepository;

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
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();
		model.addAttribute("page", "Liste des objectifs");
		
		GoalRepository repository = new GoalRepository();
		HashSet<Goal> goals = new HashSet<Goal>(repository.fetchAll());

		model.addAttribute("goals", goals);
		model.addAttribute("successMessage", this.successMessage);
		
		this.successMessage = null;
		
		return this.render("goal/list", model);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/goals/add", method = RequestMethod.GET)
	public ModelAndView addGoal()
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();
		model.addAttribute("page", "Ajouter un objectif");
		model.addAttribute("buttonSubmit", "Créer");
		
		return this.render("goal/form", model);
	}
	
	@RequestMapping(value = "/goals/add", method = RequestMethod.POST)
	public ModelAndView validateGoal(
		@RequestParam(value="inputId", required=false) String id,
		@RequestParam(value="inputName", required=true) String name
	)
	{
		if(!this.isLoggedIn())
		{
			return this.redirect("/login");
		}
		
		Goal goal = new Goal();
		String fact = "ajouté";
		if(id != null && id != "") {
			goal.setId(Integer.parseInt(id));
			fact = "modifié";
		}
		goal.setName(name);
		
		GoalRepository repository = new GoalRepository();
		repository.save(goal);

		this.successMessage = "Objectif "+fact+" avec succès";
		
		return this.redirect("/goals/");
	}
	
	/**
	 * 
	 * @return 
	 */
	@RequestMapping(value = "/goals/modify/{id}", method = RequestMethod.GET)
	public ModelAndView modifyGoal(@PathVariable("id")int id)
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();
		
		GoalRepository repository = new GoalRepository();
		model.addAttribute("goal", repository.fetch(id));
		model.addAttribute("buttonSubmit", "Modifier");
		
		return this.render("goal/form", model);
	}
	
	/**
	 * 
	 * @return 
	 */
	@RequestMapping(value = "/goals/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteGoal(@PathVariable("id")int id)
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
		
		GoalRepository repository = new GoalRepository();
		repository.delete(repository.fetch(id));
		
		this.successMessage = "Objectif supprimé avec succès";
		
		return this.redirect("/goals/");
	}
}
