package orip;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import orip.dto.Address;
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
		
		Address address = new Address();
		address.setStreet("Elm");
		address.setCity("Philadelphia");
		address.setState("Pennysylvenia");
		address.setPincode("12345");
		
		UserDetails userDetails = new UserDetails();
		userDetails.setName("Ori");
		userDetails.setAddress(address);
		
		session.save(userDetails);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
	}
}
