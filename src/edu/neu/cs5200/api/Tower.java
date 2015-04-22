package edu.neu.cs5200.api;

import java.util.List;

import javax.persistence.*;


@Entity
public class Tower{
	@Id
	private int id;
	
	private String name;
	
	private int height;

	private int sides;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="siteId")
	private Site site;
	@OneToMany(mappedBy="tower")
	private List<Equipment> equipments;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getSides() {
		return sides;
	}
	public void setSides(int sides) {
		this.sides = sides;
	}
	public Site getSite() {
		return site;
	}
	public void setSite(Site site) {
		this.site = site;
	}
	public List<Equipment> getEquipments() {
		return equipments;
	}
	public void setEquipments(List<Equipment> equipments) {
		this.equipments = equipments;
	}
	public Tower(String name,int height,int sides ) {
		super();
		this.name = name;
		this.height = height;
		this.sides = sides;
	}
	
	public Tower() {
		super();
	}
	
}
