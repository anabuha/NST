package service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.impl.ManagerDto;
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
	public ManagerDto login(ManagerDto m) {

		List<Manager> managers = managerRepository.findByUsernameAndPassword(m.getUsername(),m.getPassword());
		ModelMapper mapper = new ModelMapper();
		ManagerDto managerDto = null;
		if (managers != null && !managers.isEmpty()) {
			managerDto = mapper.map(managers.get(0), ManagerDto.class);
		}
		return managerDto;

	}

}
