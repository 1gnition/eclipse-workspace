package orip;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import orip.dao.DaoImpl;


public class Main {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		DaoImpl dao = ctx.getBean("daoImpl", DaoImpl.class);
		System.out.println(dao.getCircle(4).getName());
		
		ctx.close();
	}
}
