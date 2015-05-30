package orip.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import orip.dto.Circle;

@Repository
public class HibernateDaoImpl {
	@Autowired
	private SessionFactory sessionFactory;
	
	public long getCircleCount() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query query = session.createQuery("select count(*) from Circle");
		session.getTransaction().commit();
		return (Long) query.uniqueResult();
	}
	
	public void createCircles(String ... names) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		for (String name : names) {
			Circle circle = new Circle();
			circle.setName(name);
			session.save(circle);
		}
		session.getTransaction().commit();
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
