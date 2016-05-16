package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dao.IPositionDao;
import entity.Position;

/**
 * @author Tatyana_Gladchenko
 *
 *         <p>
 *         Position dao implementation. Works with MySql database
 *         </p>
 */

public class PositionJdbc implements IPositionDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private static final String SQL_INSERT_POSITION_QUERY = "INSERT INTO POSITION (black_king, black_man, black_move_first, title, white_king, white_man) values (?,?,?,?,?,?)";
	private static final String SQL_UPDATE_POSITION_QUERY = "UPDATE POSITION SET black_king=?, black_man=?, black_move_first=?, title=?, white_king=?, white_man=? WHERE position_id=?";
	private static final String SQL_DELETE_POSITION_QUERY = "DELETE FROM POSITION WHERE position_id=?";
	private static final String SQL_SELECT_POSITION_QUERY = "SELECT * FROM POSITION WHERE position_id=?";
	private static final String SQL_SELECT_ALL_POSITION_QUERY = "SELECT * FROM POSITION ORDER BY title";
	private static final String SQL_SELECT_POSITION_BY_TITLE_QUERY = "SELECT * FROM POSITION WHERE title LIKE ? ORDER BY title";

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public Long add(Position addObject) {
		Object[] args = { addObject.getBlackKing(), addObject.getBlackMan(), addObject.isBlackMoveFirst(),
				addObject.getTitle(), addObject.getWhiteKing(), addObject.getWhiteMan() };
		long count = this.jdbcTemplateObject.update(SQL_INSERT_POSITION_QUERY, args);
		return count;
	}

	public List<Position> loadAll() {
		List<Position> positions = this.jdbcTemplateObject.query(SQL_SELECT_ALL_POSITION_QUERY, new PositionMapper());
		return positions;
	}

	public Position load(Long id) {
		Position p = (Position) this.jdbcTemplateObject.queryForObject(SQL_SELECT_POSITION_QUERY, new Object[] { id },
				new PositionMapper());
		return p;
	}

	public List<Position> loadByTitle(String title) {
		List<Position> positions = this.jdbcTemplateObject.query(SQL_SELECT_POSITION_BY_TITLE_QUERY,
				new Object[] { title }, new PositionMapper());
		return positions;
	}

	public void delete(Long... ids) {
		this.jdbcTemplateObject.update(SQL_DELETE_POSITION_QUERY, ids[0]);
	}

	public void update(Position updateObject) {
		Object[] args = { updateObject.getBlackKing(), updateObject.getBlackMan(), updateObject.isBlackMoveFirst(),
				updateObject.getTitle(), updateObject.getWhiteKing(), updateObject.getWhiteMan(),
				updateObject.getId(), };
		this.jdbcTemplateObject.update(SQL_UPDATE_POSITION_QUERY, args);
	}

	private class PositionMapper implements RowMapper<Position> {

		public Position mapRow(ResultSet rs, int rowNum) throws SQLException {
			Position p = new Position();
			p.setBlackKing(rs.getString("black_king"));
			p.setBlackMan(rs.getString("black_man"));
			p.setBlackMoveFirst(rs.getBoolean("black_move_first"));
			p.setId(rs.getLong("position_id"));
			p.setTitle(rs.getString("title"));
			p.setWhiteKing(rs.getString("white_king"));
			p.setWhiteMan(rs.getString("white_man"));
			return p;
		}

	}

}
