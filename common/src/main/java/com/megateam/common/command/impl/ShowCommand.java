package com.megateam.common.command.impl;

import com.megateam.common.command.Command;
import com.megateam.common.exception.CommandException;
import com.megateam.common.util.Printer;

import java.util.List;

/** Command shows a list of stored elements */
public class ShowCommand extends Command {
    /**
     * ShowCommand constructor
     *
     * @param arguments command arguments
     * @param printer command printer
     */
    public ShowCommand(List<String> arguments, Printer printer) {
        super(arguments, printer, false, 0);
    }

    /**
     * This method is an abstraction for command execution method
     *
     * @return boolean status of command execution
     */
    @Override
    public boolean execute() throws CommandException {
        printer.printList(dao.findAll());
        return true;
    }
}
