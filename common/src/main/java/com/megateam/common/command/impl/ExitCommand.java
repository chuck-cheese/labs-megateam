package com.megateam.common.command.impl;

import com.megateam.common.command.Command;
import com.megateam.common.exception.CommandException;
import com.megateam.common.exception.DatabaseException;
import com.megateam.common.exception.impl.command.CommandExecutionFailedException;
import com.megateam.common.util.Printer;

import java.util.List;

/**
 * This command stops client application
 */
public class ExitCommand extends Command
{
	/**
	 * ExitCommand constructor
	 *
	 * @param arguments command arguments
	 * @param printer command printer
	 */
	public ExitCommand(List<String> arguments, Printer printer)
	{
		super(arguments, printer, false);
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
		if (arguments.size() != 0)
		{
			throw new CommandExecutionFailedException("Invalid amount of arguments. Check help for more info");
		}

		printer.println("Application shutdown...");
		System.exit(0);
		return true;
	}
}
