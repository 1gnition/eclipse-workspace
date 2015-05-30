package orip;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		UserDetailsDao userDetailsDao = ctx.getBean("userDetailsDaoImpl", UserDetailsDao.class);
		
		Address address1 = new Address();
		address1.setCity("TA");
		address1.setStreet("Mapu");
		
		Address address2 = new Address();
		address2.setCity("Ness-Ziona");
		address2.setStreet("HaBanim");
		
		Address address3 = new Address();
		address3.setCity("Beer-Sheva");
		address3.setStreet("Susu");
		
		UserId userId = new UserId();
		userId.setPin(111);
		userId.setSsn(777);
		
		UserDetails userDetails1 = new UserDetails();
		userDetails1.setUserId(userId);
		userDetails1.setName("User1");
		userDetails1.getAddress().add(address1);
		userDetails1.getAddress().add(address2);
		userDetails1.getAddress().add(address3);
		
		userDetailsDao.save(userDetails1);
		System.out.println("============================");
		System.out.println("============================");
		System.out.println("============================");
		userDetails1 = null;
		userDetails1 = userDetailsDao.get(userId);
		System.out.println(userDetails1.getAddress());
		
		ctx.close();
	}
}
