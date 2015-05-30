package orip;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

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
		
		session.get(UserDetails.class, 1);
		
		/* no additional "select" query here! */
		UserDetails userDetails = (UserDetails) session.get(UserDetails.class, 1);
		
		
		userDetails.setName("User1 updated");
		/* no additional "select" also here! */
		session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		/* A select is done here because the session was closed. First-level cache */
		session.get(UserDetails.class, 1);
		
		sessionFactory.close();
	}
}
