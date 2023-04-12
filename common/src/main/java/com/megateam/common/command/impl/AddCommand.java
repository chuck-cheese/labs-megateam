package com.megateam.common.command.impl;

import com.megateam.common.command.Command;
import com.megateam.common.data.Ticket;
import com.megateam.common.exception.CommandException;
import com.megateam.common.exception.DatabaseException;
import com.megateam.common.util.Printer;

import java.util.List;

/**
 * Command for adding new elements to the database
 */
public class AddCommand extends Command
{
	/**
	 * AddCommand constructor
	 *
	 * @param arguments command arguments
	 * @param printer command printer instance
	 */
	public AddCommand(List<String> arguments, Printer printer)
	{
		super(arguments, printer, true);
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
		dao.add((Ticket) additionalArgument);
		printer.println("New element successfully added");
		return true;
	}
}
