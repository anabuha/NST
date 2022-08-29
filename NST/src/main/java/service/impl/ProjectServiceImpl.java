package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.impl.EffortDto;
import dto.impl.ProjectDto;
import exception.NoSuchElementFoundException;
import model.Effort;
import model.Issue;
import model.IssueID;
import model.Manager;
import model.Project;
import repository.EffortRepository;
import repository.ManagerRepository;
import repository.ProjectRepository;
import service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepo;

	@Autowired
	ManagerRepository managerRepo;

	@Autowired
	EffortRepository effortRepo;

	
	@Override
	public Project getProject(int id) {
		Project project = projectRepo.findById(id).orElse(null);
		if (project == null) {
			throw new NoSuchElementFoundException("Project with id " + id + " doesn't exist");
		}
		return project;
	}

	@Override
	public List<ProjectDto> getAll(int managerId) {
		Manager m = managerRepo.findById(managerId).orElse(null);
		ModelMapper mapper = new ModelMapper();
        List<ProjectDto> listDto = new ArrayList<ProjectDto>();
        for (Project pr : m.getProjects()) {
			ProjectDto projDto = mapper.map(pr, ProjectDto.class);
			listDto.add(projDto);
		}
        
		return listDto;
	}

	@Override
	public void addProject(ProjectDto projectDto, int managerId) {
		ModelMapper mapper = new ModelMapper();
		Project newProj = mapper.map(projectDto, Project.class);
		
		int counter = 0;
		newProj.setManager(managerRepo.findById(managerId).orElse(null));
		newProj.setProjectId(createProjectId());

		for (Issue issue : newProj.getIssues()) {
			if (issue != null) {
				issue.setIssueID(new IssueID(++counter, newProj.getProjectId()));
			}
		}
		projectRepo.save(newProj);

	}

	private int createProjectId() {
		int projId = projectRepo.getLastProjectId();
		return ++projId;
	}

	@Override
	public void saveEffort(int projectId, int issueId, EffortDto effortDto) {

		Project proj = projectRepo.findById(projectId).orElse(null);

		Issue issue = null;

		for (Issue i : proj.getIssues()) {
			if (i.getIssueID().getIssueId() == issueId) {
				issue = i;
				break;
			}
		}

		ModelMapper mapper = new ModelMapper();
		Effort effort = mapper.map(effortDto, Effort.class);
		
		effort.setIssue(issue);
		effortRepo.save(effort);
	};

}
