package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="DESTINATION")
public class Destination {
	@Id
	@Column(name="DESTINATION_ID")
	@SequenceGenerator(allocationSize=1,name="destinationSeq",sequenceName="DESTINATION_SEQ")
	@GeneratedValue(generator="destinationSeq",strategy=GenerationType.SEQUENCE)
	Integer destinationID;
	@Column(name="DESTINATION_NAME")
	String destinationName;
	
	
	public Destination() {
		super();
	}
	public Destination(Integer destinationID, String destinationName) {
		super();
		this.destinationID = destinationID;
		this.destinationName = destinationName;
	}
	
	public Integer getDestinationID() {
		return destinationID;
	}
	public void setDestinationID(Integer destinationID) {
		this.destinationID = destinationID;
	}
	public String getDestinationName() {
		return destinationName;
	}
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	
	@Override
	public String toString() {
		return "Destination [destinationID=" + destinationID + ", destinationName=" + destinationName + "]";
	}
}
