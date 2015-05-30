package orip;

import javax.persistence.Entity;

@Entity
public class FourWheelVehicle extends Vehicle {

	private String steeringWheel;
	
	public FourWheelVehicle(String name) {
		super(name);
	}

	public String getSteeringWheel() {
		return steeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		this.steeringWheel = steeringWheel;
	}
}
