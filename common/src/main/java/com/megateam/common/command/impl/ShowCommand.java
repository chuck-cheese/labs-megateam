package com.megateam.common.command.impl;

import com.megateam.common.command.Command;
import com.megateam.common.exception.CommandException;
import com.megateam.common.exception.impl.command.CommandExecutionFailedException;
import com.megateam.common.util.Printer;

import java.util.List;

/**
 * Command shows a list of stored elements
 */
public class ShowCommand extends Command
{
	/**
	 * ShowCommand constructor
	 *
	 * @param arguments command arguments
	 * @param printer command printer
	 */
	public ShowCommand(List<String> arguments, Printer printer)
	{
		super(arguments, printer, false);
	}

	/**
	 * This method is an abstraction for command execution method
	 *
	 * @return boolean status of command execution
	 */
	@Override
	public boolean execute() throws CommandException
	{
		if (arguments.size() != 0)
		{
			throw new CommandExecutionFailedException("Invalid amount of arguments. Check help for more info");
		}

		printer.printList(dao.findAll());
		return true;
	}
}
