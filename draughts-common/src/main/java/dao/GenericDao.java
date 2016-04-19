package dao;

import java.util.List;

import javax.sql.DataSource;

/**
 * @author Tatyana_Gladchenko
 *
 *         <p>
 *         Generic interface for dao layer. Supports CRUD operations
 *         </p>
 * @param <T>
 * 
 *            - type of dao object
 */
public interface GenericDao<T> {

	/**
	 * This is the method to be used to initialize database resources ie.
	 * connection.
	 * 
	 * @param ds
	 */
	void setDataSource(DataSource ds);

	/**
	 * Add dao object in database
	 * 
	 * @param addObject
	 *            - dao object, that added in db
	 * @return new id
	 */
	void add(T addObject);

	/**
	 * Load all objects of required type from database
	 * 
	 * @return List of required objects
	 */
	List<T> loadAll();

	/**
	 * Load single object from database by id
	 * 
	 * @param id
	 * @return required object
	 */
	T load(Long id);

	/**
	 * Delete object in database, that id in identifiers
	 * 
	 * @param identifiers
	 */
	void delete(Long... ids);

	/**
	 * Update dao object in database
	 * 
	 * @param updateObject
	 *            - dao object, that will update
	 */
	void update(T updateObject);

}
