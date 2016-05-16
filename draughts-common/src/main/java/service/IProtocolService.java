package service;

import java.util.List;

import dao.IProtocolDao;
import entity.Protocol;

/**
 * @author Tatyana_Gladchenko
 * 
 * 
 *         Contains all additional methods for protocol service
 */

public interface IProtocolService extends GenericService<Protocol> {
	
	/**
	 * Delegate method for persistence layer. See {@link IProtocolDao}
	 * 
	 * @param playerId
	 * @return list protocol
	 */
	public List<Protocol> loadByPlayer(Long playerId);

	/**
	 * Delegate method for persistence layer. See {@link IProtocolDao}
	 * 
	 * @param title
	 * @return list protocol
	 */
	public List<Protocol> loadByTitle(String title);

	/**
	 * Delegate method for persistence layer. See {@link IProtocolDao}
	 * 
	 * @param stateGameId
	 * @return list protocol
	 */
	public List<Protocol> loadByStateGame(Long stateGameId);
}
