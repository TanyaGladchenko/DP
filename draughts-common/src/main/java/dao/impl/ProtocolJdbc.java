package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dao.IProtocolDao;
import entity.Protocol;

/**
 * @author Tatyana_Gladchenko
 *
 *         <p>
 *         Protocol dao implementation. Works with MySql database
 *         </p>
 */

public class ProtocolJdbc implements IProtocolDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private static final String SQL_INSERT_PROTOCOL_QUERY = "INSERT INTO PROTOCOL (black_player_id, position_id, state_game_id, title, white_player_id) values (?,?,?,?,?)";
	private static final String SQL_UPDATE_PROTOCOL_QUERY = "UPDATE PROTOCOL SET black_player_id=?, position_id=?, state_game_id=?, title=?, white_player_id=? WHERE protocol_id=?";
	private static final String SQL_DELETE_PROTOCOL_QUERY = "DELETE FROM PROTOCOL WHERE protocol_id=?";
	private static final String SQL_SELECT_PROTOCOL_QUERY = "SELECT * FROM PROTOCOL WHERE protocol_id=?";
	private static final String SQL_SELECT_ALL_PROTOCOL_QUERY = "SELECT * FROM PROTOCOL ORDER BY title";
	private static final String SQL_SELECT_PROTOCOL_BY_PLAYER_QUERY = "SELECT * FROM PROTOCOL WHERE black_player_id = ? OR white_player_id=? ORDER BY title";
	private static final String SQL_SELECT_PROTOCOL_BY_STATE_GAME_QUERY = "SELECT * FROM PROTOCOL WHERE state_game_id=? ORDER BY title";
	private static final String SQL_SELECT_PROTOCOL_BY_TITLE_QUERY = "SELECT * FROM PROTOCOL WHERE title LIKE ? ORDER BY title";

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public Long add(Protocol addObject) {
		Object[] args = { addObject.getBlackPlayerId(), addObject.getPositionId(), addObject.getStateGameId(),
				addObject.getTitle(), addObject.getWhitePlayerId() };
		long count = this.jdbcTemplateObject.update(SQL_INSERT_PROTOCOL_QUERY, args);
		return count;
	}

	public List<Protocol> loadAll() {
		List<Protocol> protocols = this.jdbcTemplateObject.query(SQL_SELECT_ALL_PROTOCOL_QUERY, new ProtocolMapper());
		return protocols;
	}

	public Protocol load(Long id) {
		Protocol p = this.jdbcTemplateObject.queryForObject(SQL_SELECT_PROTOCOL_QUERY, new Object[] { id },
				new ProtocolMapper());
		return p;
	}

	public List<Protocol> loadByPlayer(Long playerId) {
		List<Protocol> protocols = this.jdbcTemplateObject.query(SQL_SELECT_PROTOCOL_BY_PLAYER_QUERY,
				new Object[] { playerId, playerId }, new ProtocolMapper());
		return protocols;
	}

	public List<Protocol> loadByTitle(String title) {
		List<Protocol> protocols = this.jdbcTemplateObject.query(SQL_SELECT_PROTOCOL_BY_TITLE_QUERY,
				new Object[] { title }, new ProtocolMapper());
		return protocols;
	}

	public List<Protocol> loadByStateGame(Long stateGameId) {
		List<Protocol> protocols = this.jdbcTemplateObject.query(SQL_SELECT_PROTOCOL_BY_STATE_GAME_QUERY,
				new Object[] { stateGameId }, new ProtocolMapper());
		return protocols;
	}

	public void delete(Long... ids) {
		this.jdbcTemplateObject.update(SQL_DELETE_PROTOCOL_QUERY, ids[0]);
	}

	public void update(Protocol updateObject) {
		Object[] args = { updateObject.getBlackPlayerId(), updateObject.getPositionId(), updateObject.getStateGameId(),
				updateObject.getTitle(), updateObject.getWhitePlayerId(), updateObject.getId() };
		this.jdbcTemplateObject.update(SQL_UPDATE_PROTOCOL_QUERY, args);
	}

	private class ProtocolMapper implements RowMapper<Protocol> {

		public Protocol mapRow(ResultSet rs, int rowNum) throws SQLException {
			Protocol p = new Protocol();
			p.setId(rs.getLong("protocol_id"));
			p.setPositionId(rs.getLong("position_id"));
			p.setBlackPlayerId(rs.getLong("black_player_id"));
			p.setStateGameId(rs.getLong("state_game_id"));
			p.setTitle(rs.getString("title"));
			p.setWhitePlayerId(rs.getLong("white_player_id"));
			return p;
		}
	}
}
