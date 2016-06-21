package com.project.permis.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.project.permis.repositories.StudentRepository;
import com.project.permis.validators.StudentValidator;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
@Controller
public class UserController extends AbstractController
{
	/**
     * Initializes a binder with validators and editors to work
     * with users.
     *
     * @param binder The binder to initialize.
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        // binder.setValidator(new StudentValidator());
    }
    
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView list()
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();
		model.addAttribute("page", "Liste des utilisateurs");
		
		StudentRepository repository = new StudentRepository();
		model.addAttribute("users", repository.fetchAll());
		
		return this.render("user/list", model);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users/add", method = RequestMethod.GET)
	public ModelAndView addUser()
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();
		model.addAttribute("page", "Ajouter un utilisateur");
		
		return this.render("user/form", model);
	}
}
