package orip.dao;

import orip.dto.Circle;

public interface CircleDao {
	void save(Circle circle);
	Circle get(int id);
}
