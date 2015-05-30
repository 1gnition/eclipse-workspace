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
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		UserDetails userDetails = new UserDetails();
		userDetails.setName("Ori");
		userDetails.setVehicle(vehicle);
		
		session.save(userDetails);
		session.save(vehicle);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
