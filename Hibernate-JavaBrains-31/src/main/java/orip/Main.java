package orip;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;

import orip.dto.UserDetails;

public class Main {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Configuration config = new Configuration().configure();
		SessionFactory sessionFactory = config.buildSessionFactory(new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build());

		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
//		for (int i = 0; i < 10; i++) {
//			UserDetails userDetails = new UserDetails();
//			userDetails.setName("User" + i);
//			session.save(userDetails);
//		}
		
		List<String> list = (List<String>) session.createCriteria(UserDetails.class)
			.setProjection(Projections.property("name"))
			.list();
		
		List<Integer> list1 = (List<Integer>) session.createCriteria(UserDetails.class)
				.setProjection(Projections.max("id"))
				.list();
		
		List<String> list2 = (List<String>) session.createCriteria(UserDetails.class)
				.setProjection(Projections.property("name"))
				.addOrder(Order.desc("id"))
				.list();
		
		UserDetails userDetails = new UserDetails();
		userDetails.setName("User5");
		
		List<String> list3 = (List<String>) session.createCriteria(UserDetails.class)
				.setProjection(Projections.property("name"))
				.add(Example.create(userDetails))
				.list();
		
		List<String> list4 = (List<String>) session.createCriteria(UserDetails.class)
				.setProjection(Projections.property("name"))
				.add(Example.create(userDetails).excludeProperty("name"))
				.list();
		
		
		UserDetails userDetails1 = new UserDetails();
		userDetails1.setName("%User5%");
		
		List<String> list5 = (List<String>) session.createCriteria(UserDetails.class)
				.setProjection(Projections.property("name"))
				.add(Example.create(userDetails).enableLike())
				.list();
		
		for (String s : list) {
			System.out.println(s);
		}
		
		for (String s : list2) {
			System.out.println(s);
		}
		
		for (String s : list4) {
			System.out.println(s);
		}
		
		for (String s : list5) {
			System.out.println(s);
		}
		
		System.out.println(list3.get(0));
		
		System.out.println(list1.get(0));
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
