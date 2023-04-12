package com.megateam.common.command.impl;

import com.megateam.common.command.Command;
import com.megateam.common.exception.CommandException;
import com.megateam.common.exception.DatabaseException;
import com.megateam.common.exception.impl.command.CommandExecutionFailedException;
import com.megateam.common.util.Printer;

import java.io.IOException;
import java.util.List;

/**
 * Shows help for the application
 */
public class HelpCommand extends Command
{
	/**
	 * Help command constructor
	 *
	 * @param arguments command arguments
	 * @param printer command printer instance
	 */
	public HelpCommand(List<String> arguments, Printer printer)
	{
		super(arguments, printer, false, 0);
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

		try
		{
			byte[] helpBytes = HelpCommand.class
				.getClassLoader()
				.getResourceAsStream("help.txt")
				.readAllBytes();

			String helpString = new String(helpBytes);
			printer.println(helpString);
		}
		catch (IOException e)
		{
			printer.println("Unable to access help resource");
		}
		return true;
	}
}
