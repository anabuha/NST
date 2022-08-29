package dto.impl;

import java.util.List;

import dto.Dto;
import model.Effort;
import model.IssueID;
import model.Project;

public class IssueDto implements Dto{

	private IssueID issueID;
	private String issueName;
	private String issueDescription;
	private int storyPoint;
	private String status;
	private Project project;
	private List<Effort> efforts;


	public IssueDto() {
		super();
	}

	public IssueDto(IssueID issueID, String issueName, String issueDescription, int storyPoint, String status,
			Project project, List<Effort> efforts) {
		super();
		this.issueID = issueID;
		this.issueName = issueName;
		this.issueDescription = issueDescription;
		this.storyPoint = storyPoint;
		this.status = status;
		this.project = project;
		this.efforts = efforts;
	}

	public IssueID getIssueID() {
		return issueID;
	}

	public void setIssueID(IssueID issueID) {
		this.issueID = issueID;
	}



	public int getStoryPoint() {
		return storyPoint;
	}

	public void setStoryPoint(int storyPoint) {
		this.storyPoint = storyPoint;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Effort> getEfforts() {
		return efforts;
	}

	public void setEfforts(List<Effort> efforts) {
		this.efforts = efforts;
	}

	public String getIssueName() {
		return issueName;
	}

	public void setIssueName(String issueName) {
		this.issueName = issueName;
	}

	public String getIssueDescription() {
		return issueDescription;
	}

	public void setIssueDescription(String issueDescription) {
		this.issueDescription = issueDescription;
	}
	
	
}
