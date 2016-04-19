package dao;
import java.util.List;

import entity.Position;

public interface IPositionDao extends GenericDao<Position> {

	public List<Position> loadByTitle(String title);
}
