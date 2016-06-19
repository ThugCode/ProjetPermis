package com.project.permis.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.project.permis.AbstractException;
import com.project.permis.entities.Game;
import com.project.permis.entities.Message;
import com.project.permis.entities.Student;
import com.project.permis.repositories.StudentRepository;
import com.project.permis.session.Flash;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public abstract class AbstractController
{
    /**
     * The request sent to the server.
     */
    @Autowired
    protected HttpServletRequest request;
    
    /**
     * Renders a view whose name is <code>viewName</code> without any
     * model.
     * 
     * @param viewName The view's name.
     * @return The view only.
     */
    protected ModelAndView render(String viewName)
    {
        return this.render(viewName, new ModelMap());
    }
    
    /**
     * Renders a view whose name is <code>viewName</code> with an accompanying
     * model.
     * 
     * @param viewName The view's name.
     * @param model The accompanying model.
     * @return The view with its model.
     */
    protected ModelAndView render(String viewName, ModelMap model)
    {
        // Initialize vars
        /*
        Student user = this.getUser();
        
        // Append common data to model
        if(null != user)
        {
            model.addAttribute("_user_first_name", user.getFirstname());
            model.addAttribute("_user_last_name", user.getLastname());
            model.addAttribute("_user_email", user.getMail());
        }
        */
        
        /*Données static en attendant les dynamiques*/
        HashSet<Game> games = new HashSet<Game>();
        Game a = new Game();
        a.setName("Formation 1");
        Game b = new Game();
        b.setName("Formation 2");
        Game c = new Game();
        c.setName("Formation 3");
        games.add(a);
        games.add(b);
        games.add(c);
        
        HashSet<Message> messages = new HashSet<Message>();
        Message am = new Message();
        am.setSubject("Bienvenue");
        am.setBody("Bienvenue sur votre plateforme de formation AdN !");
        am.setRead(true);
        am.setDateReception(new Date());
        Message bm = new Message();
        bm.setSubject("Formation");
        bm.setBody("Vous avez été inscrit à une nouvelle formation : Formation 3.");
        bm.setRead(false);
        bm.setDateReception(new Date());
        Message cm = new Message();
        cm.setSubject("Message admin");
        cm.setBody("Votre formation est active pendant 6 mois.");
        cm.setRead(false);
        cm.setDateReception(new Date());
        messages.add(am);
        messages.add(bm);
        messages.add(cm);
        
        Student user = new Student();
        user.setId(-1);
        user.setFirstname("Leo");
        user.setLastname("Letourneur");
        user.setMail("letourneur.leo@gmail.com");
        user.setGames(games);
        user.setMessages(messages);
        /* Fin données statics*/
        
        model.addAttribute("user", this.getUser());
        
        return new ModelAndView(viewName, model);
    }
    
    /**
     * Redirects the user to the given URL.
     * 
     * @param url The URL to redirect to.
     * @return A redirection view.
     */
    protected ModelAndView redirect(String url)
    {
        return new ModelAndView(new RedirectView(url, true));
    }
    
    /**
     * Handles exceptions that haven't been caught yet.
     * 
     * @param ex The exception that occured.
     * @return A view to display informations about the exception.
     */
    @ExceptionHandler(AbstractException.class)
    public ModelAndView exceptionHandler(AbstractException ex)
    {
        ModelAndView modelAndView = new ModelAndView("error");
        
        modelAndView.addObject("customTitle", ex.getTitle());
        modelAndView.addObject("customMessage", ex.getMessage());
        modelAndView.addObject("errorMessage", ex.getCause().getMessage());
        modelAndView.addObject("stackTrace", ex.getCause().getStackTrace());
        
        return modelAndView;
    }
    
    /**
     * Creates the flash list if it doesn't exist yet and then returns it.
     * 
     * @return The flash list.
     */
    @SuppressWarnings("unchecked")
    protected List<Flash> getFlashList()
    {
        // Initialize vars
        Object flashListObject = this.request.getSession().getAttribute("_flashes");
        List<Flash> flashList;
        
        if(flashListObject != null && flashListObject instanceof List)
        {
            flashList = (List<Flash>) flashListObject;
        }
        else
        {
            flashList = new ArrayList<Flash>();
        }
        
        return flashList;
    }
    
    /**
     * Creates a copy of the current flash list before clearing it, then returns
     * the copy.
     * 
     * @return The flash list.
     */
    protected List<Flash> getAndClearFlashList()
    {
        // Initialize vars
        HttpSession session = this.request.getSession();
        List<Flash> currentFlashList = this.getFlashList();
        List<Flash> flashList = new ArrayList<Flash>(currentFlashList);
        
        // Erase the saved flash list
        currentFlashList.clear();
        session.setAttribute(
            "_flashes",
            currentFlashList
        );
        
        return flashList;
    }
    
    /**
     * Adds a flash message to the flash list.
     * 
     * @param type The flash message's type.
     * @param contents The flash message's contents.
     */
    protected void addFlash(String type, String contents)
    {
        // Initialize vars
        HttpSession session = this.request.getSession();
        List<Flash> flashList = this.getFlashList();
        
        // Add the flash message and memorize the new list
        flashList.add(new Flash(type, contents));
        session.setAttribute("_flashes", flashList);
    }
    
    /**
     * Gets the user instance if they are logged in.
     * 
     * @return The user or {@code null} if they aren't logged in.
     */
    protected Student getUser()
    {
        // Initialize vars
        HttpSession session = this.request.getSession();
        Object userId = session.getAttribute("_user_id");
        
        if(null != userId && userId instanceof Integer)
        {
            // Initialize additional vars
            int id = (Integer) userId;
            StudentRepository repository = new StudentRepository();
            
            return repository.fetch(id);
        }
        
        return null;
    }
    
    /**
     * Starts the session for a user by saving relevant data into it.
     *  
     * @param user The user.
     */
    public void startSession(Student user)
    {
    	// Initialize vars
        HttpSession session = this.request.getSession();
        
        // Register revelant data
        session.setAttribute("_user_id", user.getId());
    }
    
    /**
     * Closes the session for a user by removing the associated data.
     */
    protected void closeSession()
    {
    	// Initialize vars
        HttpSession session = this.request.getSession();
        
        // Register revelant data
        session.removeAttribute("_user_id");
    }
    
    /**
     * Tests if the user is logged in. If the user is logged in but no longer enabled,
     * then their session is closed.
     * 
     * @return {@code true} if the user is logged in, {@code false} otherwise.
     */
    protected boolean isLoggedIn()
    {
    	Student user = this.getUser();
    	
    	if(null != user)
    	{
    		if(user.isIsEnabled())
    		{
    			return true;
    		}
    		else
    		{
    			this.closeSession();
    		}
    	}
    	
        return false;
    }
}