package com.megateam.client.parser;

import com.megateam.common.data.util.TicketType;
import com.megateam.common.data.util.VenueType;
import com.megateam.common.exception.impl.parsing.InaproppriateParsingTypeException;

/**
 * Different types parser
 */
public class TypesParser
{
	/**
     * Parse integer from string
     *
     * @param line parsing string
     * @return integer value
     * @throws InaproppriateParsingTypeException if parsing not succeed
     */
    public static Integer parseInteger(String line) throws InaproppriateParsingTypeException {
        try
        {
            return Integer.parseInt(line);
        }
		catch (NumberFormatException e)
		{
            throw new InaproppriateParsingTypeException("Inaproppriate argument type: should be integer");
        }
    }

    /**
     * Parse long from string
     *
     * @param line parsing string
     * @return long value
     * @throws InaproppriateParsingTypeException if parsing not succeed
     */
    public static Long parseLong(String line) throws InaproppriateParsingTypeException {
        try
        {
            return Long.parseLong(line);
        }
		catch (NumberFormatException e)
		{
            throw new InaproppriateParsingTypeException("Inaproppriate argument type: should be long");
        }
    }

    /**
     * Parse boolean from string
     *
     * @param line parsing string
     * @return boolean value
     * @throws InaproppriateParsingTypeException if parsing not succeed
     */
    public static Boolean parseBoolean(String line) throws InaproppriateParsingTypeException {

        if ("true".equalsIgnoreCase(line))
		{
            return true;
        }
		else if ("false".equalsIgnoreCase(line))
		{
            return false;
        }

        throw new InaproppriateParsingTypeException("Inaproppriate argument type: should be boolean");
    }

    /**
     * Parse TicketType from string
     *
     * @param line parsing string
     * @return TicketType value
     * @throws InaproppriateParsingTypeException if parsing not succeed
     */
    public static TicketType parseTicketType(String line) throws InaproppriateParsingTypeException
    {
        if ("".equals(line.trim()))
            return null;

        for (TicketType type : TicketType.values())
		{
            if (type.toString().equalsIgnoreCase(line.trim()))
			{
                return TicketType.valueOf(line);
            }
        }

        throw new InaproppriateParsingTypeException(
                "Inaproppriate argument type: should be TicketType or specified variable not found"
        );
    }

    /**
     * Parse VenueType from string
     *
     * @param line parsing string
     * @return VenueType value
     * @throws InaproppriateParsingTypeException if parsing not succeed
     */
    public static VenueType parseVenueType(String line) throws InaproppriateParsingTypeException
    {
        if ("".equals(line.trim()))
            return null;

        for (VenueType type : VenueType.values())
		{
            if (type.toString().equalsIgnoreCase(line))
			{
                return VenueType.valueOf(line);
            }
        }

        throw new InaproppriateParsingTypeException(
                "Inaproppriate argument type: should be VenueType or specified variable not found."
        );
    }

    /**
     * Parse float from string
     *
     * @param line parsing string
     * @return float value
     * @throws InaproppriateParsingTypeException if parsing not succeed
     */
    public static Float parseFloat(String line) throws InaproppriateParsingTypeException
    {
        try
        {
            return Float.parseFloat(line);
        }
		catch (NumberFormatException e)
		{
            throw new InaproppriateParsingTypeException("Inaproppriate argument type: should be float.");
        }
    }

    /**
     * Parse double from string
     *
     * @param line parsing string
     * @return double value
     * @throws InaproppriateParsingTypeException if parsing not succeed
     */
    public static Double parseDouble(String line) throws InaproppriateParsingTypeException
    {
        try
        {
            return Double.parseDouble(line);
        }
		catch (NumberFormatException e)
		{
            throw new InaproppriateParsingTypeException("Inaproppriate argument type: should be float.");
        }
    }
}
