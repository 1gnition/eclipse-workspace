package orip;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

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
		return em.find(Circle.class, id);
	}
}
