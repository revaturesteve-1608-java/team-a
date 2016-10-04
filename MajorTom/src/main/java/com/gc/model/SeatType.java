package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SEAT_TYPE")
public class SeatType {
	@Id
	@Column(name = "SEAT_TYPE_ID")
	@SequenceGenerator(allocationSize = 1, name = "seatTypeSeq", sequenceName = "SEAT_TYPE_SEQ")
	@GeneratedValue(generator = "airlineSseatTypeSeqeq", strategy = GenerationType.SEQUENCE)
	Integer seatTypeId;
	@Column(name="SEAT_TYPE_NAME")
	String seatTypeName;
	
	
	public SeatType() {
		super();
	}
	public SeatType(Integer seatTypeId, String seatTypeName) {
		super();
		this.seatTypeId = seatTypeId;
		this.seatTypeName = seatTypeName;
	}
	
	public Integer getSeatTypeId() {
		return seatTypeId;
	}
	public void setSeatTypeId(Integer seatTypeId) {
		this.seatTypeId = seatTypeId;
	}
	public String getSeatTypeName() {
		return seatTypeName;
	}
	public void setSeatTypeName(String seatTypeName) {
		this.seatTypeName = seatTypeName;
	}
	
	@Override
	public String toString() {
		return "SeatType [seatTypeId=" + seatTypeId + ", seatTypeName=" + seatTypeName + "]";
	}
}
