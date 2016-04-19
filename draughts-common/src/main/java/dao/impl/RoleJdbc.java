package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dao.IRoleDao;
import entity.Role;

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

	public void add(Role addObject) {
		this.jdbcTemplateObject.update(SQL_INSERT_ROLE_QUERY, addObject.getName());
	}

	public List<Role> loadAll() {
		List<Role> roles = this.jdbcTemplateObject.query(SQL_SELECT_ALL_ROLE_QUERY, new RoleMapper());
		return roles;
	}

	public Role load(Long id) {
		Role r = (Role) this.jdbcTemplateObject.query(SQL_SELECT_ROLE_QUERY, new Object[] { id }, new RoleMapper());
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
			Role sg = new Role();
			sg.setId(rs.getInt("role_id"));
			sg.setName(rs.getString("name"));
			return sg;
		}
	}
}
