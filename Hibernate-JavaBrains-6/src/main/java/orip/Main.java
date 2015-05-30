package orip;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import orip.dto.UserDetails;

public class Main {
	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		standardServiceRegistryBuilder.applySettings(config.getProperties());
		StandardServiceRegistry serviceRegistry = standardServiceRegistryBuilder.build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails userDetails = new UserDetails();
		userDetails.setId(1);
		userDetails.setName("Ori");
		userDetails.setAddress("My address");
		userDetails.setDescription("My description");
		userDetails.setTime(new Date());
		
		session.save(userDetails);
		
		session.getTransaction().commit();
		
		userDetails = null;
		
		session.beginTransaction();
		
		userDetails = (UserDetails) session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		
		System.out.println(userDetails);
		
		session.close();
		sessionFactory.close();
	}
}
