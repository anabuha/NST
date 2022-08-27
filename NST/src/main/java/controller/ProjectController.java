package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.Effort;
import model.Project;
import service.ProjectService;

@RestController
@RequestMapping("/projects")
@CrossOrigin
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "/{id}")
	public Project getProject(@PathVariable int id) {
		return projectService.getProject(id);
	}
	
	@RequestMapping(value="", method = RequestMethod.GET)
    public List<Project> vratiSveProjekte(){
        return projectService.getAll();
    }
	
	@RequestMapping(value="add", method = RequestMethod.POST)
    public void addProject(@RequestBody Project project){
        //TODO validate project
		
		projectService.addProject(project);
    }
	
	@RequestMapping(value="effort", method = RequestMethod.POST)
	public void saveEffort(@RequestBody Effort effort, @RequestHeader("projectId") int projectId, @RequestHeader("issueId") int issueId) {
		projectService.saveEffort(projectId, issueId, effort);
	}
}
