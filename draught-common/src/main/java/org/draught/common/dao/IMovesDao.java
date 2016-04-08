package by.bsuir.rusdraughtstraining.rus_draughts_training;

/**
 * @author Tatyana_Gladchenko
 *
 *
 *         Contains all additional methods for Moves dao
 */

public interface IMovesDao extends GenericDao<Moves>{
	
	/**
	 * Get all news comments by newsId
	 * 
	 * @param newsId
	 * @return list of comments
	 * @throws DaoException
	 */
	public List<Moves> getAllDraughtsMoves(Long newsId) throws DaoException;
}
