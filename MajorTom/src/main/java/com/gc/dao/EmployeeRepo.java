package com.gc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

	public Employee findByUsernameAndPassword(String username, String password);
}
