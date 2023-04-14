package com.megateam.server.database;

import com.megateam.common.data.util.LocalDateTimeAdapter;
import com.megateam.common.exception.DatabaseException;
import com.megateam.common.exception.FileException;
import com.megateam.common.exception.impl.database.UnableToSaveDatabaseException;
import com.megateam.common.exception.impl.file.FileNotExistsException;
import com.megateam.common.util.FileManipulationService;
import com.megateam.server.database.data.TicketDatabaseDataclass;
import lombok.RequiredArgsConstructor;

import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Class for saving database into a file
 */
@RequiredArgsConstructor
public class DatabaseSavingService
{
	/**
	 * FileManipulationService instance
	 */
	private final FileManipulationService fms;

	/**
	 * Database saving file
	 */
	private final File savingFile;

	/**
	 * JAXB marshaller instance
	 */
	private final Marshaller xmlMarshaller;

	/**
	 * Database saving method
	 *
	 * @param databaseDataclass ticket database wrapper instance
	 */
	public void save(TicketDatabaseDataclass databaseDataclass) throws FileException, DatabaseException
	{
		fms.validateFileExists(savingFile);
		fms.validateFileIsWritable(savingFile);

		try
		{
			xmlMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			xmlMarshaller.setAdapter(new LocalDateTimeAdapter());

			FileOutputStream fos = new FileOutputStream(savingFile);
			xmlMarshaller.marshal(databaseDataclass, fos);
		}
		catch (PropertyException e)
		{
			throw new UnableToSaveDatabaseException(
					"It's unable to save the database. Marshaller property cannot be set"
			);
		}
		catch (FileNotFoundException e)
		{
			throw new FileNotExistsException(
					"Specified saving file does not exist"
			);
		}
		catch (JAXBException e)
		{
			throw new UnableToSaveDatabaseException(
					"It's unable to save the database. Something went wrong with marshaller"
			);
		}
	}

	/**
	 * Database loading method
	 *
	 * @return ticket database dataclass instance
	 */
	public TicketDatabaseDataclass load()
	{
		return null;
//		TODO: implement db loading
	}
}
