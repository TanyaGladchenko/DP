package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dao.IPlayerStatisticDao;
import entity.PlayerStatistic;

public class PlayerStatisticJdbc implements IPlayerStatisticDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private static final String SQL_INSERT_PS_QUERY = "INSERT INTO PLAYER_STATISTIC (player_id, games_draw, games_loose, games_won) values (?,?,?,?)";
	private static final String SQL_UPDATE_PS_QUERY = "UPDATE PLAYER_STATISTIC SET games_draw=?, games_loose=?, games_won=? WHERE player_statistic_id=?";
	private static final String SQL_DELETE_PS_QUERY = "DELETE FROM PLAYER_STATISTIc WHERE player_statistic_id=?";
	private static final String SQL_SELECT_PS_QUERY = "SELECT * FROM PLAYER_STATISTIc WHERE player_statistic_id=?";
	private static final String SQL_SELECT_ALL_PS_QUERY = "SELECT * FROM PLAYER_STATISTIC ORDER BY player_id";
	private static final String SQL_SELECT_PS_BY_PLAYER_QUERY = "SELECT * FROM PLAYER_STATISTIC WHERE player_id=?";

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void add(PlayerStatistic addObject) {
		Object[] args = { addObject.getPlayerId(), addObject.getGamesDraw(), addObject.getGamesLoose(),
				addObject.getGamesWon() };
		this.jdbcTemplateObject.update(SQL_INSERT_PS_QUERY, args);
	}

	public List<PlayerStatistic> loadAll() {
		List<PlayerStatistic> listPs = this.jdbcTemplateObject.query(SQL_SELECT_ALL_PS_QUERY, new PSMapper());
		return listPs;
	}

	public PlayerStatistic load(Long id) {
		PlayerStatistic ps = this.jdbcTemplateObject.queryForObject(SQL_SELECT_PS_QUERY, new Object[] { id },
				new PSMapper());
		return ps;
	}

	public PlayerStatistic loadByPlayer(Long idPlayer) {
		PlayerStatistic ps = this.jdbcTemplateObject.queryForObject(SQL_SELECT_PS_BY_PLAYER_QUERY,
				new Object[] { idPlayer }, new PSMapper());
		return ps;
	}

	public void delete(Long... ids) {
		this.jdbcTemplateObject.update(SQL_DELETE_PS_QUERY, ids[0]);
	}

	public void update(PlayerStatistic updateObject) {
		Object[] args = { updateObject.getGamesDraw(), updateObject.getGamesLoose(), updateObject.getGamesWon(),
				updateObject.getId() };
		this.jdbcTemplateObject.update(SQL_UPDATE_PS_QUERY, args);
	}

	private class PSMapper implements RowMapper<PlayerStatistic> {

		public PlayerStatistic mapRow(ResultSet rs, int rowNum) throws SQLException {
			PlayerStatistic ps = new PlayerStatistic();
			ps.setId(rs.getLong("player_statistic_id"));
			ps.setGamesDraw(rs.getInt("games_draw"));
			ps.setGamesLoose(rs.getInt("games_loose"));
			ps.setGamesWon(rs.getInt("games_won"));
			ps.setPlayerId(rs.getLong("player_id"));
			return ps;
		}

	}
}
