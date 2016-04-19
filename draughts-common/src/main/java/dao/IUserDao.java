package dao;

import java.util.List;

import entity.User;

public interface IUserDao extends GenericDao<User>{
	
	public void updatePassword(User user);
	
	public List<User> loadByRole(Long roleId);
	
	public List<User> loadPlauers();
}
