package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AIRLINE")
public class Airline {
	@Id
	@Column(name="AIRLINE_ID")
	@SequenceGenerator(allocationSize=1,name="airlineSeq",sequenceName="AIRLINE_SEQ")
	@GeneratedValue(generator="airlineSeq",strategy=GenerationType.SEQUENCE)
	Integer airlineId;
	
	@Column(name="AIRLINE_NAME")
	String name;
	
	public Airline() {
		super();
	}
	public Airline(String name) {
		super();
		this.name = name;
	}
	
	public Integer getAirlineId() {
		return airlineId;
	}
	public void setAirlineId(Integer airlineId) {
		this.airlineId = airlineId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "Airline [airlineId=" + airlineId + ", name=" + name + 
				//", flights=" + flights + 
				"]";
	}
	
}
