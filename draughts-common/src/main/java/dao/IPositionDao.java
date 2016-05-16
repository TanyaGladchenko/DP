package dao;
import java.util.List;

import entity.Position;

/**
 * @author Tatyana_Gladchenko
 *
 *
 *         Contains all additional methods for position dao
 */

public interface IPositionDao extends GenericDao<Position> {
	
	/**
	 * Get news author by newsId
	 * 
	 * @param title
	 * @return list position
	 */
	public List<Position> loadByTitle(String title);
}
