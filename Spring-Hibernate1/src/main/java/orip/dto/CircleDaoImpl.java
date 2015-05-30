package orip.dto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import orip.dao.CircleDao;

@Repository
public class CircleDaoImpl implements CircleDao {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void save(Circle circle) {
		em.persist(circle);
		em.flush();
	}

	@Transactional
	public Circle get(int id) {
		Circle circle = em.find(Circle.class, 1);
		return circle;
	}

}
