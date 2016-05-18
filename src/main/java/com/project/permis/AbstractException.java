package com.project.permis;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public abstract class AbstractException extends RuntimeException
{
    /**
     * The title to be displayed on the page.
     */
    protected String title;
    
    /**
     * Creates a new abstract exception.
     * 
     * @param ex The actual exception that occured.
     * @param message The message to be displayed.
     */
    public AbstractException(Exception ex, String message)
    {
        this(ex, null, message);
    }
    
    /**
     * Creates a new abstract exception.
     * 
     * @param ex The actual exception that occured.
     * @param title The title to be displayed.
     * @param message The message to be displayed.
     */
    public AbstractException(Exception ex, String title, String message)
    {
        // Call super constructor
        super(message, ex);
        
        // Initialize properties
        this.title = title;
    }
    
    /**
     * Gets the title to be displayed.
     * 
     * @return The title.
     */
    public String getTitle()
    {
        return this.title;
    }
}
