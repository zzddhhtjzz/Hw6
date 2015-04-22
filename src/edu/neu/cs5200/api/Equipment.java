package edu.neu.cs5200.api;

import javax.persistence.*;


@Entity
public class Equipment{
	@Id
	
	private int id;
	
	private String name;

	private String brand;

	private String description;

	private double price;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="towerId")
	private Tower tower;
	
	

	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
		public Tower getTower() {
		return tower;
	}
	public void setTower(Tower tower) {
		this.tower = tower;
	}
	public String getDescription() {
		return description;
	}
	public void setName(String description) {
		this.description = description;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Equipment(String name,String brand, String description,double price ) {
		super();
		this.name = name;
		this.brand = brand;
		this.description = description;
		this.price = price;
	}

	public Equipment() {
		super();
	}
	
}
