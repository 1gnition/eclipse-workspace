package orip;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import orip.dao.HibernateDaoImpl;

public class Main {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		HibernateDaoImpl dao = ctx.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		
		dao.createCircles("circle1", "circle2", "circle3");
		
		System.out.println("The number is " + dao.getCircleCount());
		ctx.close();
	}
}
