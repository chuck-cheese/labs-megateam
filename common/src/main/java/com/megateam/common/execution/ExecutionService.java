package com.megateam.common.execution;

import com.megateam.common.command.Command;
import com.megateam.common.exception.CommandException;
import com.megateam.common.exception.DatabaseException;
import com.megateam.common.exception.impl.command.DefaultExecutorException;

import java.util.List;

/**
 * Execution services abstraction
 */
public interface ExecutionService
{
	/**
	 * This method is an abstraction for single command execution method
	 *
	 * @param command command, that should be executed
	 * @return command execution status
	 * @throws DefaultExecutorException if something went wrong during command execution
	 */
	default boolean execute(Command command) throws CommandException, DatabaseException
	{
		throw new DefaultExecutorException("You are now able to use default command execution method");
	}

	/**
	 * This method is an abstraction for commands script execution method
	 *
	 * @param script script to be executed
	 * @return script execution status
	 * @throws DefaultExecutorException if something went wrong during command script execution
	 */
	default boolean execute(List<Command> script) throws CommandException, DatabaseException
	{
		throw new DefaultExecutorException("You are now able to use default script execution method");
	}
}
