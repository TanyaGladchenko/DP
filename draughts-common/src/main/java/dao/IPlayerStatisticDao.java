package dao;

import entity.PlayerStatistic;

public interface IPlayerStatisticDao extends GenericDao<PlayerStatistic>{

	public PlayerStatistic loadByPlayer(Long idPlayer);
}
