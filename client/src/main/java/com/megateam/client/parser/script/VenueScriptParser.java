package com.megateam.client.parser.script;

import com.megateam.client.parser.TypesParser;
import com.megateam.common.data.Venue;
import com.megateam.common.data.util.VenueType;
import com.megateam.common.data.validation.VenueValidator;
import com.megateam.common.exception.ValidationException;
import com.megateam.common.exception.impl.parsing.DataclassParsingException;

import java.util.Scanner;

/**
 * Class for parsing venue from script
 */
public class VenueScriptParser
{
	/**
     * Parse venue from strings
     *
     * @param scanner script scanner
     * @return venue instance
     * @throws DataclassParsingException if something went wrong during parsing dataclass from script
     */
    public static Venue parseVenue(Scanner scanner) throws DataclassParsingException
    {
		try
		{
			String name = scanner.nextLine();
			Integer capacity = TypesParser.parseInteger(scanner.nextLine());
			VenueType type = TypesParser.parseVenueType(scanner.nextLine());

			Venue venue = new Venue(name, capacity, type);
			VenueValidator.validateVenue(venue);

			return venue;
		}
		catch (ValidationException e)
		{
			throw new DataclassParsingException(e.getMessage());
		}
		catch (Exception e)
		{
			throw new DataclassParsingException("Something went wrong during venue parsing");
		}
    }
}
