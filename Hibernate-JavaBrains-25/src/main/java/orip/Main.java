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
		
		Query query = session.createQuery("from UserDetails");
		List<UserDetails> list = query.list();
		System.out.println(list.size());
		
		query = session.createQuery("from UserDetails where id > 9");
		list = query.list();
		System.out.println(list.size());
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
