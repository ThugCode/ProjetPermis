package com.project.permis.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.permis.entities.LogLogins;
import com.project.permis.repositories.LogLoginsRepository;
import com.project.permis.statistics.StatisticsManager;

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
    	StatisticsManager sRepository = new StatisticsManager();
    	LogLoginsRepository lRepository = new LogLoginsRepository();
    	
    	List<LogLogins> loginData;
    	List<Object[]> studentPerGame;
    	List<Object[]> meanCompletion;
    	int totalCompletion;
    	
    	if(this.isAdmin()) {
    		loginData = lRepository.fetchLast(10, -1);
    		studentPerGame = sRepository.studentsPerGame();
    		meanCompletion = sRepository.meanCompletion(-1);
    		totalCompletion = -1;
    	} else {
    		loginData = lRepository.fetchLast(10, this.getUser().getId());
    		studentPerGame = null;
    		meanCompletion = sRepository.meanCompletion(this.getUser().getId());
    		totalCompletion = 10;
    	}
    	
    	
        ModelMap model = new ModelMap();
        
        model.addAttribute("page", "Statistiques");
        model.addAttribute("studentsPerGameData", studentPerGame);
        model.addAttribute("loginData", loginData);
        model.addAttribute("meanCompletion", meanCompletion);
        model.addAttribute("totalCompletion", totalCompletion);
        
        return this.render("static/home", model);
    }
}
