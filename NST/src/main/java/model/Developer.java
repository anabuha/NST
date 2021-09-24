package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "Developer")
@Table(name = "developer", catalog = "nstdb")
public class Developer implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "developer_id")
	private int developerId;

	@Column(name = "name")
	private String name;

	@Column(name = "role")
	private String role;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id", referencedColumnName = "manager_id", nullable = false)
	private Manager manager;

	public Developer() {
	}

	public Developer(int developerId, String name, String role, Manager manager) {
		this.developerId = developerId;
		this.name = name;
		this.role = role;
		this.manager = manager;
	}

	public int getDeveloperId() {
		return developerId;
	}

	public void setDeveloperId(int developerId) {
		this.developerId = developerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

}
