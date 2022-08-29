package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.ProjectType;
import service.ProjectTypeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/projectType")
public class ProjectTypeController {

	@Autowired
	private ProjectTypeService projTypeService;

	@RequestMapping()
	public List<ProjectType> getAll() {
		return projTypeService.getAllProjectTypes();
	}
}
