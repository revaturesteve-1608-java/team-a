package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	@Id
	@Column(name = "EMPLOYEE_ID")
	@SequenceGenerator(allocationSize = 1, name = "employeeSeq", sequenceName = "EMPLOYEE_SEQ")
	@GeneratedValue(generator = "employeeSeq", strategy = GenerationType.SEQUENCE)
	Integer EmployeeId;
	@Column(name="USERNAME")
	String username;
	@Column(name="PASSWORD")
	String password;
	@Column(name="FIRST_NAME")
	String firstName;
	@Column(name="LAST_NAME")
	String lastName;
	
}
