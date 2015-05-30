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
		
		UserDetails userDetails1 = new UserDetails();
		userDetails1.setName("Ori");
		userDetails1.getVehicles().add(vehicle1);
		userDetails1.getVehicles().add(vehicle2);
		
		vehicle1.getUsers().add(userDetails1);
		vehicle2.getUsers().add(userDetails1);
		
		UserDetails userDetails2 = new UserDetails();
		userDetails2.setName("Mike");
		userDetails2.getVehicles().add(vehicle1);
		
		vehicle1.getUsers().add(userDetails2);
		
		session.save(userDetails1);
		session.save(userDetails2);
		session.save(vehicle1);
		session.save(vehicle2);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
