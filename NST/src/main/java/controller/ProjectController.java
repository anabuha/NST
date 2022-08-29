package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dto.impl.EffortDto;
import dto.impl.ProjectDto;
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
	
	@RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<ProjectDto>> getAllProjects(@RequestHeader("managerId") int managerId){
		List<ProjectDto> projects = projectService.getAll(managerId);
		
		return ResponseEntity.status(HttpStatus.OK).body(projects);
    }
	
	@RequestMapping(value="add", method = RequestMethod.POST)
    public ResponseEntity<Object> addProject(@RequestBody ProjectDto project, @RequestHeader("managerId") int managerId ){
		try {
			projectService.addProject(project, managerId);
		 return	ResponseEntity.status(HttpStatus.CREATED).body("Project " + project.getProjectName() + " is created!");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while saving new project!");
		}

    }
	
	@RequestMapping(value="effort", method = RequestMethod.POST)
	public ResponseEntity<Object> saveEffort(@RequestBody EffortDto effort, @RequestHeader("projectId") int projectId, @RequestHeader("issueId") int issueId) {
		
		try {
			projectService.saveEffort(projectId, issueId, effort);
			 return	ResponseEntity.status(HttpStatus.CREATED).body("Effort is successfully added");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while saving new effort!");
		}
		
	}

	
	
}
