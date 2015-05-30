package orip;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Main {
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		Main main = ctx.getBean(Main.class, "main");
		main.run(ctx);
		ctx.close();
	}
	
	public void run(ConfigurableApplicationContext ctx) {
		UserDetailsDao userDetailsDao = ctx.getBean(UserDetailsDao.class, "userDetailsDao");
		VehicleDao vehicleDao = ctx.getBean(VehicleDao.class, "vehicleDaoImpl");
		
		FourWheelVehicle vehicle1 = new FourWheelVehicle("Audi");
		FourWheelVehicle vehicle2 = new FourWheelVehicle("BMW");
		TwoWheelVechile vehicle3 = new TwoWheelVechile("Suzuki");
		TwoWheelVechile vehicle4 = new TwoWheelVechile("Harley");
		
		vehicle1.setSteeringWheel("Audi steering wheel");
		vehicle2.setSteeringWheel("BMW steering wheel");
		vehicle3.setHandleBar("Suzuki handlebar");
		vehicle4.setHandleBar("Harley handlebar");
		
		UserDetails userDetails = new UserDetails();
		
		userDetails.setName("Ori");
		userDetails.getVehicles().add(vehicle1);
		userDetails.getVehicles().add(vehicle2);
		userDetails.getVehicles().add(vehicle3);
		userDetails.getVehicles().add(vehicle4);
		
		vehicle1.setUserDetails(userDetails);
		vehicle2.setUserDetails(userDetails);
		vehicle3.setUserDetails(userDetails);
		
		userDetailsDao.save(userDetails);
	}
}
