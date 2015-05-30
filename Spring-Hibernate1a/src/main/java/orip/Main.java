package orip;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		CircleDao dao = ctx.getBean("circleDaoImpl", CircleDao.class);
		Circle circle = new Circle();
		circle.setName("Second coolest circle");
		dao.save(circle);
		circle = null;
		circle = dao.get(1);
		System.out.println(circle.getName());
		ctx.close();
	}
}
