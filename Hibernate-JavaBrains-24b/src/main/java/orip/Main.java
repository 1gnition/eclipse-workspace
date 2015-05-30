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
		
//		UserDetails userDetails = new UserDetails();
//		userDetails.setName("Ori");
//		session.save(userDetails);
		
		UserDetails userDetails = (UserDetails) session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		/* get data from user... */
		userDetails.setName("Ori updated");
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		/* make the object persistent again */
		session.update(userDetails);
		
		/* make another modification. observe how many updates Hibernate issued */
		userDetails.setName("Ori updated again");
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
