package com.gc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gc.model.EmployeeRole;

@Repository
public interface EmployeeRoleRepo extends JpaRepository<EmployeeRole, Integer> {

}
