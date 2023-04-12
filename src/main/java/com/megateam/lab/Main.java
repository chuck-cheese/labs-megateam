package com.megateam.lab;

import com.megateam.client.CommandFactory;
import com.megateam.client.cli.Console;
import com.megateam.client.parser.cli.CoordinatesCLIParser;
import com.megateam.client.parser.cli.TicketCLIParser;
import com.megateam.client.parser.cli.VenueCLIParser;
import com.megateam.client.resolving.SingleCommandResolvingService;
import com.megateam.common.dao.Dao;
import com.megateam.common.data.Ticket;
import com.megateam.common.execution.ExecutionService;
import com.megateam.common.resolving.ResolvingService;
import com.megateam.common.util.ConsolePrinter;
import com.megateam.common.util.FileManipulationService;
import com.megateam.common.util.Printer;
import com.megateam.server.dao.TicketDaoImpl;
import com.megateam.server.database.Database;
import com.megateam.server.database.TicketDatabaseImpl;
import com.megateam.server.execution.SingleCommandExecutionService;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		Printer printer = new ConsolePrinter();
		Scanner scanner = new Scanner(System.in);


		Database<Ticket> database = new TicketDatabaseImpl();
		Dao<Ticket> dao = new TicketDaoImpl(database);
		FileManipulationService fms = new FileManipulationService();

		CommandFactory commandFactory = new CommandFactory(printer);
		CoordinatesCLIParser coordinatesCLIParser = new CoordinatesCLIParser(printer, scanner);
		VenueCLIParser venueCLIParser = new VenueCLIParser(printer, scanner);
		TicketCLIParser ticketCLIParser = new TicketCLIParser(
				printer,
				scanner,
				coordinatesCLIParser,
				venueCLIParser
		);
		ResolvingService resolvingService = new SingleCommandResolvingService(commandFactory,ticketCLIParser);
		ExecutionService executionService = new SingleCommandExecutionService(dao, fms);

		Console console = new Console(scanner, printer, resolvingService, executionService);

		console.run();
	}
}
