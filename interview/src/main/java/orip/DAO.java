package orip;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

@Repository(value="dao")
public class DAO {
	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
	
	@Transactional
	public void addUser(User u) {
		em.persist(u);
	}
	
	public User getUser(int id) {
		User user = em.getReference(User.class, 1);
		System.out.println(user.getClass());
		System.out.println(user.getId());
		return user;
	}
	

}
