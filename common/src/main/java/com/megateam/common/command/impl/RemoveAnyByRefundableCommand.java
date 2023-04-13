package com.megateam.common.command.impl;

import com.megateam.common.command.Command;
import com.megateam.common.exception.CommandException;
import com.megateam.common.exception.DatabaseException;
import com.megateam.common.exception.ParsingException;
import com.megateam.common.util.Printer;
import com.megateam.common.util.TypesParser;

import java.util.List;

/**
 * Removes one element with refundable status specified
 */
public class RemoveAnyByRefundableCommand extends Command
{
	/**
	 * RemoveAnyByRefundableCommand constructor
	 *
	 * @param arguments command arguments
	 * @param printer command printer instance
	 */
	public RemoveAnyByRefundableCommand(List<String> arguments, Printer printer)
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
			dao.removeAnyByRefundable(TypesParser.parseBoolean(arguments.get(0)));
			printer.println("Successfully removed element");
			return true;
		}
		catch (ParsingException e)
		{
			printer.println(e.getMessage());
			return false;
		}
	}
}
