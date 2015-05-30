package orip;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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
		
		Query query = session.createQuery("from UserDetails where id > ?");
		query.setInteger(0, 4);
		System.out.println(query.list());
		
		query = session.createQuery("from UserDetails where id > :id");
		query.setInteger("id", 4);
		System.out.println(query.list());
		
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
