package orip.dto;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Id implements Serializable {
	private static final long serialVersionUID = 1L;
	private int ssn;
	private int pin;
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	public int getPin() {
		return pin;
	}
	public void setPin(int pin) {
		this.pin = pin;
	}
	
}
