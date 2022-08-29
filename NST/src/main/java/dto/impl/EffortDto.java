package dto.impl;

import dto.Dto;
import model.Employee;
import model.Issue;

public class EffortDto implements Dto{
	
	private int effortId;

	private int hours;

	private String description;

	private Issue issue;

	private Employee employee;
	
	public EffortDto() {
		super();
	}

	public EffortDto(int effortId, int hours, String description, Issue issue, Employee employee) {
		super();
		this.effortId = effortId;
		this.hours = hours;
		this.description = description;
		this.issue = issue;
		this.employee = employee;
	}

	public int getEffortId() {
		return effortId;
	}

	public void setEffortId(int effortId) {
		this.effortId = effortId;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
