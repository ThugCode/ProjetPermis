package com.project.permis.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.permis.entities.Action;
import com.project.permis.entities.Goal;
import com.project.permis.repositories.ActionRepository;
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
    	GoalRepository repository = new GoalRepository();
		ModelMap model = new ModelMap();
		
		model.addAttribute("page", "Liste des objectifs");
		model.addAttribute("goals", repository.fetchAll());
		model.addAttribute("_flashes", this.getAndClearFlashList());
		
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
    	ActionRepository aRepository = new ActionRepository();
		ModelMap model = new ModelMap();
		
		model.addAttribute("page", "Ajouter un objectif");
		model.addAttribute("buttonSubmit", "Créer");model.addAttribute("actions", aRepository.fetchAll());
		
		return this.render("goal/form", model);
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param actions
	 * @return
	 */
	@RequestMapping(value = "/goals/add", method = RequestMethod.POST)
	public ModelAndView validateGoal(
		@RequestParam(value="inputId", required=false) String id,
		@RequestParam(value="inputName", required=true) String name,
		@RequestParam(value="inputActions", required=true) String actions
	)
	{
		// Check if the user is logged in
		if(!this.isLoggedIn())
		{
			return this.redirect("/login");
		}
		
		// Build goal
		Goal goal = new Goal();
		String fact = "ajouté";
		
		if(null != id && !id.isEmpty())
		{
			goal.setId(Integer.parseInt(id));
			fact = "modifié";
		}
		
		goal.setName(name);
		
		// Set new list of actions
		Set<Action> setActions = new HashSet<Action>();
		
		if(actions != null && actions !="")
		{
			ActionRepository aRepository = new ActionRepository();
			String[] ids = actions.split("x");
			Action addedAction = null;
			
			for(int i = 0; i < ids.length; i++)
			{
				addedAction = aRepository.fetch(Integer.parseInt(ids[i]));
				setActions.add(addedAction);
			}
		}
		
		goal.setActions(setActions);
		
		// Then, save it
		GoalRepository repository = new GoalRepository();
		repository.save(goal);

		// And inform the user
		this.addFlash("success", "Objectif " + fact + " avec succès");
		
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
    	GoalRepository gRepository = new GoalRepository();
    	ActionRepository aRepository = new ActionRepository();
		ModelMap model = new ModelMap();
		
		model.addAttribute("goal", gRepository.fetch(id));
		model.addAttribute("buttonSubmit", "Modifier");
		model.addAttribute("actions", aRepository.fetchAll());
		
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
		
    	// Delete the goal
		GoalRepository repository = new GoalRepository();
		repository.delete(repository.fetch(id));
		
		// Then, inform the user
		this.addFlash("success", "Objectif supprimé avec succès");
		
		return this.redirect("/goals/");
	}
}
