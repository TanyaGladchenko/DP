package dao;

import java.util.List;

import entity.User;

/**
 * @author Tatyana_Gladchenko
 *
 *
 *         Contains all additional methods for user dao
 */

public interface IUserDao extends GenericDao<User>{
	/**
	 * Update user object in database and change password
	 * 
	 * @param user
	 */
	public void updatePassword(User user);
	
	/**
	 * Get users by newsId
	 * 
	 * @param roleId
	 * @return list user entity
	 */
	public List<User> loadByRole(Long roleId);
	
	/**
	 * Get list user whith role player
	 * 
	 * @return list user
	 */
	public List<User> loadPlayers();
	
	/**
	 * Get user entity whith login
	 * 
	 * @return user
	 */
	public User loadByLogin();
}
