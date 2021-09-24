package model;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Issue")
@Table(name = "issue", catalog = "nstdb")
public class Issue implements Serializable {

	@EmbeddedId
	@AttributeOverrides({ @AttributeOverride(name = "project", column = @Column(name = "project_id", nullable = false)),
			@AttributeOverride(name = "issue", column = @Column(name = "issue_id", nullable = false)) })
	private IssueID issueID;

	@Column(name = "issue_name")
	private String name;

	@Column(name = "description")
	private String description;

	@Column(name = "story_point")
	private int storyPoint;

	@Column(name = "status")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = false, insertable = false, updatable = false)
	@JsonIgnore
	private Project project;

	public Issue() {
	}

	public Issue(IssueID issueID, String name, String description, int storyPoint, String status) {
		this.issueID = issueID;
		this.name = name;
		this.description = description;
		this.storyPoint = storyPoint;
		this.status = status;
	}

	public IssueID getIssueID() {
		return issueID;
	}

	public void setIssueID(IssueID issueID) {
		this.issueID = issueID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	

}
