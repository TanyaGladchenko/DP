package service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

import dao.IMovesDao;
import entity.Moves;
import exception.ServiceException;
import service.IMovesService;

public class MovesServiceImpl implements IMovesService {

	private static final Logger logger = Logger.getLogger(MovesServiceImpl.class);

	private IMovesDao movesDao;

	public void setMovesDao(IMovesDao movesDao) {
		this.movesDao = movesDao;
	}

	/**
	 * Add moves if it's not persist and update else
	 * 
	 * @param moves
	 *            object
	 */
	public Long saveOrUpdate(Moves entity) throws ServiceException {
		Long id = 0L;
		try {
			if (null == entity.getId()) {
				id = movesDao.add(entity);
			} else {
				movesDao.update(entity);
				id = entity.getId();
			}
		} catch (DataAccessException e) {
			logger.error("Can't save moves: " + e.getMessage(), e);
			throw new ServiceException("Can't save author: " + e.getMessage(), e);
		}
		return id;
	}

	/**
	 * Delegate loadAll method for persistence layer. See {@link IMovesDao}
	 */
	public List<Moves> loadAll() throws ServiceException {
		try {
			return movesDao.loadAll();
		} catch (DataAccessException e) {
			logger.error("Can't load moves list: " + e.getMessage(), e);
			throw new ServiceException("Can't load moves list: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate load method for persistence layer. See {@link IMovesDao}
	 */
	public Moves load(Long id) throws ServiceException {
		try {
			return movesDao.load(id);
		} catch (DataAccessException e) {
			logger.error("Can't load moves: " + e.getMessage(), e);
			throw new ServiceException("Can't load moves: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate delete method for persistence layer. See {@link IMovesDao}
	 */
	public void delete(Long... ids) throws ServiceException {
		try {
			movesDao.delete(ids);
		} catch (DataAccessException e) {
			logger.error("Can't delete author: " + e.getMessage(), e);
			throw new ServiceException("Can't delete authors :" + e.getMessage(), e);
		}
	}
	
	/**
	 * Delegate loadByProtocol method for persistence layer. See {@link IMovesDao}
	 */
	public List<Moves> loadByProtocol(Long protocolId) throws ServiceException {
		try {
			return movesDao.loadByProtocol(protocolId);
		} catch (DataAccessException e) {
			logger.error("Can't load moves list: " + e.getMessage(), e);
			throw new ServiceException("Can't load moves list: " + e.getMessage(), e);
		}
	}

}
