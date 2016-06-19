package com.project.permis.controllers;

import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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
public class UserController extends AbstractController
{
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
		
		HashSet<Student> users = new HashSet<Student>();
		model.addAttribute("users", users);
		
		for(int i = 0; i < 40; i++)
		{
			Student add = new Student();
			add.setFirstname("Letourneur " + i);
			add.setLastname("Léo " + i);
			add.setMail("letourneur.leo@blabla");
			
			if(i % 10 == 0)
			{
				add.setIsEnabled(true);
			}
			
			users.add(add);
		}
		
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
