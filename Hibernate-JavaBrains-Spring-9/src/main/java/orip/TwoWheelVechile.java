package orip;

import javax.persistence.Entity;

@Entity
public class TwoWheelVechile extends Vehicle {

	private String handleBar;
	
	public TwoWheelVechile(String name) {
		super(name);
	}
	
	public String getHandleBar() {
		return handleBar;
	}

	public void setHandleBar(String handleBar) {
		this.handleBar = handleBar;
	}
}
