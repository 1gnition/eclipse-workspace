package orip;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

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
		
		Query query = session.createQuery("select name from UserDetails");
		query.setFirstResult(3);
		query.setMaxResults(5);
		List<String> list1 = (List<String>) query.list();
		
		for (String s : list1) {
			System.out.println(s);
		}
		
		query = session.createQuery("select name, id from UserDetails");
		List<Object[]> list2 = (List<Object[]>) query.list();
		
		for (Object[] l : list2) {
			System.out.println(l[0]);
			System.out.println(l[1]);
		}
		
		query = session.createQuery("select new list(name, id) from UserDetails");
		List<List<?>> list3 = (List<List<?>>) query.list();
		
		for (List<?> l : list3) {
			System.out.println(l.get(0));
			System.out.println(l.get(1));
		}
		
		query = session.createQuery("select new map(name, id) from UserDetails");
		List<Map<Integer, ?>> list4 = (List<Map<Integer, ?>>) query.list();
		
		for (Map<Integer, ?> m : list4) {
			System.out.println(m);
		}
		
		query = session.createQuery("select max(id) from UserDetails");
		List<Integer> list5 = (List<Integer>) query.list();
		System.out.println(list5.get(0));
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}
}
