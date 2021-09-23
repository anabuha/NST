package repository;

import org.springframework.data.repository.CrudRepository;

import model.Manager;

public interface ManagerRepository extends CrudRepository<Manager, Integer>{

}
