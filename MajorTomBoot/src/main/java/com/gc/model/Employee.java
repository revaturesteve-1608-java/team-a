package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Represents the Employee table in the database, mapped with Hibernate
 */
@Entity
@Table(name = "EMPLOYEE")
public class Employee {
	
	/**
	 * The primary key, which is auto-generated via sequence
	 */
	@Id
	@Column(name = "EMPLOYEE_ID")
	@SequenceGenerator(allocationSize = 1, name = "employeeSeq", sequenceName = "EMPLOYEE_SEQ")
	@GeneratedValue(generator = "employeeSeq", strategy = GenerationType.SEQUENCE)
	Integer employeeId;
	
	/**
	 * The username
	 */
	@Column(name="USERNAME")
	String username;
	
	/**
	 * The password
	 */
	@Column(name="PASSWORD")
	String password;
	
	/**
	 * The first name
	 */
	@Column(name="FIRST_NAME")
	String firstName;
	
	/**
	 * The last name
	 */
	@Column(name="LAST_NAME")
	String lastName;
	
	/**
	 * Authentication token (not part of DB)
	 */
	@Transient
	int token;
	
	/**
	 * No-args constructor
	 */
	public Employee() {
		super();
	}
	
	/**
	 * Constructor with all non-PK fields + authentication token
	 * @param employeeId The id
	 * @param username The username
	 * @param password The password
	 * @param firstName The first name
	 * @param lastName The last name
	 * @param token The authentication token (not part of DB)
	 */
	public Employee(Integer employeeId, String username, String password, String firstName, String lastName, int token) {
		super();
		this.employeeId = employeeId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.token = token;
	}

	/**
	 * Gets the employee id
	 * @return The employee id
	 */
	public Integer getEmployeeId() {
		return employeeId;
	}

	/**
	 * Sets the employee id
	 * @param employeeId The employee id
	 */
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * Gets the username
	 * @return The username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username
	 * @param username The username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password
	 * @return The password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password
	 * @param password The password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the first name
	 * @return The first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name
	 * @param firstName The first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name
	 * @return The last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the authentication token
	 * @return The authentication token
	 */
	public int getToken() {
		return token;
	}

	/**
	 * Sets the authentication token
	 * @param token The authentication token
	 */
	public void setToken(int token) {
		this.token = token;
	}

	/**
	 * Returns a String representation of the object
	 * @return String representation
	 */
	@Override
	public String toString() {
		return "Employee [EmployeeId=" + employeeId + ", username=" + username + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", token=" + token + "]";
	}


}
