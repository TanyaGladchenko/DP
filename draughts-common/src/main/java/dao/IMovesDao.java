package dao;

import java.util.List;

import entity.Moves;

/**
 * @author Tatyana_Gladchenko
 *
 *
 *         Contains all additional methods for Moves dao
 */

public interface IMovesDao extends GenericDao<Moves>{
	
	public List<Moves> loadByProtocol(Long protocolId);

	}
