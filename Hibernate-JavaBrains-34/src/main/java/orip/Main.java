package orip;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import orip.dto.UserDetails;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build());

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
//		for (int i = 0; i < 10; i++) {
//			UserDetails userDetails = new UserDetails();
//			userDetails.setName("User" + i);
//			session.save(userDetails);
//		}
		
		session.createCriteria(UserDetails.class)
		.add(Restrictions.eq("id", 1))
		.setCacheable(true)
		.list();
		
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.createCriteria(UserDetails.class)
		.add(Restrictions.eq("id", 1))
		.setCacheable(true)
		.list();
		
		sessionFactory.close();
	}
}
