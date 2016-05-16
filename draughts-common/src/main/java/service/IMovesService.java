package service;

import java.util.List;

import dao.IMovesDao;
import entity.Moves;
import exception.ServiceException;

/**
 * @author Tatyana_Gladchenko
 * 
 * 
 *         Contains all additional methods for moves service
 */

public interface IMovesService extends GenericService<Moves> {

	/**
	 * Delegate method for persistence layer. See {@link IMovesDao}
	 * 
	 * @param protocolId
	 * @return list moves
	 * @throws ServiceException
	 */
	public List<Moves> loadByProtocol(Long protocolId) throws ServiceException;

}
