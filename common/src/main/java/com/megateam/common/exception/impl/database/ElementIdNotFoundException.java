package com.megateam.common.exception.impl.database;

import com.megateam.common.exception.DatabaseException;

/**
 * This exception is thrown if during the database operation element id was not found in the database
 */
public class ElementIdNotFoundException extends DatabaseException
{
	/**
	 * DatabaseException constructor
	 *
	 * @param message message for the exception
	 */
	public ElementIdNotFoundException(String message)
	{
		super(message);
	}
}
