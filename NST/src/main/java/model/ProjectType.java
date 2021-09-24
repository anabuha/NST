package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "ProjectType")
@Table(name = "project_type", catalog = "nstdb")
public class ProjectType implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "type_id")
	private int typeId;

	@Column(name = "type_name")
	private String typeName;

	@Column(name = "description")
	private String description;

	public ProjectType() {
	}

	public ProjectType(int typeId, String typeName, String description) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.description = description;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
