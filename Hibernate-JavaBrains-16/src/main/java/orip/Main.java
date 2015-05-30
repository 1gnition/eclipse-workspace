package orip;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import orip.dto.UserDetails;
import orip.dto.Vehicle;

public class Main {
	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config
				.buildSessionFactory(new StandardServiceRegistryBuilder()
						.applySettings(config.getProperties())
						.build());
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails userDetails1 = new UserDetails();
		userDetails1.setName("Ori");
		
		Set<Vehicle> vehicles = userDetails1.getVehicles();
		for (int i = 0; i < 100; i++) {
			Vehicle vehicle = new Vehicle();
			vehicle.setName("Vehicle" + i);
			vehicles.add(vehicle);
		}
		
		session.persist(userDetails1);
		
		session.getTransaction().commit();
		session.close();
		
		sessionFactory.close();
		
	}
}
