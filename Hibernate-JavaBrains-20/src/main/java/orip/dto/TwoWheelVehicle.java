package orip.dto;

import javax.persistence.Entity;

@Entity
public class TwoWheelVehicle extends Vehicle {
	private String handleBar;

	public String getHandleBar() {
		return handleBar;
	}

	public void setHandleBar(String handleBar) {
		this.handleBar = handleBar;
	}
}
