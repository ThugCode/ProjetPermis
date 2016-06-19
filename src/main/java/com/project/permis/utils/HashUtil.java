package com.project.permis.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Bruno Buiret (bruno.buiret@etu.univ-lyon1.fr)
 * @author Léo Letourneur (leo.letourneur@etu.univ-lyon1.fr)
 * @author Thomas Arnaud (thomas.arnaud@etu.univ-lyon1.fr)
 * @author Karl Gorgoglione (karl.gorgoglione@etu.univ-lyon1.fr)
 * @author Loïc Gerland (loic.gerland@etu.univ-lyon1.fr)
 * @author Guillaume Ogier (guillaume.ogier@etu.univ-lyon1.fr)
 */
public abstract class HashUtil
{
	/**
	 * Hashes a string using the SHA-256 algorithm.
	 * 
	 * @param input The string to hash.
	 * @return The hashed string.
	 * @throws NoSuchAlgorithmException If the SHA-256 algorithm can't be used.
	 */
	public static String sha256(String input)
	throws NoSuchAlgorithmException
	{
		// Initialize vars
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		StringBuilder hashBuilder = new StringBuilder();
		
		// Perform hash
		byte[] hashBytes = digest.digest(input.getBytes(StandardCharsets.UTF_8));
		
		for(byte hashByte : hashBytes)
		{
			hashBuilder.append(String.format("%02x", hashByte & 0xff));
		}

		return hashBuilder.toString();
	}
}
