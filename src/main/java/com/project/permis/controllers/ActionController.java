package com.project.permis.controllers;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.project.permis.entities.Action;
import com.project.permis.repositories.ActionRepository;
import com.project.permis.validators.ActionValidator;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
@Controller
public class ActionController extends AbstractController
{
	/**
     * Initializes a binder with validators and editors.
     *
     * @param binder The binder to initialize.
     */
    @InitBinder("_form")
    protected void initBinder(WebDataBinder binder)
    {
        binder.setValidator(new ActionValidator());
    }
    
    /**
     * Displays a list of actions.
     * 
     * @return The view to display.
     */
    @RequestMapping(value = "/actions", method = RequestMethod.GET)
    public ModelAndView list()
    {
        // Check if the user is logged in
        if(!this.isLoggedIn())
        {
            return this.redirect("/login");
        }
        
        // Build model
        ActionRepository repository = new ActionRepository();
        ModelMap model = new ModelMap();
        
        model.addAttribute("page", "Liste des actions");
        model.addAttribute("_flashes", this.getAndClearFlashList());
        model.addAttribute("actions", repository.fetchAll());
        
        return this.render("action/list", model);
    }
    
    /**
     * Displays a form to add an action.
     * 
     * @return The view to display.
     */
    @RequestMapping(value = "/actions/add", method = RequestMethod.GET)
    public ModelAndView add()
    {
        // Check if the user is logged in
        if(!this.isLoggedIn())
        {
            return this.redirect("/login");
        }
        
        // Build model
        ModelMap model = new ModelMap();
        
        model.addAttribute("page", "Ajouter une action");
        model.addAttribute("buttonSubmit", "Créer");
        model.addAttribute("_form", new Action());
        
        return this.render("action/form", model);
    }
    
    /**
     * Displays a form to modify an action.
     * 
     * @param id The action's id.
     * @return The view to display.
     */
    @RequestMapping(value = "/actions/modify/{id}", method = RequestMethod.GET)
    public ModelAndView modify(@PathVariable("id") int id)
    {
        // Check if the user is logged in
        if(!this.isLoggedIn())
        {
            return this.redirect("/login");
        }
        
        // Initialize vars	
        ActionRepository repository = new ActionRepository();
        Action action = repository.fetch(id);

        if(action != null)
        {
            // Build model
            ModelMap model = new ModelMap();
            model.addAttribute("page", "Éditer une action");
            model.addAttribute("buttonSubmit", "Modifier");
            model.addAttribute("_form", action);

            return this.render("action/form", model);
        }
        else
        {
            // Register a flash message
            this.addFlash(
                "danger",
                String.format(
                    "Il n'existe aucune action ayant pour identifiant <strong>%d</strong>.",
                    id
                )
            );

            return this.redirect("/actions");
        }
    }
    
    /**
     * Handles the submission of a form to add or modify an action.
     * 
     * @param action The action to save.
     * @param result The validation results.
     * @return The view to display or to use to redirect.
     */
    @RequestMapping(value = "/actions/submit", method = RequestMethod.POST)
    public ModelAndView submit(
		@ModelAttribute("_form") @Validated Action action,
        BindingResult result
    )
    {
    	// Check if the user is logged in
        if(!this.isLoggedIn())
        {
            return this.redirect("/login");
        }
        
        if(!result.hasErrors())
        {
            // Save the action
            ActionRepository repository = new ActionRepository();
            repository.save(action);

            // Then, register a flash message
            this.addFlash(
                "success",
                String.format(
                    "L'action <strong>%s</strong> a été sauvegardée.",
                    StringEscapeUtils.escapeHtml(action.getName())
                )
            );

            // Finally, redirect user
            return this.redirect("/actions");
        }
        else
        {
            // Populate model
            ModelMap model = new ModelMap();
            model.addAttribute("_form", action);

            if(null == action.getId())
            {
            	model.addAttribute("page", "Ajouter une action");
                model.addAttribute("buttonSubmit", "Créer");
            }
            else
            {
                model.addAttribute("page", "Éditer une action");
                model.addAttribute("buttonSubmit", "Modifier");
            }

            return this.render("adherents/form", model);
        }
    }
    
    /**
     * Handles the deletion of an action.
     * 
     * @param id The action's id.
     * @return The view to use to redirect.
     */
    @RequestMapping(value = "/actions/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") int id)
    {
        // Check if the user is logged in
        if(!this.isLoggedIn())
        {
            return this.redirect("/login");
        }
        
        // Initialize vars
        ActionRepository repository = new ActionRepository();
        Action action = repository.fetch(id);

        if(action != null)
        {
            // Delete the action
            repository.delete(action);

            // Then, register a flash message
            this.addFlash(
                "success",
                String.format(
                    "L'action <strong>%s</strong> a été supprimée.",
                    StringEscapeUtils.escapeHtml(action.getName())
                )
            );

        }
        else
        {
            // Register a flash message
            this.addFlash(
                "danger",
                String.format(
                    "Il n'existe aucune action ayant pour identifiant <strong>%d</strong>.",
                    id
                )
            );
        }

        // Finally, redirect user
        return this.redirect("/actions");
    }
}
