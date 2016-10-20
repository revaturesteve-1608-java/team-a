package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Represents the Destination table in the database, mapped with Hibernate
 */
@Entity
@Table(name="DESTINATION")
public class Destination {
	
	/**
	 * The primary key, which is auto-generated via sequence
	 */
	@Id
	@Column(name="DESTINATION_ID")
	@SequenceGenerator(allocationSize=1,name="destinationSeq",sequenceName="DESTINATION_SEQ")
	@GeneratedValue(generator="destinationSeq",strategy=GenerationType.SEQUENCE)
	Integer destinationID;
	
	/**
	 * The destination name
	 */
	@Column(name="DESTINATION_NAME")
	String destinationName;
	
	/**
	 * The destination code, with length 4
	 */
	@Column(name="DESTINATION_CODE", length=4)
	String destinationCode;
	
	/**
	 * No-args constructor
	 */
	public Destination() {
		super();
	}
	
	/**
	 * Constructor with all non-PK fields
	 * @param destinationName The name
	 * @param destinationCode The code
	 */
	public Destination(String destinationName, String destinationCode) {
		super();
		this.destinationName = destinationName;
		this.destinationCode = destinationCode;
	}

	/**
	 * Gets the destination id
	 * @return The destination id
	 */
	public Integer getDestinationID() {
		return destinationID;
	}
	
	/**
	 * Sets the destination id
	 * @param destinationID The destination id
	 */
	public void setDestinationID(Integer destinationID) {
		this.destinationID = destinationID;
	}
	
	/**
	 * Gets the destination name
	 * @return The destination name
	 */
	public String getDestinationName() {
		return destinationName;
	}
	
	/**
	 * Sets the destination name
	 * @param destinationName The destination name
	 */
	public void setDestinationName(String destinationName) {
		this.destinationName = destinationName;
	}
	
	/**
	 * Gets the destination code
	 * @return The destination code
	 */
	public String getDestinationCode() {
		return destinationCode;
	}
	
	/**
	 * Sets the destination code
	 * @param destinationCode The destination code
	 */
	public void setDestinationCode(String destinationCode) {
		this.destinationCode = destinationCode;
	}
	
	/**
	 * Returns a String representation of the object
	 * @return String representation
	 */
	@Override
	public String toString() {
		return "Destination [destinationID=" + destinationID + ", destinationName=" + destinationName
				+ ", destinationCode=" + destinationCode + "]";
	}
	
}
