package org.wikibooks.en;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Product {
	@Id
	private int code;
	private String name;
	private double price;
	@OneToOne(fetch=FetchType.LAZY, optional=false)
	@JoinColumn(name="manufacturer")
	private Manufacturer manufacturer;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Manufacturer getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}
	@Override
	public String toString() {
		return "Product [code=" + code + ", name=" + name + ", price=" + price
				+ ", manufacturer=" + manufacturer.getCode() + "]";
	}
}
