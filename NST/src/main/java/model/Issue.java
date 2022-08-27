package model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
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
	private String issueName;

    @Column(name = "description")
	private String issueDescription;

	@Column(name = "story_point")
	private int storyPoint;

	@Column(name = "status")
	private String status;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_id", nullable = false, insertable = false, updatable = false)
	@MapsId("project_id")
	@JsonIgnore
	private Project project;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE,mappedBy = "issue")
	private List<Effort> efforts;

	public Issue() {
	}

	public Issue(IssueID issueID, String issueName, String issueDescription, int storyPoint, String status) {
		this.issueID = issueID;
		this.issueName = issueName;
		this.issueDescription = issueDescription;
		this.storyPoint = storyPoint;
		this.status = status;
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
