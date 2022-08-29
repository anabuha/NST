package dto.impl;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dto.Dto;
import model.Effort;
import model.Manager;

public class EmployeeDto implements Dto{
	
	private int employeeId;
	private String employeeName;
	private String role;
	private Manager manager;
	private List<Effort> efforts;

	public EmployeeDto() {
		super();
	}

	public EmployeeDto(int employeeId, String employeeName, String role, Manager manager, List<Effort> efforts) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.role = role;
		this.manager = manager;
		this.efforts = efforts;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public List<Effort> getEfforts() {
		return efforts;
	}

	public void setEfforts(List<Effort> efforts) {
		this.efforts = efforts;
	}


}
