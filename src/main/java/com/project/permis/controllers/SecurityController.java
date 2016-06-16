package com.project.permis.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
@Controller
public class SecurityController extends AbstractController
{
	private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login()
	{
		return this.render("security/login");
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin()
	{
		return this.redirect("login");
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register()
	{
		return this.render("security/register");
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView doRegister()
	{
		return this.redirect("register");
	}
}
