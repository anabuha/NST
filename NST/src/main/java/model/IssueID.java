package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class IssueID implements Serializable{

	@Column(name="issue_id", nullable = false)
	private int issueId;
	
	@Column(name="project_id", nullable = false)
	private int projectId;
	
	
	public IssueID() {
	}

	public IssueID(int issueId, int projectId) {
		super();
		this.issueId = issueId;
		this.projectId = projectId;
	}

	public int getIssueId() {
		return issueId;
	}

	public void setIssueId(int issueId) {
		this.issueId = issueId;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + issueId;
		result = prime * result + projectId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IssueID other = (IssueID) obj;
		if (issueId != other.issueId)
			return false;
		if (projectId != other.projectId)
			return false;
		return true;
	}
	
	
	
}
