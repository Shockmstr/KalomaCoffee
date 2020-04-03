package vn.fpt.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.fpt.edu.entity.CoffeeEntity;
import vn.fpt.edu.repository.CoffeeRepository;

@Service
public class CoffeeServiceImpl implements CoffeeService {
	@Autowired
	CoffeeRepository repository;
	
	@Override
	public CoffeeEntity getCoffee(int id) throws Exception {
		Optional<CoffeeEntity> optCoffee = repository.findById(id);
		return optCoffee.orElse(null);
	}

	@Override
	public List<CoffeeEntity> getAllCoffee() throws Exception {
		return repository.findAll();
	}

	@Override
	public CoffeeEntity createCoffee(CoffeeEntity entity) throws Exception {
		return repository.save(entity);
	}

	@Override
	public CoffeeEntity updateCoffee(int id, CoffeeEntity entity) throws Exception {
		Optional<CoffeeEntity> optCoffee = repository.findById(id);
		if (optCoffee.isPresent()) {
			CoffeeEntity oldCoffee = optCoffee.get();
			entity.setId(oldCoffee.getId());
			return repository.save(entity);
		}
		else throw new Exception("Coffee's not found");
	}

	@Override
	public void deleteCoffee(int id) throws Exception {
		repository.deleteById(id);
	}

	

}
