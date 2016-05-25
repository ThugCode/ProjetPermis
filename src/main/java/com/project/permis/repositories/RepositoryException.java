package com.project.permis.repositories;

import com.project.permis.AbstractException;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author L�o Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Lo�c Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public class RepositoryException extends AbstractException
{
	/**
	 * {@inheritDoc}
	 */
	public RepositoryException(Exception ex, String message)
	{
		super(ex, message);
	}

	/**
	 * {@inheritDoc}
	 */
	public RepositoryException(Exception ex, String title, String message)
	{
		super(ex, title, message);
	}
}
