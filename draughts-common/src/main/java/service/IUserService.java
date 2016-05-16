package service;

import java.util.List;

import dao.IUserDao;
import entity.User;

/**
 * @author Tatyana_Gladchenko
 * 
 * 
 *         Contains all additional methods for user service
 */

public interface IUserService extends GenericService<User> {
	
	/**
	 * Update user object in database and change password
	 * 
	 * @param user
	 */
	public void updatePassword(User user);
	
	/**
	 * Delegate method for persistence layer. See {@link IUserDao}
	 * 
	 * @param newsId
	 * @return author entity
	 */
	
	public List<User> loadByRole(Long roleId);
	
	/**
	 * Delegate method for persistence layer. See {@link IUserDao}
	 * 
	 * @return list user
	 */
	public List<User> loadPlayers();
	
	/**
	 * Delegate method for persistence layer. See {@link IUserDao}
	 * 
	 * @return user entity
	 */
	public User loadByLogin(String login);
}
