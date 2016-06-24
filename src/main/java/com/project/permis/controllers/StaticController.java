package com.project.permis.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.permis.entities.LogLogins;
import com.project.permis.repositories.LogLoginsRepository;
import com.project.permis.repositories.StatisticsRepository;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
@Controller
public class StaticController extends AbstractController
{
    /**
     * Displays the home page with statistics.
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView home()
    {
    	// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
        // Build model
    	StatisticsRepository sRepository = new StatisticsRepository();
    	LogLoginsRepository lRepository = new LogLoginsRepository();
    	List<LogLogins> loginData = lRepository.fetchLast(10);
        ModelMap model = new ModelMap();
        
        model.addAttribute("page", "Statistiques");
        model.addAttribute("studentsPerGameData", sRepository.studentsPerGame());
        model.addAttribute("loginData", loginData);
        
        return this.render("static/home", model);
    }
}
