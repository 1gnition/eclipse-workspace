package orip;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
public class UserDetailsDaoImpl implements UserDetailsDao {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional
	public void save(UserDetails u) {
		em.persist(u);
	}

	@Transactional
	public UserDetails get(int id) {
		return em.find(UserDetails.class, id);
	}
}
