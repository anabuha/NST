package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public List<Project> getAll() {
		Manager m = managerRepo.findById(1).orElse(null);

		return m.getProjects();
	}

	@Override
	public void addProject(Project project) {
		int counter = 0;
		project.setManager(managerRepo.findById(1).orElse(null));
		project.setProjectId(createProjectId());

		for (Issue issue : project.getIssues()) {
			if (issue != null) {
				issue.setIssueID(new IssueID(project.getProjectId(), ++counter));
			}
		}
		projectRepo.save(project);

	}

	private int createProjectId() {
		int projId = projectRepo.getLastProjectId();
		return ++projId;
	}

	@Override
	public void saveEffort(int projectId, int issueId, Effort effort) {

		Project proj = projectRepo.findById(projectId).orElse(null);

		Issue issue = null;

		for (Issue i : proj.getIssues()) {
			if (i.getIssueID().getIssueId() == issueId) {
				issue = i;
				break;
			}
		}

		effort.setIssue(issue);
		effortRepo.save(effort);
	};

}
