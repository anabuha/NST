package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "effort", catalog = "nstdb")
public class Effort {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "effort_id")
	private int effortId;

	@Column(name = "hours")
	private int hours;

	@Column(name = "description")
	private String description;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({ @JoinColumn(name = "issue_id", referencedColumnName = "issue_id", nullable = false),
			@JoinColumn(name = "project_id", referencedColumnName = "project_id", nullable = false) })
	@JsonIgnore
	private Issue issue;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employee_id", nullable = false, updatable = false)
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Employee employee;

	
	public Effort() {
		super();
	}

	public Effort(int effortId, int hours, String description, Issue issue, Employee employee) {
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
