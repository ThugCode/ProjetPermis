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

import com.project.permis.entities.Goal;
import com.project.permis.entities.Mission;
import com.project.permis.repositories.GoalRepository;
import com.project.permis.repositories.MissionRepository;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
@Controller
public class MissionController extends AbstractController
{
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/missions", method = RequestMethod.GET)
	public ModelAndView list()
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();
		MissionRepository repository = new MissionRepository();
		
		model.addAttribute("page", "Liste des missions");
		model.addAttribute("missions", repository.fetchAll());
		model.addAttribute("_flashes", this.getAndClearFlashList());
		
		return this.render("mission/list", model);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/missions/add", method = RequestMethod.GET)
	public ModelAndView addMission()
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();
		GoalRepository gRepository = new GoalRepository();
		
		model.addAttribute("page", "Ajouter une mission");
		model.addAttribute("buttonSubmit", "Créer");
		model.addAttribute("goals", gRepository.fetchAll());
		
		return this.render("mission/form", model);
	}
	
	/**
	 * 
	 * @param id
	 * @param title
	 * @param goals
	 * @return
	 */
	@RequestMapping(value = "/missions/add", method = RequestMethod.POST)
	public ModelAndView validateMission(
		@RequestParam(value="inputId", required=false) String id,
		@RequestParam(value="inputTitle", required=true) String title,
		@RequestParam(value="inputGoals", required=false) String goals
	)
	{
		// Check if the user is logged in
		if(!this.isLoggedIn())
		{
			return this.redirect("/login");
		}
		
		// Build mission
		Mission mission = new Mission();
		String fact = "ajoutée";
		
		if(null != id && !id.isEmpty())
		{
			mission.setId(Integer.parseInt(id));
			fact = "modifiée";
		}
		
		mission.setTitle(title);
		
		// Set new list of goals
		Set<Goal> setGoals = new HashSet<Goal>();
		
		if(goals != null && goals !="")
		{
			GoalRepository gRepository = new GoalRepository();
			String[] ids = goals.split("x");
			
			for(int i = 0; i < ids.length; i++)
			{
				setGoals.add(gRepository.fetch(Integer.parseInt(ids[i])));
			}
		}
		
		mission.setGoals(setGoals);
		
		// Then, save it
		MissionRepository repository = new MissionRepository();
		repository.save(mission);

		// And inform the user
		this.addFlash("success", "Mission " + fact + " avec succès");
		
		return this.redirect("/missions/");
	}
	
	/**
	 * 
	 * @return 
	 */
	@RequestMapping(value = "/missions/modify/{id}", method = RequestMethod.GET)
	public ModelAndView modifyMission(@PathVariable("id")int id)
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();
		MissionRepository mRepository = new MissionRepository();
		GoalRepository gRepository = new GoalRepository();
		
		model.addAttribute("mission", mRepository.fetch(id));
		model.addAttribute("buttonSubmit", "Modifier");
		model.addAttribute("goals", gRepository.fetchAll());
		
		return this.render("mission/form", model);
	}
	
	/**
	 * 
	 * @return 
	 */
	@RequestMapping(value = "/missions/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteMission(@PathVariable("id")int id)
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
		
    	// Delete the mission
		MissionRepository repository = new MissionRepository();
		repository.delete(repository.fetch(id));
		
		// Then, inform the user
		this.addFlash("success", "Mission supprimée avec succès");
		
		return this.redirect("/missions/");
	}
}
