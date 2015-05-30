package orip;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import orip.dto.Address;
import orip.dto.Id;
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
		
		Id id = new Id();
		id.setSsn(123);
		id.setPin(456);
		
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
		userDetails.setId(id);
		userDetails.setHomeAddress(homeAddress);
		userDetails.setOfficeAddress(officeAddress);
		
		session.save(userDetails);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
