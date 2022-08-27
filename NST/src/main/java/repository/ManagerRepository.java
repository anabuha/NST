package repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import model.Manager;

public interface ManagerRepository extends CrudRepository<Manager, Integer> {
	@Query("SELECT m FROM Manager m WHERE m.username = ?1 AND password = ?2")
    List<Manager> findByUsernameAndPassword(String username, String password);
}
