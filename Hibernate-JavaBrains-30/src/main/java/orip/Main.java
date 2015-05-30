package orip;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import orip.dto.UserDetails;

public class Main {
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
		
		List list = session.createCriteria(UserDetails.class)
			.add(Restrictions.eq("name", "User7"))
			.list();
		
		List list2 = session.createCriteria(UserDetails.class)
			.add(Restrictions.eq("name", "User7"))
			.add(Restrictions.ge("id", 5))
			.list();
		
		List<UserDetails> list3 = (List<UserDetails>) session.createCriteria(UserDetails.class)
			.add(Restrictions.like("name", "%User%"))
			.list();
			
		List<UserDetails> list4 = (List<UserDetails>) session.createCriteria(UserDetails.class)
				.add(Restrictions.like("name", "%User%"))
				.add(Restrictions.between("id", 5, 7))
				.list();
		
		List<UserDetails> list5 = (List<UserDetails>) session.createCriteria(UserDetails.class)
			.add(Restrictions.or(
					Restrictions.eq("name", "User3"),
					Restrictions.eq("name", "User7")))
			.list();
			
		
		System.out.println(((UserDetails) list.get(0)).getName());
		System.out.println(((UserDetails) list2.get(0)).getName());
		
		for (UserDetails u : list3) {
			System.out.println(u.getName());
		}
		
		for (UserDetails u : list4) {
			System.out.println(u.getName());
		}
		
		for (UserDetails u : list5) {
			System.out.println(u.getName());
		}
		
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
