package service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.NoSuchElementFoundException;
import model.Manager;
import repository.ManagerRepository;
import service.ManagerService;

@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerRepository managerRepository;

	@Override
	public Manager getManager(int managerId) {
		Manager m = managerRepository.findById(managerId).orElse(null);

		if (m == null) {
			throw new NoSuchElementFoundException("Manager with id " + managerId + " doesn't exist");
		}

		return m;
	}

	@Override
	public Manager login(Manager m) {

		List<Manager> managers = managerRepository.findByUsernameAndPassword(m.getUsername(), m.getPassword());
		
		if (managers != null && !managers.isEmpty())
			return managers.get(0);
		else
			return null;

	}

}
