package com.megateam.server.database;

import com.megateam.common.exception.impl.database.ElementIdNotFoundException;
import com.megateam.common.exception.impl.database.UnableToSaveDatabaseException;
import lombok.NonNull;

import java.time.LocalDateTime;
import java.util.List;

/**
 * An abstraction for a file database
 */
public interface Database<T>
{
	/**
	 * This is an abstraction for method retrieves creation date of the database
	 *
	 * @return database creation date
	 */
	LocalDateTime getCreationDate();

	/**
	 * This is an abstraction for method that retrieves all elements from the database
	 *
	 * @return list of stored elements
	 */
	List<T> findAll();

	/**
	 * This is an abstraction for method that is retrieving stored element in the database by id
	 *
	 * @param id stored element id
	 * @return element
	 * @throws ElementIdNotFoundException if the specified id does not exist in the database
	 */
	T findElementById(@NonNull Integer id) throws ElementIdNotFoundException;

	/**
	 * This is an abstraction for method that provides an ability to add new element into the database
	 *
	 * @param item the new element which should be added into the database
	 */
	void add(@NonNull T item);

	/**
	 * This is an abstraction for method that provides an ability to update the existing element by id
	 *
	 * @param id existing element id
	 * @param item element that the existing element will be updated with
	 * @throws ElementIdNotFoundException if the specified id does not exist in the database
	 */
	void update(@NonNull Integer id, @NonNull T item) throws ElementIdNotFoundException;

	/**
	 * This is an abstraction for method that removes an element from the database by id
	 *
	 * @param id element id
	 * @throws ElementIdNotFoundException if the specified id does not exist in the database
	 */
	void remove(@NonNull Integer id) throws ElementIdNotFoundException;

	/**
	 * This is an abstraction for method that clears the database
	 */
	void clear();

	/**
	 * This is an abstraction for method that saves the collection to a file
	 *
	 * @throws UnableToSaveDatabaseException if something went wrong during the database saving
	 */
	void save() throws UnableToSaveDatabaseException;

	/**
	 * This is an abstraction for method that removes the first element from the database
	 */
	void removeFirst();

	/**
	 * This is an abstraction for method that removes the last element from the database
	 */
	void removeLast();

	/**
	 * This is an abstraction for method that removes element which is lower than specified one
	 *
	 * @param item an element for the comparison
	 */
	void removeLower(@NonNull T item);
}
