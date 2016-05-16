package dao;

import java.util.List;

import entity.Protocol;

/**
 * @author Tatyana_Gladchenko
 *
 *
 *         Contains all additional methods for protocol dao
 */

public interface IProtocolDao extends GenericDao<Protocol> {

	/**
	 * Get players protocol by playerId
	 * 
	 * @param playerId
	 * @return list protocol
	 */
	public List<Protocol> loadByPlayer(Long playerId);

	/**
	 * Get protocol by title
	 * 
	 * @param title
	 * @return list protocol
	 */
	public List<Protocol> loadByTitle(String title);

	/**
	 * Get protocol by state game
	 * 
	 * @param stateGameId
	 * @return list protocol
	 */
	public List<Protocol> loadByStateGame(Long stateGameId);

}
