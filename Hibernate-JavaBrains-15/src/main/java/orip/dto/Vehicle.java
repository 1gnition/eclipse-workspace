package orip.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vehicle {
	@Id @GeneratedValue(strategy=GenerationType.TABLE)
	private int vehicleId;
	private String vehicleName;
	@ManyToMany(mappedBy="vehicles")
	private Set<UserDetails> users = new HashSet<UserDetails>();
	
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public Set<UserDetails> getUsers() {
		return users;
	}
	public void setUsers(Set<UserDetails> users) {
		this.users = users;
	}
}
