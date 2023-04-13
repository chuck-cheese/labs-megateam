package com.megateam.common.command.impl;

import com.megateam.common.command.Command;
import com.megateam.common.data.util.TicketType;
import com.megateam.common.exception.CommandException;
import com.megateam.common.exception.DatabaseException;
import com.megateam.common.exception.ParsingException;
import com.megateam.common.util.Printer;
import com.megateam.common.util.TypesParser;

import java.util.List;

/**
 * Prints all elements, which have type attribute less than specified
 */
public class FilterLessThanTypeCommand extends Command
{
	/**
	 * FilterLessThanTypeCommand constructor
	 *
	 * @param arguments command arguments
	 * @param printer command printer instance
	 */
	public FilterLessThanTypeCommand(List<String> arguments, Printer printer)
	{
		super(arguments, printer, false, 1);
	}

	/**
	 * This method is an abstraction for command execution method
	 *
	 * @return boolean status of command execution
	 * @throws CommandException  if something went wrong during the command operations
	 * @throws DatabaseException if something went wrong during the database operations
	 */
	@Override
	public boolean execute() throws CommandException, DatabaseException
	{
		try
		{
			TicketType type = TypesParser.parseTicketType(arguments.get(0));

			if (type == null)
			{
				printer.println("Incorrect element type specified");
				return false;
			}

			printer.printList(dao.findLessThanType(type));
			return true;
		}
		catch (ParsingException e)
		{
			printer.println(e.getMessage());
			return false;
		}
	}
}
