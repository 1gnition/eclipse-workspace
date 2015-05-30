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
		
		Address homeAddress = new Address();
		homeAddress.setStreet("Elm");
		homeAddress.setCity("Philadelphia");
		homeAddress.setState("Pennysylvenia");
		homeAddress.setPincode("12345");
		
		Address officeAddress = new Address();
		officeAddress.setStreet("Elm");
		officeAddress.setCity("Philadelphia");
		officeAddress.setState("Pennysylvenia");
		officeAddress.setPincode("12345");
		
		UserDetails userDetails = new UserDetails();
		userDetails.setName("Ori");
		userDetails.getAddresses().add(homeAddress);
		userDetails.getAddresses().add(officeAddress);
		
		session.save(userDetails);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
