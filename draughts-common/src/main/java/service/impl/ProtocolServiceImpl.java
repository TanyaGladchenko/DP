package service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

import dao.IProtocolDao;
import entity.Protocol;
import exception.ServiceException;
import service.IProtocolService;

/**
 * @author Tatyana_Gladchenko
 * 
 *         <p>
 *         Protocol service implementation. Realized additional functions of
 *         {@link IProtocolService}
 *         </p>
 */
public class ProtocolServiceImpl implements IProtocolService {

	private static final Logger logger = Logger.getLogger(ProtocolServiceImpl.class);

	private IProtocolDao protocolDao;

	public void setProtocolDao(IProtocolDao protocolDao) {
		this.protocolDao = protocolDao;
	}

	/**
	 * Add author if it's not persist and update else
	 * 
	 * @param protocol
	 * @throws ServiceException
	 */
	public Long saveOrUpdate(Protocol entity) throws ServiceException {
		Long id = 0L;
		try {
			if (null == entity.getId()) {
				id = protocolDao.add(entity);
			} else {
				protocolDao.update(entity);
				id = entity.getId();
			}
		} catch (DataAccessException e) {
			logger.error("Can't save protocol: " + e.getMessage(), e);
			throw new ServiceException("Can't save protocol: " + e.getMessage(), e);
		}
		return id;
	}

	/**
	 * Delegate loadAll method for persistence layer. See {@link IProtocolDao}
	 * 
	 * @throws ServiceException
	 */
	public List<Protocol> loadAll() throws ServiceException {
		try {
			return protocolDao.loadAll();
		} catch (DataAccessException e) {
			logger.error("Can't load protocol list: " + e.getMessage(), e);
			throw new ServiceException("Can't load  protocol list: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate load method for persistence layer. See {@link IProtocolDao}
	 * 
	 * @throws ServiceException
	 */
	public Protocol load(Long id) throws ServiceException {
		try {
			return protocolDao.load(id);
		} catch (DataAccessException e) {
			logger.error("Can't load protocol: " + e.getMessage(), e);
			throw new ServiceException("Can't load protocol: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate delete method for persistence layer. See {@link IProtocolDao}
	 * 
	 * @throws ServiceException
	 */
	public void delete(Long... ids) throws ServiceException {
		try {
			protocolDao.delete(ids);
		} catch (DataAccessException e) {
			logger.error("Can't delete protocols: " + e.getMessage(), e);
			throw new ServiceException("Can't delete protocols :" + e.getMessage(), e);
		}
	}

	/**
	 * Delegate method for {@link IProtocolDao}.
	 * 
	 * @throws ServiceException
	 */
	public List<Protocol> loadByPlayer(Long playerId) {
		try {
			return protocolDao.loadByPlayer(playerId);
		} catch (DataAccessException e) {
			logger.error("Can't load protocol list: " + e.getMessage(), e);
			throw new ServiceException("Can't load protocol list: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate method for {@link IProtocolDao}.
	 * 
	 * @throws ServiceException
	 */
	public List<Protocol> loadByTitle(String title) {
		try {
			return protocolDao.loadByTitle(title);
		} catch (DataAccessException e) {
			logger.error("Can't load protocol: " + e.getMessage(), e);
			throw new ServiceException("Can't load protocol: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate method for {@link IProtocolDao}.
	 * 
	 * @throws ServiceException
	 */
	public List<Protocol> loadByStateGame(Long stateGameId) {
		try {
			return protocolDao.loadByStateGame(stateGameId);
		} catch (DataAccessException e) {
			logger.error("Can't load protocol list: " + e.getMessage(), e);
			throw new ServiceException("Can't load protocol list: " + e.getMessage(), e);
		}
	}
}
