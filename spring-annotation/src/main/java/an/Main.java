package an;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Foo foo = context.getBean("foo", Foo.class);
		System.out.println(context.getBean("bar"));
		
		Bar bar = foo.getBar();
		System.out.println(bar);
		System.out.println(bar.getString());
		
		System.out.println(context.getBean("myString"));
		
		context.close();
	}

}
