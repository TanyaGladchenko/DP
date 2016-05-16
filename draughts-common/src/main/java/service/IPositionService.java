package service;

import java.util.List;

import dao.IPositionDao;
import entity.Position;
import exception.ServiceException;

/**
 * @author Tatyana_Gladchenko 
 * 
 * 
 *         Contains all additional methods for position service
 */

public interface IPositionService extends GenericService<Position>{
	
	/**
	 * Delegate method for persistence layer. See {@link IPositionDao}
	 * 
	 * @param title
	 * @return list position
	 * @throws ServiceException
	 */
	public List<Position> loadByTitle(String title);
}
