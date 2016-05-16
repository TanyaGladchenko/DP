package service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

import dao.IPositionDao;
import entity.Position;
import exception.ServiceException;
import service.IPositionService;

/**
 * @author Tatyana_Gladchenko
 * 
 *         <p>
 *         Position service implementation. Realized additional functions of
 *         {@link IPositionService}
 *         </p>
 */

public class PositionServiceImpl implements IPositionService {

	private static final Logger logger = Logger.getLogger(PositionServiceImpl.class);
	private IPositionDao positionDao;

	public void setPositionDao(IPositionDao positionDao) {
		this.positionDao = positionDao;
	}

	/**
	 * Add position if it's not persist and update else
	 * 
	 * @param position
	 *            object
	 * @throws ServiceException
	 */
	public Long saveOrUpdate(Position entity) throws ServiceException {
		Long id = 0L;
		try {
			if (null == entity.getId()) {
				id = positionDao.add(entity);
			} else {
				positionDao.update(entity);
				id = entity.getId();
			}
		} catch (DataAccessException e) {
			logger.error("Can't save position: " + e.getMessage(), e);
			throw new ServiceException("Can't save position: " + e.getMessage(), e);
		}
		return id;
	}

	/**
	 * Delegate loadAll method for persistence layer. See {@link IPositionDao}
	 * 
	 * @throws ServiceException
	 */
	public List<Position> loadAll() throws ServiceException {
		try {
			return positionDao.loadAll();
		} catch (DataAccessException e) {
			logger.error("Can't load position list: " + e.getMessage(), e);
			throw new ServiceException("Can't load position list: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate load method for persistence layer. See {@link IPositionDao}
	 * 
	 * @throws ServiceException
	 */
	public Position load(Long id) throws ServiceException {
		try {
			return positionDao.load(id);
		} catch (DataAccessException e) {
			logger.error("Can't load position: " + e.getMessage(), e);
			throw new ServiceException("Can't load position: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate delete method for persistence layer. See {@link IPositionDao}
	 * 
	 * @throws ServiceException
	 */
	public void delete(Long... ids) throws ServiceException {
		try {
			positionDao.delete(ids);
		} catch (DataAccessException e) {
			logger.error("Can't delete posititons: " + e.getMessage(), e);
			throw new ServiceException("Can't delete posititons :" + e.getMessage(), e);
		}
	}

	/**
	 * Delegate method for {@link IPositionDao}.
	 * 
	 * @throws ServiceException
	 */
	public List<Position> loadByTitle(String title) {
		try {
			return positionDao.loadByTitle(title);
		} catch (DataAccessException e) {
			logger.error("Can't delete posititon list: " + e.getMessage(), e);
			throw new ServiceException("Can't delete posititon list:" + e.getMessage(), e);
		}
	}

}
