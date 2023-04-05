package com.megateam.client.parser.script;

import com.megateam.client.parser.TypesParser;
import com.megateam.common.data.Coordinates;
import com.megateam.common.data.validation.CoordinatesValidator;
import com.megateam.common.exception.ValidationException;
import com.megateam.common.exception.impl.parsing.DataclassParsingException;

import java.util.Scanner;

/**
 * Class for parsing coordinates from script
 */
public class CoordinatesScriptParser
{
	/**
     * Parse coordinates from strings
     *
     * @param scanner scanner instance
     * @return coordinates instance
     * @throws DataclassParsingException if something went wrong during parsing dataclass from script
     */
    public static Coordinates parseCoordinates(Scanner scanner) throws DataclassParsingException
    {
		try
		{
			float x = TypesParser.parseFloat(scanner.nextLine());
			Integer y = TypesParser.parseInteger(scanner.nextLine());

			Coordinates coordinates = new Coordinates(x, y);

	        CoordinatesValidator.validateCoordinates(coordinates);
            return coordinates;
		}
		catch (ValidationException e)
		{
			throw new DataclassParsingException(e.getMessage());
		}
		catch (Exception e)
		{
			throw new DataclassParsingException("Something went wrong during coordinates parsing");
		}
    }
}
