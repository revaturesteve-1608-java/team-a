package com.gc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_ROLE")
public class EmployeeRole {
	@Id
	@Column(name = "EMPLOYEE_ROLE_ID")
	@SequenceGenerator(allocationSize = 1, name = "employeeRoleSeq", sequenceName = "EMPLOYEE_ROLE_SEQ")
	@GeneratedValue(generator = "employeeRoleSeq", strategy = GenerationType.SEQUENCE)
	Integer employeeRoleId;
	@Column(name="ROLE_NAME")
	String roleName;
	
	
	public EmployeeRole() {
		super();
	}
	public EmployeeRole(Integer employeeRoleId, String roleName) {
		super();
		this.employeeRoleId = employeeRoleId;
		this.roleName = roleName;
	}
	
	public Integer getSeatId() {
		return employeeRoleId;
	}
	public void setSeatId(Integer employeeRoleId) {
		this.employeeRoleId = employeeRoleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	@Override
	public String toString() {
		return "EmployeeRole [employeeRoleId=" + employeeRoleId + ", roleName=" + roleName + "]";
	}
}
