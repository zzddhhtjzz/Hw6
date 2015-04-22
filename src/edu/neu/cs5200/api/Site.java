    package edu.neu.cs5200.api;
	import java.util.List;

import javax.persistence.*;


    @Entity
	public class Site {
		@Id
		private int id;
		
		private String name;
		private int latitude;
	
		private int longitude;
		
		@OneToMany(mappedBy="site")
		private List<Tower> towers;
	
	
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setname(String name) {
			this.name = name;
		}
	
		public int getLatitude() {
			return latitude;
		}
		public void getLatitude(int latitude) {
			this.latitude = latitude;
		}
		public int getLongitude() {
			return longitude;
		}
		public void getlongitude(int longitude) {
			this.longitude = longitude;
		}
		public List<Tower> getTower() {
			return towers;
		}
		public void setTower(List<Tower> towers) {
			this.towers = towers;
		}
		public Site(String name, int latitude, int longitude) {
			super();
			this.name = name;
			this.latitude =latitude;
			this.longitude =longitude;
		}
		public Site() {
			super();
		}
	
	}

