package com.project.permis.session;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class Flash
{
    /**
     * The flash message's type.
     */
    protected final String type;
    
    /**
     * The flash message's contents.
     */
    protected final String contents;
    
    /**
     * Creates a new flash message.
     * 
     * @param type The flash message's type.
     * @param contents The flash message's contents.
     */
    public Flash(String type, String contents)
    {
        this.type = type;
        this.contents = contents;
    }

    /**
     * Gets the flash message's type.
     * 
     * @return The flash message's type.
     */
    public String getType()
    {
        return this.type;
    }

    /**
     * Gets the flash message's contents.
     * 
     * @return The flash message's contents.
     */
    public String getContents()
    {
        return this.contents;
    }
}
