package com.megateam.common.command.impl;

import com.megateam.common.command.Command;
import com.megateam.common.data.Ticket;
import com.megateam.common.exception.CommandException;
import com.megateam.common.exception.DatabaseException;
import com.megateam.common.util.Printer;

import java.util.List;

/** Prints all elements' prices in descending order */
public class PrintFieldDescendingPriceCommand extends Command {
    /**
     * PrintFieldDescendingPriceCommand constructor
     *
     * @param arguments command arguments
     * @param printer command printer instance
     */
    public PrintFieldDescendingPriceCommand(List<String> arguments, Printer printer) {
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
        List<Float> prices =
                dao.findAll().stream()
                        .map(Ticket::getPrice)
                        .sorted((el1, el2) -> Float.compare(el2, el1))
                        .toList();
        printer.printList(prices);
        return true;
    }
}
