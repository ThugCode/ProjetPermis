package com.project.permis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.permis.entities.Action;
import com.project.permis.repositories.ActionRepository;

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
		
		ActionRepository repository = new ActionRepository();
		model.addAttribute("actions", repository.fetchAll());
		
		model.addAttribute("successMessage", this.successMessage);
		this.successMessage = null;
		
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
		model.addAttribute("buttonSubmit", "Créer");
		
		return this.render("action/form", model);
	}
	
	@RequestMapping(value = "/actions/add", method = RequestMethod.POST)
	public ModelAndView validateAction(
		@RequestParam(value="inputId", required=false) String id,
		@RequestParam(value="inputName", required=true) String name
	)
	{
		if(!this.isLoggedIn())
		{
			return this.redirect("/login");
		}
		
		Action action = new Action();
		String fact = "ajoutée";
		if(id != null && id != "") {
			action.setId(Integer.parseInt(id));
			fact = "modifiée";
		}
		action.setName(name);
		
		ActionRepository repository = new ActionRepository();
		repository.save(action);

		this.successMessage = "Action "+fact+" avec succès";
		
		return this.redirect("/actions/");
	}
	
	/**
	 * 
	 * @return 
	 */
	@RequestMapping(value = "/actions/modify/{id}", method = RequestMethod.GET)
	public ModelAndView modifyAction(@PathVariable("id")int id)
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();
		
		ActionRepository repository = new ActionRepository();
		model.addAttribute("action", repository.fetch(id));
		model.addAttribute("buttonSubmit", "Modifier");
		
		return this.render("action/form", model);
	}
	
	/**
	 * 
	 * @return 
	 */
	@RequestMapping(value = "/actions/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteAction(@PathVariable("id")int id)
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
		
		ActionRepository repository = new ActionRepository();
		repository.delete(repository.fetch(id));
		
		this.successMessage = "Action supprimée avec succès";
		
		return this.redirect("/actions/");
	}
}
