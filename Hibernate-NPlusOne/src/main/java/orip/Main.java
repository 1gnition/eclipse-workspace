package orip;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import orip.dto.UserDetails;
import orip.dto.Vehicle;

public class Main {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure();
		StandardServiceRegistryBuilder standardServiceRegistryBuilder = new StandardServiceRegistryBuilder();
		standardServiceRegistryBuilder.applySettings(config.getProperties());
		StandardServiceRegistry serviceRegistry = standardServiceRegistryBuilder.build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		UserDetails userDetails1 = new UserDetails();
		userDetails1.setName("User1");
		UserDetails userDetails2 = new UserDetails();
		userDetails2.setName("User2");
		UserDetails userDetails3 = new UserDetails();
		userDetails3.setName("User3");
		UserDetails userDetails4 = new UserDetails();
		userDetails4.setName("User4");
		
		Vehicle user1Vehicle1 = new Vehicle();
		user1Vehicle1.setVehicleName("U1V1");
		Vehicle user1Vehicle2 = new Vehicle();
		user1Vehicle2.setVehicleName("U1V2");
		Vehicle user1Vehicle3 = new Vehicle();
		user1Vehicle3.setVehicleName("U1V3");
		
		Vehicle user2Vehicle1 = new Vehicle();
		user2Vehicle1.setVehicleName("U2V1");
		Vehicle user2Vehicle2 = new Vehicle();
		user2Vehicle2.setVehicleName("U2V2");
		Vehicle user2Vehicle3 = new Vehicle();
		user2Vehicle3.setVehicleName("U2V3");
		
		Vehicle user3Vehicle1 = new Vehicle();
		user3Vehicle1.setVehicleName("U3V1");
		Vehicle user3Vehicle2 = new Vehicle();
		user3Vehicle2.setVehicleName("U3V2");
		Vehicle user3Vehicle3 = new Vehicle();
		user3Vehicle3.setVehicleName("U3V3");
		
		Vehicle user4Vehicle1 = new Vehicle();
		user4Vehicle1.setVehicleName("U4V1");
		Vehicle user4Vehicle2 = new Vehicle();
		user4Vehicle2.setVehicleName("U4V2");
		Vehicle user4Vehicle3 = new Vehicle();
		user4Vehicle3.setVehicleName("U4V3");
		
		userDetails1.getVehicles().add(user1Vehicle1);
		userDetails1.getVehicles().add(user1Vehicle2);
		userDetails1.getVehicles().add(user1Vehicle3);
		
		userDetails2.getVehicles().add(user2Vehicle1);
		userDetails2.getVehicles().add(user2Vehicle2);
		userDetails2.getVehicles().add(user2Vehicle3);
		
		userDetails3.getVehicles().add(user3Vehicle1);
		userDetails3.getVehicles().add(user3Vehicle2);
		userDetails3.getVehicles().add(user3Vehicle3);
		
		userDetails4.getVehicles().add(user4Vehicle1);
		userDetails4.getVehicles().add(user4Vehicle2);
		userDetails4.getVehicles().add(user4Vehicle3);
		
		session.save(userDetails1);
		session.save(userDetails2);
		session.save(userDetails3);
		session.save(userDetails4);
		
		session.save(user1Vehicle1);
		session.save(user1Vehicle2);
		session.save(user1Vehicle3);
		
		session.save(user2Vehicle1);
		session.save(user2Vehicle2);
		session.save(user2Vehicle3);
		
		session.save(user3Vehicle1);
		session.save(user3Vehicle2);
		session.save(user3Vehicle3);
		
		session.save(user4Vehicle1);
		session.save(user4Vehicle2);
		session.save(user4Vehicle3);
		
		
		session.getTransaction().commit();
		session.close();
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		/**/
		
		List<UserDetails> users = (List<UserDetails>) session.createCriteria(UserDetails.class).list();
		for (UserDetails u : users) {
			Set<Vehicle> vehicles = u.getVehicles();
			for (Vehicle v : vehicles) {
				System.out.println(v.getVehicleName());
			}
		}
		
		
		/**/
		
		session.getTransaction().commit();
		session.close();
		
		
		sessionFactory.close();
	}
}
