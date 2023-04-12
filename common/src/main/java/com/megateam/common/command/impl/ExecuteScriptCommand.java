package com.megateam.common.command.impl;

import com.megateam.common.command.Command;
import com.megateam.common.exception.*;
import com.megateam.common.exception.impl.command.CommandExecutionFailedException;
import com.megateam.common.util.Printer;

import java.io.File;
import java.util.List;

/**
 * Command for script execution
 */
public class ExecuteScriptCommand extends Command
{
	/**
	 * Execute script command constructor
	 * 
	 * @param arguments command arguments
	 * @param printer command printer instance
	 */
	public ExecuteScriptCommand(List<String> arguments, Printer printer)
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
		if (arguments.size() != 1)
		{
			throw new CommandExecutionFailedException("Invalid amount of arguments. Check help for more info");
		}

		try
		{
			File script = fms.getFileByName(arguments.get(0));
			List<Command> resolvedScript = resolvingService.resolve(script);
			return executionService.execute(resolvedScript);
		}
		catch (ParsingException | ValidationException | FileException e)
		{
			printer.println(e.getMessage());
		}

		return false;
	}
}
