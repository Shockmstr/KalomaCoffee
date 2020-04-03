package vn.fpt.edu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.fpt.edu.entity.CheckoutEntity;
import vn.fpt.edu.repository.CheckoutRepository;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	@Autowired
	CheckoutRepository repository;
	
	@Override
	public CheckoutEntity getCheckout(int id) throws Exception {
		return repository.findById(id).orElse(null);
	}

	@Override
	public CheckoutEntity createCheckout(CheckoutEntity entity) throws Exception {
		return repository.save(entity);
	}

	@Override
	public CheckoutEntity updateCheckout(int id, CheckoutEntity entity) throws Exception {
		Optional<CheckoutEntity> optCheck = repository.findById(id);
		if (optCheck.isPresent()) {
			CheckoutEntity oldCheck = optCheck.get();
			entity.setId(oldCheck.getId());
			return repository.save(entity);
		}
		else throw new Exception("Checkout's not found");
	}

	@Override
	public void deleteCheckout(int id) throws Exception {
		repository.deleteById(id);
	}

}
