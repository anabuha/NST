package model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "Project")
@Table(name = "project", catalog = "nstdb")
public class Project implements Serializable{

	@Id
	@Column(name = "project_id", unique = true, nullable = false)
	private int projectId;
	
	@Column(name="project_name")
	private String projectName;
	
	@Column(name="name")
	private String description;
	
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_date")
	private Date startDate;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_dat")
	private Date endDate;

    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id",referencedColumnName="manager_id", nullable=false)
    @JsonIgnore
	private Manager manager;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id",referencedColumnName = "type_id", nullable=false)
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private ProjectType type;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "project")
	private List<Issue> issues;
    

	public Project() {
	}


	public Project(int projectId, String name, String description, Date startDate, Date endDate, Manager manager,
			ProjectType type, List<Issue> issues) {
		this.projectId = projectId;
		this.projectName = name;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.manager = manager;
		this.type = type;
		this.issues = issues;
	}


	public int getProjectId() {
		return projectId;
	}


	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}


	public String getName() {
		return projectName;
	}


	public void setName(String name) {
		this.projectName = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getStartDate() {
		return startDate;
	}


	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}


	public Date getEndDate() {
		return endDate;
	}


	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}


	public Manager getManager() {
		return manager;
	}


	public void setManager(Manager manager) {
		this.manager = manager;
	}


	public ProjectType getType() {
		return type;
	}


	public void setType(ProjectType type) {
		this.type = type;
	}


	public List<Issue> getIssues() {
		return issues;
	}


	public void setIssues(List<Issue> issues) {
		this.issues = issues;
	}
	
	
    
    
}
