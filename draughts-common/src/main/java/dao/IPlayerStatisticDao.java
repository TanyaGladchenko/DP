package dao;

import entity.PlayerStatistic;

/**
 * @author Tatyana_Gladchenko
 *
 *
 *         Contains all additional methods for player statistic dao
 */

public interface IPlayerStatisticDao extends GenericDao<PlayerStatistic> {

	/**
	 * Get player statistic by idPlayer
	 * 
	 * @param idPlayer
	 * @return player statistic entity
	 */
	public PlayerStatistic loadByPlayer(Long idPlayer);
}
