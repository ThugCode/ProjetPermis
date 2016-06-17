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
		ModelMap model = new ModelMap();
		
		model.addAttribute("page", "Utilisateurs");
		
		HashSet<Student> users = new HashSet<Student>();
		for(int i=0;i<40;i++) {
			Student add = new Student();
			add.setFirstname("Letourneur "+i);
			add.setLastname("Léo "+i);
			add.setMail("letourneur.leo@blabla");
			users.add(add);
		}
		
		model.addAttribute("users", users);
		
		return this.render("user/list", model);
	}
	
	@RequestMapping(value = "/users/add", method = RequestMethod.GET)
	public ModelAndView addUser()
	{
		ModelMap model = new ModelMap();
		
		model.addAttribute("page", "Ajouter un utilisateur");
		
		return this.render("user/form", model);
	}
}
