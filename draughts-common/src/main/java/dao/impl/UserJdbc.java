package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dao.IUserDao;
import entity.User;

public class UserJdbc implements IUserDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private static final String SQL_INSERT_USER_QUERY = "INSERT INTO USER (first_name, middle_name, last_name, login, password, email, birthday, role_id) values (?,?,?,?,?,?,?,?)";
	private static final String SQL_UPDATE_INFO_QUERY = "UPDATE USER SET first_name=?, middle_name=?, last_name=?, birthday=?, login=?, email=? WHERE user_id=?";
	private static final String SQL_UPDATE_PASSWORD_QUERY = "UPDATE USER SET password=? WHERE user_id=?";
	private static final String SQL_DELETE_USER_QUERY = "DELETE FROM USER WHERE user_id=?";
	private static final String SQL_SELECT_USER_QUERY = "SELECT * FROM USER WHERE user_id=?";
	private static final String SQL_SELECT_ALL_USERS_QUERY = "SELECT * FROM USER ORDER BY last_name, first_name, middle_name";
	private static final String SQL_SELECT_USER_BY_ROLE_QUERY = "SELECT * FROM USER WHERE role_id=? ORDER BY last_name, first_name, middle_name";
	private static final String SQL_SELECT_PLAUERS_SORT_BY_AGE_QUERY = "SELECT * FROM USER WHERE role_id=1 ORDER BY birthday";

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void add(User obj) {
		Object[] o = { obj.getFirstName(), obj.getMiddleName(), obj.getLastName(), obj.getLogin(), obj.getPassword(),
				obj.getEmail(), obj.getBirthday(), obj.getRoleId() };
		this.jdbcTemplateObject.update(SQL_INSERT_USER_QUERY, o);
		return;
	}

	public List<User> loadAll() {
		List<User> users = this.jdbcTemplateObject.query(SQL_SELECT_ALL_USERS_QUERY, new UserMapper());
		return users;
	}

	public User load(Long id) {
		User user = this.jdbcTemplateObject.queryForObject(SQL_SELECT_USER_QUERY, new Object[] { id },
				new UserMapper());
		return user;
	}

	public void delete(Long... id) {
		this.jdbcTemplateObject.update(SQL_DELETE_USER_QUERY, id[0]);
	}

	public void update(User updateObject) {
		Object[] args = { updateObject.getFirstName(), updateObject.getMiddleName(), updateObject.getLastName(),
				updateObject.getBirthday(), updateObject.getLogin(), updateObject.getEmail(), updateObject.getId() };
		this.jdbcTemplateObject.update(SQL_UPDATE_INFO_QUERY, args);
	}

	public void updatePassword(User user) {
		this.jdbcTemplateObject.update(SQL_UPDATE_PASSWORD_QUERY, user.getPassword(), user.getId());
	}

	public List<User> loadPlauers() {
		List<User> users = this.jdbcTemplateObject.query(SQL_SELECT_PLAUERS_SORT_BY_AGE_QUERY, new UserMapper());
		return users;
	};

	public List<User> loadByRole(Long roleId) {
		List<User> users = this.jdbcTemplateObject.query(SQL_SELECT_USER_BY_ROLE_QUERY, new UserMapper(), roleId);
		return users;
	};

	private class UserMapper implements RowMapper<User> {

		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			User user = new User();
			user.setId(rs.getLong("user_id"));
			user.setFirstName(rs.getString("first_name"));
			user.setMiddleName(rs.getString("middle_name"));
			user.setLastName(rs.getString("last_name"));
			user.setLogin(rs.getString("login"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setBirthday(rs.getDate("birthday"));
			user.setRoleId(rs.getLong("role_id"));
			return user;
		}

	}
}
