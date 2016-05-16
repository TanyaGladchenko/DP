package service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;

import dao.IUserDao;
import entity.User;
import exception.ServiceException;
import service.IProtocolService;
import service.IUserService;

/**
 * @author Tatyana_Gladchenko
 * 
 *         <p>
 *         User service implementation. Realized additional functions of
 *         {@link IProtocolService}
 *         </p>
 */

public class UserServiceImpl implements IUserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	private IUserDao userDao;

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	/**
	 * Add user if it's not persist and update else
	 * 
	 * @param user
	 * @throws ServiceException
	 */
	public Long saveOrUpdate(User entity) throws ServiceException {
		Long id = 0L;
		try {
			if (null == entity.getId()) {
				id = userDao.add(entity);
			} else {
				userDao.update(entity);
				id = entity.getId();
			}
		} catch (DataAccessException e) {
			logger.error("Can't save user: " + e.getMessage(), e);
			throw new ServiceException("Can't save user: " + e.getMessage(), e);
		}
		return id;
	}

	/**
	 * Delegate loadAll method for persistence layer. See {@link IUserDao}
	 * 
	 * @throws ServiceException
	 */
	public List<User> loadAll() throws ServiceException {
		try {
			return userDao.loadAll();
		} catch (DataAccessException e) {
			logger.error("Can't load user list: " + e.getMessage(), e);
			throw new ServiceException("Can't load user list: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate load method for persistence layer. See {@link IUserDao}
	 * 
	 * @throws ServiceException
	 */
	public User load(Long id) throws ServiceException {
		try {
			return userDao.load(id);
		} catch (DataAccessException e) {
			logger.error("Can't load user: " + e.getMessage(), e);
			throw new ServiceException("Can't load user: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate delete method for persistence layer. See {@link IUserDao}
	 * 
	 * @throws ServiceException
	 */
	public void delete(Long... ids) throws ServiceException {
		try {
			userDao.delete(ids);
		} catch (DataAccessException e) {
			logger.error("Can't delete users: " + e.getMessage(), e);
			throw new ServiceException("Can't delete users :" + e.getMessage(), e);
		}
	}

	/**
	 * Delegate method for {@link IUserDao}.
	 * 
	 * @throws ServiceException
	 */
	public void updatePassword(User user) {
		try {
			userDao.updatePassword(user);
			;
		} catch (DataAccessException e) {
			logger.error("Can't update user password: " + e.getMessage(), e);
			throw new ServiceException("Can't update user password: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate method for {@link IUserDao}.
	 * 
	 * @throws ServiceException
	 */
	public List<User> loadByRole(Long roleId) {
		try {
			return userDao.loadByRole(roleId);
		} catch (DataAccessException e) {
			logger.error("Can't load user list: " + e.getMessage(), e);
			throw new ServiceException("Can't load user list: " + e.getMessage(), e);
		}
	}

	/**
	 * Delegate method for {@link IUserDao}.
	 * 
	 * @throws ServiceException
	 */
	public List<User> loadPlayers() {
		try {
			return userDao.loadPlayers();
		} catch (DataAccessException e) {
			logger.error("Can't load user list: " + e.getMessage(), e);
			throw new ServiceException("Can't load user list: " + e.getMessage(), e);
		}
	}
	
	/**
	 * Delegate method for {@link IUserDao}.
	 * 
	 * @throws ServiceException
	 */
	public User loadByLogin(String login) {
		try {
			return userDao.loadByLogin();
		} catch (DataAccessException e) {
			logger.error("Can't load user: " + e.getMessage(), e);
			throw new ServiceException("Can't load user: " + e.getMessage(), e);
		}
	}
}
