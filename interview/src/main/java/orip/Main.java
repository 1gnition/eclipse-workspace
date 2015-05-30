package orip;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		
		DAO dao = ctx.getBean("dao", DAO.class);
		
		User user = new User();
		user.setName("Ori");
		dao.addUser(user);
		
		System.out.println(dao.getUser(1));
		
		
		ctx.close();
	}
}
