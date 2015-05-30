package orip;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table(name="user_details")
public class UserDetails {
	@EmbeddedId
	private UserId userId;
	private String name;
	@ElementCollection(fetch=FetchType.EAGER)
	@JoinTable(name="addresses", joinColumns={
		@JoinColumn(name="user_pin", referencedColumnName="pin"),
		@JoinColumn(name="user_ssn", referencedColumnName="ssn")
	})
	@GenericGenerator(name="hilo-gen", strategy="hilo")
	@CollectionId(type=@Type(type="long"), generator="hilo-gen", columns=@Column(name="list_id"))
	private List<Address> address = new ArrayList<Address>();
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public UserId getUserId() {
		return userId;
	}
	public void setUserId(UserId userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
