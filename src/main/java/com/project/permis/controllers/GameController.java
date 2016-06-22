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

import com.project.permis.entities.Game;
import com.project.permis.entities.Mission;
import com.project.permis.entities.Student;
import com.project.permis.repositories.GameRepository;
import com.project.permis.repositories.MissionRepository;
import com.project.permis.repositories.StudentRepository;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
@Controller
public class GameController extends AbstractController
{
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/games", method = RequestMethod.GET)
	public ModelAndView list()
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
    	GameRepository repository = new GameRepository();
		ModelMap model = new ModelMap();
		
		model.addAttribute("page", "Liste des épreuves");
		model.addAttribute("_flashes", this.getAndClearFlashList());
		model.addAttribute("games", repository.fetchAll());
		
		return this.render("game/list", model);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/games/add", method = RequestMethod.GET)
	public ModelAndView addMission()
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
    	MissionRepository mRepository = new MissionRepository();
    	StudentRepository sRepository = new StudentRepository();
		ModelMap model = new ModelMap();
		
		model.addAttribute("page", "Ajouter une épreuve");
		model.addAttribute("buttonSubmit", "Créer");
		model.addAttribute("missions", mRepository.fetchAll());
		model.addAttribute("users", sRepository.fetchAll());
		
		return this.render("game/form", model);
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param image
	 * @param missions
	 * @param users
	 * @return
	 */
	@RequestMapping(value = "/games/add", method = RequestMethod.POST)
	public ModelAndView validateGame(
		@RequestParam(value="inputId", required=false) String id,
		@RequestParam(value="inputName", required=true) String name,
		@RequestParam(value="inputFile", required=true) String image,
		@RequestParam(value="inputMissions", required=false) String missions,
		@RequestParam(value="inputUsers", required=false) String users
	)
	{
		// Check if the user is logged in
		if(!this.isLoggedIn())
		{
			return this.redirect("/login");
		}
		
		// Build game
		GameRepository repository = new GameRepository();
		Game game = new Game();
		String fact = "ajoutée";
		
		if(null != id && !id.isEmpty())
		{
			game = repository.fetch(Integer.parseInt(id));
			fact = "modifiée";
		}
		
		game.setName(name);
		
		if(null != image && !image.isEmpty())
		{
			game.setImage(image);
		}
		
		// Set new list of missions
		Set<Mission> setMissions = new HashSet<Mission>();
		
		if(null != missions && !missions.isEmpty())
		{
			MissionRepository mRepository = new MissionRepository();
			String[] ids = missions.split("x");
			
			for(int i = 0; i < ids.length; i++)
			{
				setMissions.add(mRepository.fetch(Integer.parseInt(ids[i])));
			}
		}
		
		game.setMissions(setMissions);
		
		// Set new list of users
		Set<Student> setUsers = new HashSet<Student>();
		
		if(null != users && !users.isEmpty())
		{
			StudentRepository uRepository = new StudentRepository();
			String[] ids = users.split("x");
			
			for(int i = 0; i < ids.length; i++)
			{
				setUsers.add(uRepository.fetch(Integer.parseInt(ids[i])));
			}
		}
		
		game.setStudents(setUsers);
		
		// Then, save it
		repository.save(game);

		// And inform the user$
		this.addFlash("success", "Épreuve " + fact + " avec succès");
		
		return this.redirect("/games/");
	}
	
	/**
	 * 
	 * @return 
	 */
	@RequestMapping(value = "/games/modify/{id}", method = RequestMethod.GET)
	public ModelAndView modifyGame(@PathVariable("id")int id)
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
    	GameRepository gRepository = new GameRepository();
    	MissionRepository mRepository = new MissionRepository();
    	StudentRepository sRepository = new StudentRepository();
		ModelMap model = new ModelMap();
		
		model.addAttribute("game", gRepository.fetch(id));
		model.addAttribute("buttonSubmit", "Modifier");
		model.addAttribute("missions", mRepository.fetchAll());
		model.addAttribute("users", sRepository.fetchAll());
		
		return this.render("game/form", model);
	}
	
	/**
	 * 
	 * @return 
	 */
	@RequestMapping(value = "/games/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteMission(@PathVariable("id")int id)
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
		
    	// Delete the game
		GameRepository repository = new GameRepository();
		repository.delete(repository.fetch(id));
		
		// Then, inform the user
		this.addFlash("success", "Épreuve supprimée avec succès");
		
		return this.redirect("/games/");
	}
}
