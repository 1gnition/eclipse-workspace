package orip.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value="two_wheels")
public class TwoWheelVehicle extends Vehicle {
	private String handleBar;

	public String getHandleBar() {
		return handleBar;
	}

	public void setHandleBar(String handleBar) {
		this.handleBar = handleBar;
	}
}
