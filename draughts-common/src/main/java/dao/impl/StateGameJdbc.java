package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dao.IStateGameDao;
import entity.StateGame;

public class StateGameJdbc implements IStateGameDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private static final String SQL_INSERT_SG_QUERY = "INSERT INTO STATE_GAME (name) values (?)";
	private static final String SQL_UPDATE_SG_QUERY = "UPDATE STATE_GAME SET name=? WHERE state_game_id=?";
	private static final String SQL_DELETE_SG_QUERY = "DELETE FROM STATE_GAME WHERE state_game_id=?";
	private static final String SQL_SELECT_SG_QUERY = "SELECT * FROM STATE_GAME WHERE state_game_id=?";
	private static final String SQL_SELECT_ALL_SG_QUERY = "SELECT * FROM STATE_GAME ORDER BY name";

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void add(StateGame addObject) {
		this.jdbcTemplateObject.update(SQL_INSERT_SG_QUERY, addObject.getName());
	}

	public List<StateGame> loadAll() {
		List<StateGame> sg = this.jdbcTemplateObject.query(SQL_SELECT_ALL_SG_QUERY, new SGMapper());
		return sg;
	}

	public StateGame load(Long id) {
		StateGame sg = (StateGame) this.jdbcTemplateObject.query(SQL_SELECT_SG_QUERY, new Object[] { id },
				new SGMapper());
		return sg;
	}

	public void delete(Long... ids) {
		this.jdbcTemplateObject.update(SQL_DELETE_SG_QUERY, ids[0]);
	}

	public void update(StateGame updateObject) {
		Object[] args = { updateObject.getName(), updateObject.getId() };
		this.jdbcTemplateObject.update(SQL_UPDATE_SG_QUERY, args);
	}

	private class SGMapper implements RowMapper<StateGame> {

		public StateGame mapRow(ResultSet rs, int rowNum) throws SQLException {
			StateGame sg = new StateGame();
			sg.setId(rs.getInt("state_game_id"));
			sg.setName(rs.getString("name"));
			return sg;
		}

	}
}
