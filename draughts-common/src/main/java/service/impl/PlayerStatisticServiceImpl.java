package service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

import dao.IPlayerStatisticDao;
import entity.PlayerStatistic;
import exception.ServiceException;
import service.IPlayerStatisticService;

/**
 * @author Tatyana_Gladchenko
 * 
 *         <p>
 *         PlayerStatistic service implementation. Realized additional functions
 *         of {@link IPlayerStatisticService}
 *         </p>
 */

public class PlayerStatisticServiceImpl implements IPlayerStatisticService {

	private static final Logger logger = Logger.getLogger(PlayerStatisticServiceImpl.class);

	private IPlayerStatisticDao psDao;

	public void setPsDao(IPlayerStatisticDao psDao) {
		this.psDao = psDao;
	}

	/**
	 * Add player statistic if it's not persist and update else
	 * 
	 * @param player
	 *            statistic object
	 */
	public Long saveOrUpdate(PlayerStatistic entity) throws ServiceException {
		Long id = 0L;
		try {
			if (null == entity.getId()) {
				id = psDao.add(entity);
			} else {
				psDao.update(entity);
				id = entity.getId();
			}
		} catch (DataAccessException e) {
			logger.error("Can't save player statistic: " + e.getMessage(), e);
			throw new ServiceException("Can't save player statistic: " + e.getMessage(), e);
		}
		return id;
	}

	/**
	 * Delegate loadAll method for persistence layer. See
	 * {@link IPlayerStatisticDao}
	 * 
	 * @throws ServiceException
	 */
	public List<PlayerStatistic> loadAll() throws ServiceException {
		try {
			return psDao.loadAll();
		} catch (DataAccessException e) {
			logger.error("Can't load author list: " + e.getMessage(), e);
			throw new ServiceException("Can't load  author list: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate load method for persistence layer. See
	 * {@link IPlayerStatisticDao}
	 */
	public PlayerStatistic load(Long id) throws ServiceException {
		try {
			return psDao.load(id);
		} catch (DataAccessException e) {
			logger.error("Can't load player statistic: " + e.getMessage(), e);
			throw new ServiceException("Can't load player statistic: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate delete method for persistence layer. See
	 * {@link IPlayerStatisticDao}
	 */
	public void delete(Long... ids) throws ServiceException {
		try {
			psDao.delete(ids);
		} catch (DataAccessException e) {
			logger.error("Can't delete player statistic: " + e.getMessage(), e);
			throw new ServiceException("Can't delete player statistic :" + e.getMessage(), e);
		}
	}

	/**
	 * Delegate load method for persistence layer. See
	 * {@link IPlayerStatisticDao}
	 */
	public PlayerStatistic loadByPlayer(Long idPlayer) throws ServiceException {
		try {
			return psDao.loadByPlayer(idPlayer);
		} catch (DataAccessException e) {
			logger.error("Can't load player statistic: " + e.getMessage(), e);
			throw new ServiceException("Can't load player statistic: " + e.getMessage(), e);
		}
	}

}
