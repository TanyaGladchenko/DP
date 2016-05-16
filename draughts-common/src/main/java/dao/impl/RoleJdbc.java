package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dao.IRoleDao;
import entity.Role;

/**
 * @author Tatyana_Gladchenko
 *
 *         <p>
 *         Role dao implementation. Works with MySql database
 *         </p>
 */

public class RoleJdbc implements IRoleDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private static final String SQL_INSERT_ROLE_QUERY = "INSERT INTO ROLE (name) values (?)";
	private static final String SQL_UPDATE_ROLE_QUERY = "UPDATE ROLE SET name=? WHERE role_id=?";
	private static final String SQL_DELETE_ROLE_QUERY = "DELETE FROM ROLE WHERE role_id=?";
	private static final String SQL_SELECT_ROLE_QUERY = "SELECT * FROM ROLE WHERE role_id=?";
	private static final String SQL_SELECT_ALL_ROLE_QUERY = "SELECT * FROM ROLE ORDER BY name";

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public Long add(Role addObject) {
		long count = this.jdbcTemplateObject.update(SQL_INSERT_ROLE_QUERY, addObject.getName());
		return count;
	}

	public List<Role> loadAll() {
		List<Role> roles = this.jdbcTemplateObject.query(SQL_SELECT_ALL_ROLE_QUERY, new RoleMapper());
		return roles;
	}

	public Role load(Long id) {
		Role r = (Role) this.jdbcTemplateObject.queryForObject(SQL_SELECT_ROLE_QUERY, new Object[] { id },
				new RoleMapper());
		return r;
	}

	public void delete(Long... ids) {
		this.jdbcTemplateObject.update(SQL_DELETE_ROLE_QUERY, ids[0]);
	}

	public void update(Role updateObject) {
		Object[] args = { updateObject.getName(), updateObject.getId() };
		this.jdbcTemplateObject.update(SQL_UPDATE_ROLE_QUERY, args);
	}

	private class RoleMapper implements RowMapper<Role> {

		public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
			Role role = new Role();
			role.setId(rs.getLong("role_id"));
			role.setName(rs.getString("name"));
			return role;
		}
	}
}
