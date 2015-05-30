package orip;

import java.util.List;

import org.hibernate.Query;
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
		
		Query query = session.getNamedQuery("UserDetails.byId");
		query.setInteger(0, 4);
		List<UserDetails> list = (List<UserDetails>) query.list();
		for (UserDetails u : list) {
			System.out.println(u.getName());
		}
		
		query = session.getNamedQuery("UserDetails.byName");
		query.setString(0, "User3");
		list = (List<UserDetails>) query.list();
		for (UserDetails u : list) {
			System.out.println(u.getName());
		}
		
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
