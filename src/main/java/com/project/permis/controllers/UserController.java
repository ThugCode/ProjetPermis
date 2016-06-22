package com.project.permis.controllers;

import java.security.NoSuchAlgorithmException;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.permis.entities.Student;
import com.project.permis.repositories.StudentRepository;
import com.project.permis.utils.HashUtil;
import com.project.permis.utils.HibernateUtil;
import com.project.permis.validators.StudentValidator;

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
     * Initializes a binder with validators and editors.
     *
     * @param binder The binder to initialize.
     */
    @InitBinder
    protected void initBinder(WebDataBinder binder)
    {
        binder.setValidator(new StudentValidator());
    }
    
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView list()
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();
		StudentRepository repository = new StudentRepository();
		
		model.addAttribute("page", "Liste des utilisateurs");
		model.addAttribute("users", repository.fetchAll());
		model.addAttribute("_flashes", this.getAndClearFlashList());
		
		return this.render("user/list", model);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users/add", method = RequestMethod.GET)
	public ModelAndView add()
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Build model
		ModelMap model = new ModelMap();
		model.addAttribute("page", "Ajouter un utilisateur");
		model.addAttribute("_form", new Student());
		
		return this.render("user/form", model);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/users/modify/{id}", method = RequestMethod.GET)
	public ModelAndView modify(@PathVariable int id)
	{
		// Check if the user is logged in
    	if(!this.isLoggedIn())
    	{
    		return this.redirect("/login");
    	}
    	
    	// Initialize vars
        StudentRepository repository = new StudentRepository();
        Student student = repository.fetch(id);

        if(student != null)
        {
        	// Erase password
        	student.setPassword("");
        	
            // Build model
            ModelMap model = new ModelMap();
            model.addAttribute("page", "Éditer un utilisateur");
            model.addAttribute("_form", student);

            return this.render("user/form", model);
        }
        else
        {
            // Register a flash message
            this.addFlash(
                "danger",
                String.format(
                    "Il n'existe aucun utilisateur ayant pour identifiant <strong>%d</strong>.",
                    id
                )
            );

            return this.redirect("/users");
        }
	}
	
	/**
	 * 
	 * @param student
	 * @param result
	 * @return
	 */
	@RequestMapping(value="/users/submit", method=RequestMethod.POST)
    public ModelAndView submit(
        @ModelAttribute("_form") @Validated Student student,
        BindingResult result,
        @RequestParam(value="passwordConfirmation", required=false) String passwordConfirmation
    )
    {
		if(null == student.getId())
		{
			// Check the password is equal to its confirmation
			if(null == passwordConfirmation || passwordConfirmation.isEmpty())
			{
				result.rejectValue("password", null, "Vous devez confirmer le mot de passe.");
			}
			else if(!student.getPassword().equals(passwordConfirmation))
			{
				result.rejectValue("password", null, "Le mot de passe et sa confirmation sont différents.");
			}
			
			// Hash the password
			try
	    	{
				student.setPassword(HashUtil.sha256(student.getMail() + student.getPassword()));
			}
	    	catch(NoSuchAlgorithmException e)
	    	{
				result.rejectValue("password", null, "Impossible d'enregistrer votre mot de passe.");
			}
		}
		else
		{
			// The user already exists
			if(!student.getPassword().isEmpty() && (null != passwordConfirmation && !passwordConfirmation.isEmpty()))
			{
				// The user wants to change the password
				if(student.getPassword().equals(passwordConfirmation))
				{
					// Hash the password
					try
			    	{
						student.setPassword(HashUtil.sha256(student.getMail() + student.getPassword()));
					}
			    	catch(NoSuchAlgorithmException e)
			    	{
						result.rejectValue("password", null, "Impossible d'enregistrer votre mot de passe.");
					}
				}
				else
				{
					result.rejectValue("password", null, "Le mot de passe et sa confirmation sont différents.");
				}
			}
			else if(student.getPassword().isEmpty() && (null != passwordConfirmation && !passwordConfirmation.isEmpty()))
			{
				// The password is missing
				result.rejectValue("password", null, "Vous devez renseigner le mot de passe.");
			}
			else if(!student.getPassword().isEmpty() && (null == passwordConfirmation || passwordConfirmation.isEmpty()))
			{
				// The confirmation is missing
				result.rejectValue("password", null, "Vous devez confirmer le mot de passe.");
			}
			else
			{
				// No password modifications
				StudentRepository repository = new StudentRepository();
				Student actualStudent = repository.fetch(student.getId());
				
				// Detach the actual student from the Hibernate session so as to be
				// able to update them with the other student
				HibernateUtil.getSession().evict(actualStudent);
				student.setPassword(actualStudent.getPassword());
			}
		}
		
        if(!result.hasErrors())
        {
            // Save the student
            StudentRepository repository = new StudentRepository();
            repository.save(student);

            // Then, register a flash message
            this.addFlash(
                "success",
                String.format(
                    "L'utilisateur nommé <strong>%s %s</strong> a été sauvegardé.",
                    StringEscapeUtils.escapeHtml(student.getFirstname()),
                    StringEscapeUtils.escapeHtml(student.getLastname())
                )
            );

            // Finally, redirect user
            return this.redirect("/users");
        }
        else
        {
            // Populate model
            ModelMap model = new ModelMap();
            model.addAttribute("_form", student);
            model.addAttribute(
        		"page",
        		student.getId() == null ? "Ajouter un utilisateur" : "Éditer un utilisateur"
			);

            return this.render("user/form", model);
        }
    }
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/users/delete/{id}", method=RequestMethod.GET)
    public ModelAndView delete(@PathVariable int id)
    {
        // Initialize vars
        StudentRepository repository = new StudentRepository();
        Student student = repository.fetch(id);

        if(student != null)
        {
            // Delete the user
            repository.delete(student);

            // Then, register a flash message
            this.addFlash(
                "success",
                String.format(
                    "L'utilisateur nommé <strong>%s %s</strong> a été supprimé.",
                    StringEscapeUtils.escapeHtml(student.getFirstname()),
                    StringEscapeUtils.escapeHtml(student.getLastname())
                )
            );

        }
        else
        {
            // Register a flash message
            this.addFlash(
                "danger",
                String.format(
                    "Il n'existe aucun utilisateur ayant pour identifiant <strong>%d</strong>.",
                    id
                )
            );
        }

        // Finally, redirect user
        return this.redirect("/users");
    }
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/users/enable/{id}", method=RequestMethod.GET)
    public ModelAndView enable(@PathVariable int id)
    {
        // Initialize vars
        StudentRepository repository = new StudentRepository();
        Student student = repository.fetch(id);

        if(student != null)
        {
        	if(!student.isIsEnabled())
        	{
        		// Enable the user
        		student.setIsEnabled(true);
        		repository.save(student);
        		
        		// Then, register a flash message
        		this.addFlash(
                    "success",
                    String.format(
                        "L'utilisateur nommé <strong>%s %s</strong> a été activé.",
                        StringEscapeUtils.escapeHtml(student.getFirstname()),
                        StringEscapeUtils.escapeHtml(student.getLastname())
                    )
                );
        	}
        	else
        	{
        		this.addFlash(
	                "warning",
	                String.format(
	                    "L'utilisateur nommé <strong>%s %s</strong> a déjà été activé.",
	                    StringEscapeUtils.escapeHtml(student.getFirstname()),
	                    StringEscapeUtils.escapeHtml(student.getLastname())
	                )
	            );
        	}
        }
        else
        {
            // Register a flash message
            this.addFlash(
                "danger",
                String.format(
                    "Il n'existe aucun utilisateur ayant pour identifiant <strong>%d</strong>.",
                    id
                )
            );
        }

        // Finally, redirect user
        return this.redirect("/users");
    }
}
