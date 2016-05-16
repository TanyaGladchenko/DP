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
	 
	/** Load all Moves by protocolId
	 * 
	 * @param protocolId
	 * @return moves list
	 */
	public List<Moves> loadByProtocol(Long protocolId);

	}
