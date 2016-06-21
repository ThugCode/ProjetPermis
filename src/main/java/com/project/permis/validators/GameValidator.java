package com.project.permis.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.project.permis.entities.Game;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class GameValidator implements Validator
{
    /**
     * Tests if this validator can be used for this class.
     *
     * @param type The class to test.
     * @return {@code true} if the validator supports this class,
     * {@code false} otherwise.
     */
    @Override
    public boolean supports(Class<?> type)
    {
        return Game.class.equals(type);
    }

    /**
     * Validates an object.
     *
     * @param target The object to validate.
     * @param errors The errors list.
     */
    @Override
    public void validate(Object target, Errors errors)
    {
        if(target instanceof Game)
        {
            // Common checks
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", null, "Vous devez renseigner le nom.");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "image", null, "Vous devez fournir l'URL d'une image.");
        }
    }
}
