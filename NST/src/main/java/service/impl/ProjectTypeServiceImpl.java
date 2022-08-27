package service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.ProjectType;
import repository.ProjectTypeRepository;
import service.ProjectTypeService;

@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {

	@Autowired
	ProjectTypeRepository projTypeRepo;

	@Override
	public List<ProjectType> getAllProjectTypes() {
		List<ProjectType> types = new ArrayList<ProjectType>();
		projTypeRepo.findAll().forEach(types::add);
		return types;
	}

}
