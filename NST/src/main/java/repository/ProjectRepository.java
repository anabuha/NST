package repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import model.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
	@Query("SELECT MAX(p.projectId) FROM Project p")
	int getLastProjectId();
}
