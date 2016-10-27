package com.gc.dto;

import java.io.Serializable;

/**
 * Data transfer object containing the necessary info to authenticate employees
 */
public class AuthenticationDTO implements Serializable {

	private static final long serialVersionUID = -4619161410746566565L;
	
	private String username;
	private String password;
	
	/**
	 * No-args constructor
	 */
	public AuthenticationDTO() {
		super();
	}

	/**
	 * Constructor with all fields
	 * @param username The username
	 * @param password The password
	 */
	public AuthenticationDTO(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * Returns the username
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
	 * Returns a String representation of the object
	 * @return String representation
	 */
	@Override
	public String toString() {
		return "AuthenticationDTO [username=" + username + ", password=" + password + "]";
	}
	
}
