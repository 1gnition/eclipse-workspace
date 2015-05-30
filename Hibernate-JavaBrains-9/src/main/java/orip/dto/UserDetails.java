package orip.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="USER_DETAILS")
public class UserDetails {
	@EmbeddedId
	private Id id;
	private String name;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name="HOME_ADDRESS_STREET"), name = "street"),
		@AttributeOverride(column = @Column(name="HOME_ADDRESS_CITY"), name = "city"),
		@AttributeOverride(column = @Column(name="HOME_ADDRESS_STATE"), name = "state"),
		@AttributeOverride(column = @Column(name="HOME_ADDRESS_PINCODE"), name = "pincode")
	})
	private Address homeAddress;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(column = @Column(name="OFFICE_ADDRESS_STREET"), name = "street"),
		@AttributeOverride(column = @Column(name="OFFICE_ADDRESS_CITY"), name = "city"),
		@AttributeOverride(column = @Column(name="OFFICE_ADDRESS_STATE"), name = "state"),
		@AttributeOverride(column = @Column(name="OFFICE_ADDRESS_PINCODE"), name = "pincode")
	})
	private Address officeAddress;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getHomeAddress() {
		return homeAddress;
	}
	public void setHomeAddress(Address homeAddress) {
		this.homeAddress = homeAddress;
	}
	public Address getOfficeAddress() {
		return officeAddress;
	}
	public void setOfficeAddress(Address officeAddress) {
		this.officeAddress = officeAddress;
	}
	public Id getId() {
		return id;
	}
	public void setId(Id id) {
		this.id = id;
	}
}
