package com.project.permis.controllers;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringEscapeUtils;
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
	public ModelAndView add()
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
	 * @return 
	 */
	@RequestMapping(value = "/missions/modify/{id}", method = RequestMethod.GET)
	public ModelAndView modify(@PathVariable("id") int id)
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Initialize vars
    	MissionRepository mRepository = new MissionRepository();
        Mission mission = mRepository.fetch(id);

        if(mission != null)
        {
        	// Initialize additional vars
        	GoalRepository gRepository = new GoalRepository();
        	
            // Build model
            ModelMap model = new ModelMap();
            model.addAttribute("page", "Éditer une mission");
            model.addAttribute("buttonSubmit", "Modifier");
            // model.addAttribute("_form", mission);
            model.addAttribute("mission", mission);
            model.addAttribute("goals", gRepository.fetchAll());

            return this.render("mission/form", model);
        }
        else
        {
            // Register a flash message
            this.addFlash(
                "danger",
                String.format(
                    "Il n'existe aucune mission ayant pour identifiant <strong>%d</strong>.",
                    id
                )
            );

            return this.redirect("/missions");
        }
	}
	
	/**
	 * 
	 * @param id
	 * @param title
	 * @param goals
	 * @return
	 */
	@RequestMapping(value = "/missions/submit", method = RequestMethod.POST)
	public ModelAndView validate(
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
	@RequestMapping(value = "/missions/delete/{id}", method = RequestMethod.GET)
	public ModelAndView delete(@PathVariable("id") int id)
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
		
    	// Initialize vars
        MissionRepository repository = new MissionRepository();
        Mission mission = repository.fetch(id);

        if(mission != null)
        {
            // Delete the mission
            repository.delete(mission);

            // Then, register a flash message
            this.addFlash(
                "success",
                String.format(
                    "La mission <strong>%s</strong> a été supprimée.",
                    StringEscapeUtils.escapeHtml(mission.getTitle())
                )
            );

        }
        else
        {
            // Register a flash message
            this.addFlash(
                "danger",
                String.format(
                    "Il n'existe aucune mission ayant pour identifiant <strong>%d</strong>.",
                    id
                )
            );
        }

        // Finally, redirect user
        return this.redirect("/missions");
	}
}
