package service;

import java.util.List;

import model.Effort;
import model.Project;

public interface ProjectService {

	Project getProject(int id);
	
	List<Project> getAll();
	
	void addProject(Project project);
	
	void saveEffort(int projectId, int issueId, Effort effort);
}
