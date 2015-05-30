package orip;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class VehicleDaoImpl implements VehicleDao {
	
	@PersistenceContext
	private EntityManager em;

	@Transactional
	public void save(Vehicle v) {
		em.persist(v);
	}

	public Vehicle get(int id) {
		return em.find(Vehicle.class, id);
	}

}
