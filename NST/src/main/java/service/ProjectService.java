package service;

import java.util.List;

import dto.impl.EffortDto;
import dto.impl.ProjectDto;
import model.Project;

public interface ProjectService {

	Project getProject(int id);
	
	List<ProjectDto> getAll(int managerId);
	
	void addProject(ProjectDto project, int managerId);
	
	void saveEffort(int projectId, int issueId, EffortDto effort);
}
