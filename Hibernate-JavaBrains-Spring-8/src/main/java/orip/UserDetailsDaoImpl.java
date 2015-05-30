package orip;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class UserDetailsDaoImpl implements UserDetailsDao {
	
	@PersistenceContext
	private EntityManager em;

	public void save(UserDetails u) {
		em.persist(u);
	}

	public UserDetails get(int id) {
		return em.find(UserDetails.class, id);
	}

	public UserDetails get(UserId userId) {
		UserDetails userDetails = em.find(UserDetails.class, userId);
		userDetails.getAddress();
		return userDetails;
	}
}
