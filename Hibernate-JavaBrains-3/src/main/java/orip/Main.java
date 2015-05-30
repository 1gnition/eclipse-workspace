package orip;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import orip.dto.UserDetails;

public class Main {
	public static void main(String[] args) {
		/* First we need a SessionFactory:
		 *     SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		 *     
		 * But for creating SessionFactory we need a ServiceRegistry:
		 *     StandardServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		 * 
		 * But for creating a ServiceRegistry we need a ServiceRegistryBuilder:
		 *     StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		 *     serviceRegistryBuilder.applySettings(configuration.getProperties());
		 *     
		 * But for creating the ServiceRegistryBuilder we need a Configuration:
		 *     Configuration configuration = new Configuration().configure()
		 */
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
		serviceRegistryBuilder.applySettings(configuration.getProperties());
		StandardServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
		SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		UserDetails userDetails = new UserDetails();
		userDetails.setId(1);
		userDetails.setName("Ori");
		
		session.save(userDetails);
		
		session.getTransaction().commit();
		
	}
}
