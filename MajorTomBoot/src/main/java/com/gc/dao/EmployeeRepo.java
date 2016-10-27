package com.gc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.model.Employee;

/**
 * Interface for Employee DAO methods, using Spring Data
 */
@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	/**
	 * Returns an Employee by username and password
	 * @param username The Employee username
	 * @param password The Employee password
	 * @return The Employee with the matching username and password
	 */
	public Employee findByUsernameAndPassword(String username, String password);
}
