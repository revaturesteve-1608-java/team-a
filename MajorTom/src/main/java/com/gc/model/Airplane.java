package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AIRPLANE")
public class Airplane {
	@Id
	@Column(name="AIRPLANE_ID")
	@SequenceGenerator(allocationSize=1,name="destinationSeq",sequenceName="DESTINATION_SEQ")
	@GeneratedValue(generator="destinationSeq",strategy=GenerationType.SEQUENCE)
	Integer airplaneId;
	
	@Column(name="AIRPLANE_NAME")
	String airplaneName;
	
//	@OneToMany(fetch=FetchType.LAZY, mappedBy="airplane")
//	@Fetch(FetchMode.JOIN)
//	Set<Flight> flights;
	
	public Airplane() {
	}
	public Airplane(String airplaneName) {
		this.airplaneName = airplaneName;
	}
	
	public Integer getAirplaneId() {
		return airplaneId;
	}
	public void setAirplaneId(Integer airplaneId) {
		this.airplaneId = airplaneId;
	}
	public String getAirplaneName() {
		return airplaneName;
	}
	public void setAirplaneName(String airplaneName) {
		this.airplaneName = airplaneName;
	}
	
	@Override
	public String toString() {
		return "Airplane [airplaneId=" + airplaneId + ", airplaneName=" + airplaneName + "]";
	}
}
