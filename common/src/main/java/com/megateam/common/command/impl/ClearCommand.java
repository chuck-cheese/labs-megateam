package com.megateam.common.command.impl;

import com.megateam.common.command.Command;
import com.megateam.common.exception.CommandException;
import com.megateam.common.exception.DatabaseException;
import com.megateam.common.util.Printer;

import java.util.List;

/** Command clears the database */
public class ClearCommand extends Command {
    /**
     * ClearCommand constructor
     *
     * @param arguments command arguments
     * @param printer command printer
     */
    public ClearCommand(List<String> arguments, Printer printer) {
        super(arguments, printer, false, 0);
    }

    /**
     * This method is an abstraction for command execution method
     *
     * @return boolean status of command execution
     * @throws CommandException if something went wrong during the command operations
     * @throws DatabaseException if something went wrong during the database operations
     */
    @Override
    public boolean execute() throws CommandException, DatabaseException {
        dao.clear();
        printer.println("Database successfully cleared");
        return true;
    }
}
