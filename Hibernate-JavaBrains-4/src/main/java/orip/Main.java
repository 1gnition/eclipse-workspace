package orip;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import orip.dto.UserDetails;

public class Main {
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		standardServiceRegistryBuilder.applySettings(configuration.getProperties());
		StandardServiceRegistry serviceRegistry = standardServiceRegistryBuilder.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails userDetails = new UserDetails();
		userDetails.setId(0);
		userDetails.setName("Ori");
		
		session.save(userDetails);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
