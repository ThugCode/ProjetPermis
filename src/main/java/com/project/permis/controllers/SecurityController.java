package com.project.permis.controllers;

import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login()
	{
		return this.render("security/login");
	}
	
	/**
	 * Handles the login process.
	 * 
	 * @param email The entered email.
	 * @param password The entered password.
	 * @param rememberMe The "Remember me" checkbox.
	 * @return
	 * @todo Handles "Remember me" checkbox.
	 */
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView doLogin(
		@RequestParam(value="email", required=false) String email,
		@RequestParam(value="password", required=false) String password,
		@RequestParam(value="remember_me", required=false) boolean rememberMe
	)
	{
		// Initialize vars
		ModelMap model = new ModelMap();
		boolean errorHappened = false;
		Pattern emailPattern = Pattern.compile(
	        "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])",
	        Pattern.CASE_INSENSITIVE
	    );
		
		// Check email address
		if(null == email || email.isEmpty())
		{
			errorHappened = true;
			model.addAttribute("_error_email", "Vous devez renseigner votre adresse email.");
		}
		else
		{
			Matcher emailMatcher = emailPattern.matcher(email);
			
			if(!emailMatcher.matches())
			{
				errorHappened = true;
				model.addAttribute("_error_email", "Le format de votre adresse email est invalide.");
			}
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
				try
				{
					if(user.getPassword().equals(HashUtil.sha256(email + password)))
					{
						// Password is valid, save user's id
						HttpSession session = this.request.getSession();
						session.setAttribute("_user_id", user.getId());
						
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
				// This user doesn't exist
				model.addAttribute("_error_email", "Aucun compte n'est associé à cette adresse email");
			}
		}

		// Register last entered values
		model.addAttribute("_last_email", email);
		model.addAttribute("_remember_me", rememberMe);
		
		return this.render("security/login", model);
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register()
	{
		return this.render("security/register");
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView doRegister()
	{
		return this.redirect("register");
	}
	
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public ModelAndView logout()
	{
		if(this.isLoggedIn())
		{
			// Remove user's id from the session
			HttpSession session = this.request.getSession();
			session.removeAttribute("_user_id");
		}

		return this.redirect("login");
	}
}
