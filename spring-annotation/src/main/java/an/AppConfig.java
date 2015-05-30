package an;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:beans2.xml")
public class AppConfig {
	@Bean(name="bar")
	public Bar getBar() {
		Bar bar = new Bar();
		bar.setString("123");
		System.out.println(bar);
		return bar;
	}
	
	@Bean(name="foo")
	public Foo getFoo() {
		Foo foo = new Foo();
		foo.setBar(getBar());
		return foo;
	}
}