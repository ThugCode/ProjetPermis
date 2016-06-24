package com.project.permis.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.permis.entities.LogLogins;
import com.project.permis.entities.Student;
import com.project.permis.repositories.LogLoginsRepository;
import com.project.permis.repositories.StudentRepository;
import com.project.permis.utils.EmailUtil;
import com.project.permis.utils.HashUtil;

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
	/**
	 * Displays the login form.
	 * 
	 * @return The view to display.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login()
	{
		return this.isLoggedIn() ? this.redirect("/") : this.render("security/login");
	}
	
	/**
	 * Handles the login process.
	 * 
	 * @param email The entered email.
	 * @param password The entered password.
	 * @param rememberMe The "Remember me" checkbox.
	 * @return The view to display or a redirection response.
	 * @todo Handles "Remember me" checkbox.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(
		@RequestParam(value="email", required=false) String email,
		@RequestParam(value="password", required=false) String password,
		@RequestParam(value="remember_me", required=false) boolean rememberMe
	)
	{
		if(this.isLoggedIn())
		{
			// The user is already logged in, redirect them to the home page
			return this.redirect("/");
		}
		
		// Initialize vars
		ModelMap model = new ModelMap();
		boolean errorHappened = false;
		
		// Check email address
		if(null == email || email.isEmpty())
		{
			errorHappened = true;
			model.addAttribute("_error_email", "Vous devez renseigner votre adresse email.");
		}
		else if(!EmailUtil.isEmail(email))
		{
			errorHappened = true;
			model.addAttribute("_error_email", "Le format de votre adresse email est invalide.");
		}
		
		// Check password
		if(null == password || password.isEmpty())
		{
			errorHappened = true;
			model.addAttribute("_error_password", "Vous devez renseigner votre mot de passe.");
		}
		
		if(!errorHappened)
		{
			// Try finding this user
			StudentRepository userRepository = new StudentRepository();
			Student user = userRepository.findByMail(email);
			
			if(null != user)
			{
				// This user does exist
				if(user.isIsEnabled())
				{
					try
					{
						if(user.getPassword().equals(HashUtil.sha256(email + password)))
						{
							// Password is valid, save user's relevant data
							this.startSession(user);
							
							// Register login date
							LogLoginsRepository loginLogRepository = new LogLoginsRepository();
							loginLogRepository.save(new LogLogins(user, new Date()));
							
							return this.redirect("/");
						}
						else
						{
							// Password is invalid
							model.addAttribute("_error_password", "Ce mot de passe est incorrect.");
						}
					}
					catch(NoSuchAlgorithmException e)
					{
						// Password can't be hashed
						model.addAttribute("_error_password", "Impossible de vérifier votre mot de passe.");
					}
				}
				else
				{
					// This user isn't enabled yet
					model.addAttribute("_error_email", "Le compte associé à cette adresse email n'est pas encore activé.");
				}
			}
			else
			{
				// This user doesn't exist
				model.addAttribute("_error_email", "Aucun compte n'est associé à cette adresse email.");
			}
		}

		// Register last entered values
		model.addAttribute("_last_email", email);
		model.addAttribute("_remember_me", rememberMe);
		
		return this.render("security/login", model);
	}
	
	/**
	 * Displays the register form.
	 * 
	 * @return The view to display.
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register()
	{
		return this.isLoggedIn() ? this.redirect("/") : this.render("security/register");
	}
	
	/**
	 * Handles the register process.
	 * 
	 * @return The view to display or a redirection response.
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView doRegister()
	{
		return this.redirect("register");
	}
	
	/**
	 * Handles the logout process.
	 * 
	 * @return The redirection response.
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout()
	{
		if(this.isLoggedIn())
		{
			this.closeSession();
		}

		return this.redirect("login");
	}
}
