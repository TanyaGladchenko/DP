package service;

import dao.IPlayerStatisticDao;
import entity.PlayerStatistic;
import exception.ServiceException;

/**
 * @author Tatyana_Gladchenko
 * 
 * 
 *         Contains all additional methods for player statistic service
 */

public interface IPlayerStatisticService extends GenericService<PlayerStatistic> {

	/**
	 * Delegate method for persistence layer. See {@link IPlayerStatisticDao}
	 * 
	 * @param idPlayer
	 * @return player statistic entity
	 * @throws ServiceException
	 */
	public PlayerStatistic loadByPlayer(Long idPlayer) throws ServiceException;
}
