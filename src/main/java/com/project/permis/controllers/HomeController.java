package com.project.permis.controllers;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.permis.entities.Game;
import com.project.permis.entities.Student;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author L�o Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Lo�c Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
@Controller
public class HomeController extends AbstractController
{
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home(Locale locale)
	{
		logger.info("Welcome home! The client locale is {}.", locale);
		
		// Build model
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		ModelMap model = new ModelMap();
		model.addAttribute("serverTime", formattedDate);
		
		/*Données static en attendant les dynamiques*/
		HashSet<Game> games = new HashSet<Game>();
		Game a = new Game();
		a.setName("Formation 1");
		Game b = new Game();
		b.setName("Formation 2");
		Game c = new Game();
		c.setName("Formation 3");
		games.add(a);
		games.add(b);
		games.add(c);
		Student user = new Student();
		user.setId(-1);
		user.setFirstname("Leo");
		user.setLastname("Letourneur");
		user.setMail("letourneur.leo@gmail.com");
		user.setGames(games);
		/* Fin données statics*/
		
		model.addAttribute("user", user);
		
		model.addAttribute("page", "Statistiques");
		
		return this.render("static/home", model);
	}
}
