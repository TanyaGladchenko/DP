package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import dao.IMovesDao;
import entity.Moves;

public class MovesJdbc implements IMovesDao {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;

	private static final String SQL_INSERT_MOVES_QUERY = "INSERT INTO MOVES (protocol_id, number, move_white, comment_white, move_black, comment_black) values (?,?,?,?,?,?)";
	private static final String SQL_UPDATE_MOVES_QUERY = "UPDATE MOVES SET number=?, move_white=?, comment_white=?, move_black=?, comment_black=? WHERE moves_id=?";
	private static final String SQL_DELETE_MOVES_QUERY = "DELETE FROM MOVES WHERE moves_id=?";
	private static final String SQL_SELECT_MOVES_QUERY = "SELECT * FROM MOVES WHERE moves_id=?";
	private static final String SQL_SELECT_ALL_MOVES_QUERY = "SELECT * FROM MOVES ORDER BY protocol_id, number";
	private static final String SQL_SELECT_MOVES_BY_PROTOCOL_QUERY = "SELECT * FROM MOVES WHERE protocol_id=?";

	public void setDataSource(DataSource ds) {
		this.dataSource = ds;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public void add(Moves addObject) {
		Object[] args = { addObject.getProtocolId(), addObject.getNumber(), addObject.getMoveWhite(),
				addObject.getCommentWhite(), addObject.getMoveBlack(), addObject.getCommentBlack() };
		this.jdbcTemplateObject.update(SQL_INSERT_MOVES_QUERY, args);
	}

	public List<Moves> loadAll() {
		List<Moves> listMoves = this.jdbcTemplateObject.query(SQL_SELECT_ALL_MOVES_QUERY, new MovesMapper());
		return listMoves;
	}

	public Moves load(Long id) {
		Moves m = this.jdbcTemplateObject.queryForObject(SQL_SELECT_MOVES_QUERY, new Object[] { id },
				new MovesMapper());
		return m;
	}

	public void delete(Long... ids) {
		this.jdbcTemplateObject.update(SQL_DELETE_MOVES_QUERY, ids[0]);
	}

	public void update(Moves updateObject) {
		Object[] args = { updateObject.getNumber(), updateObject.getMoveWhite(), updateObject.getCommentWhite(),
				updateObject.getMoveBlack(), updateObject.getCommentBlack(), updateObject.getId() };
		this.jdbcTemplateObject.update(SQL_UPDATE_MOVES_QUERY, args);
	}

	public List<Moves> loadByProtocol(Long protocolId) {
		List<Moves> listMoves = this.jdbcTemplateObject.query(SQL_SELECT_MOVES_BY_PROTOCOL_QUERY,
				new Object[] { protocolId }, new MovesMapper());
		return listMoves;
	}

	private class MovesMapper implements RowMapper<Moves> {

		public Moves mapRow(ResultSet rs, int rowNum) throws SQLException {
			Moves m = new Moves();
			m.setId(rs.getLong("moves_id"));
			m.setProtocolId(rs.getLong("protocol_id"));
			m.setNumber(rs.getInt("number"));
			m.setMoveWhite(rs.getString("move_white"));
			m.setCommentWhite(rs.getString("comment_white"));
			m.setMoveBlack(rs.getString("move_black"));
			m.setCommentBlack(rs.getString("comment_black"));
			return m;
		}

	}
}
