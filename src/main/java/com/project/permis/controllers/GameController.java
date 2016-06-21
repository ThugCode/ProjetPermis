package com.project.permis.controllers;

import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
import com.project.permis.validators.GameValidator;

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
     * Initializes a binder with validators and editors to work
     * with games.
     *
     * @param binder The binder to initialize.
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        // binder.setValidator(new GameValidator());
    }
    
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
		ModelMap model = new ModelMap();		
		model.addAttribute("page", "Liste des épreuves");
		
		GameRepository repository = new GameRepository();
		model.addAttribute("games", repository.fetchAll());
		
		model.addAttribute("successMessage", this.successMessage);
		this.successMessage = null;
		
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
		ModelMap model = new ModelMap();
		model.addAttribute("page", "Ajouter une épreuve");
		model.addAttribute("buttonSubmit", "Créer");
		
		MissionRepository mRepository = new MissionRepository();
		model.addAttribute("missions", mRepository.fetchAll());
		
		StudentRepository sRepository = new StudentRepository();
		model.addAttribute("users", sRepository.fetchAll());
		
		return this.render("game/form", model);
	}
	
	@RequestMapping(value = "/games/add", method = RequestMethod.POST)
	public ModelAndView validateGame(
		@RequestParam(value="inputId", required=false) String id,
		@RequestParam(value="inputName", required=true) String name,
		@RequestParam(value="inputFile", required=true) String image,
		@RequestParam(value="inputMissions", required=false) String missions,
		@RequestParam(value="inputUsers", required=false) String users
	)
	{
		if(!this.isLoggedIn())
		{
			return this.redirect("/login");
		}
		
		GameRepository repository = new GameRepository();
		Game game = new Game();
		String fact = "ajoutée";
		if(id != null && id != "") {
			game = repository.fetch(Integer.parseInt(id));
			fact = "modifiée";
		}
		game.setName(name);
		
		if(image != null && image != "") {
			game.setImage(image);
		}
		
		//Set new list of missions
		HashSet<Mission> setMissions = new HashSet<Mission>();
		if(missions != null && missions !="") {
			MissionRepository mRepository = new MissionRepository();
			String[] ids = missions.split("x");
			for (int i = 0; i < ids.length; i++) {
				setMissions.add(mRepository.fetch(Integer.parseInt(ids[i])));
			}
		}
		game.setMissions(setMissions);
		
		//Set new list of users
		HashSet<Student> setUsers = new HashSet<Student>();
		if(users != null && users !="") {
			StudentRepository uRepository = new StudentRepository();
			String[] ids = users.split("x");
			for (int i = 0; i < ids.length; i++) {
				setUsers.add(uRepository.fetch(Integer.parseInt(ids[i])));
			}
		}
		game.setStudents(setUsers);
		
		//Save new game
		repository.save(game);

		this.successMessage = "Epreuve "+fact+" avec succès";
		
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
		ModelMap model = new ModelMap();
		
		GameRepository repository = new GameRepository();
		model.addAttribute("game", repository.fetch(id));
		model.addAttribute("buttonSubmit", "Modifier");
		
		MissionRepository mRepository = new MissionRepository();
		model.addAttribute("missions", mRepository.fetchAll());
		
		StudentRepository sRepository = new StudentRepository();
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
		
		GameRepository repository = new GameRepository();
		repository.delete(repository.fetch(id));
		
		this.successMessage = "Epreuve supprimée avec succès";
		
		return this.redirect("/games/");
	}
}
