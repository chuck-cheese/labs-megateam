package com.megateam.common.data.validation;

import com.megateam.common.data.Coordinates;
import com.megateam.common.exception.ValidationException;
import com.megateam.common.exception.impl.validation.BoundValidationException;
import com.megateam.common.exception.impl.validation.NullValidationException;
import lombok.NonNull;

/**
 * Utility class for coordinates validation
 */
public class CoordinatesValidator
{
	/**
	 * This method validates x coordinate
	 *
	 * @param x x coordinate
	 * @throws BoundValidationException if x coordinate is less or equal to -390 or is an infinity
	 */
	public static void validateXCoord(float x) throws BoundValidationException
	{
		if (Float.compare(x, -390) <= 0)
			throw new BoundValidationException("X coordinate should be greater than -390");

		if (x == Float.POSITIVE_INFINITY || x == Float.NEGATIVE_INFINITY)
			throw new BoundValidationException("X coordinate cannot be an infinity");
	}

	/**
	 * This method validates y coordinate
	 *
	 * @param y y coordinate
	 * @throws NullValidationException if y coordinate is null
	 */
	public static void validateYCoord(Integer y) throws NullValidationException
	{
		if (y == null)
			throw new NullValidationException("Y coordinate cannot be null");
	}

	/**
	 * Coordinates object validation method
	 *
	 * @param coordinates coordinates object under validation
	 * @throws BoundValidationException if x coordinate is less or equal to -390 or is an infinity
	 * @throws NullValidationException if y coordinate is null
	 */
	public static void validateCoordinates(@NonNull Coordinates coordinates) throws ValidationException
	{
		validateXCoord(coordinates.getX());
		validateXCoord(coordinates.getY());
	}
}
