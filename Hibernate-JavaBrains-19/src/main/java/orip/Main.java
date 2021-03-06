package orip;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import orip.dto.FourWheelVehicle;
import orip.dto.TwoWheelVehicle;
import orip.dto.Vehicle;

public class Main {
	
	public static void main(String[] args) {
		
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build());
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("Car");
		
		TwoWheelVehicle vehicle2 = new TwoWheelVehicle();
		vehicle2.setVehicleName("Joyride");
		vehicle2.setHandleBar("Scooter Handle Bar");
		
		FourWheelVehicle vehicle3 = new FourWheelVehicle();
		vehicle3.setVehicleName("Mazda");
		vehicle3.setSteeringWheel("Mazda Steering Wheel");
		
		session.save(vehicle1);
		session.save(vehicle2);
		session.save(vehicle3);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
