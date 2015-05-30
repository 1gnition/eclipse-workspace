package orip;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import orip.dto.UserDetails;

public class Main {
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
		
		/* get */
		UserDetails userDetails = (UserDetails) session.get(UserDetails.class, 7);
		System.out.println(userDetails.getName());
		
		/* delete */
		session.delete(userDetails);
		
		/* update */
		userDetails = (UserDetails) session.get(UserDetails.class, 3);
		userDetails.setName("User2 updated");
		session.update(userDetails);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
