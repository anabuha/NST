package dto.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import dto.Dto;
import model.Issue;
import model.ProjectType;

public class ProjectDto implements Dto {

	private int projectId;
	private String projectName;
	private String description;
	private Date startDate;
	private Date endDate;
	private ManagerDto manager;
	private ProjectType type;
	private List<IssueDto> issues = new ArrayList<IssueDto>();

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public ManagerDto getManager() {
		return manager;
	}

	public void setManager(ManagerDto manager) {
		this.manager = manager;
	}

	public ProjectType getType() {
		return type;
	}

	public void setType(ProjectType type) {
		this.type = type;
	}

	public List<IssueDto> getIssues() {
		return issues;
	}

	public void setIssues(List<IssueDto> issues) {
		this.issues = issues;
	}

	public ProjectDto(int projectId, String projectName, String description, Date startDate, Date endDate,
			ManagerDto manager, ProjectType type, List<IssueDto> issues) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.manager = manager;
		this.type = type;
		this.issues = issues;
	}

	public ProjectDto() {
		super();
	}
	
	
	
}
