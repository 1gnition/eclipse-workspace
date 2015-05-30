package orip;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import orip.dto.UserDetails;
import orip.dto.Vehicle;

public class Main {
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		standardServiceRegistryBuilder.applySettings(config.getProperties());
		StandardServiceRegistry serviceRegistry = standardServiceRegistryBuilder.build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");
		
		UserDetails userDetails = new UserDetails();
		userDetails.setName("Ori");
		userDetails.getVehicles().add(vehicle1);
		userDetails.getVehicles().add(vehicle2);
		
		session.save(userDetails);
		session.save(vehicle1);
		session.save(vehicle2);
		
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		
		System.out.println("===================================");
		System.out.println("===================================");
		
		session.get(UserDetails.class, 1);
		
		sessionFactory.close();
	}
}
