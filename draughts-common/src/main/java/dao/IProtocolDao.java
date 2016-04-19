package dao;

import java.util.List;

import entity.Protocol;

public interface IProtocolDao extends GenericDao<Protocol> {

	public List<Protocol> loadByPlayer(Long playerId);

	public List<Protocol> loadByTitle(String title);

	public List<Protocol> loadByStateGame(Long stateGameId);

}
