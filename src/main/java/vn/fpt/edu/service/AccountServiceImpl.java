package vn.fpt.edu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.fpt.edu.entity.AccountEntity;
import vn.fpt.edu.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService{

	@Autowired
	AccountRepository repository;
	
	@Override
	public boolean loginAccount(String username, String password) { 
		try {
			Optional<AccountEntity> optAcc = repository.findById(username);
			if (optAcc.isPresent()) {
				AccountEntity entity = optAcc.get();
				if (entity.getPassword().equals(password)) {
					return true;
				}
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}

	@Override
	public AccountEntity getAccount(String username) throws Exception{
		Optional<AccountEntity> optAcc = repository.findById(username);
		return optAcc.orElse(null);
	}

	@Override
	public AccountEntity createAccount(AccountEntity entity) throws Exception{
		return repository.save(entity);
	}

	@Override
	public void deleteAccount(String username) throws Exception {
		repository.deleteById(username);
	}

	@Override
	public AccountEntity updateAccount(String username, AccountEntity entity) throws Exception{
		Optional<AccountEntity> optAcc = repository.findById(username);
		if (optAcc.isPresent()) {
			AccountEntity oldEntity = optAcc.get();
			entity.setUsername(oldEntity.getUsername());
			return repository.save(entity);
		}else {
			throw new Exception("Account's not found");
		}	
	}
	
}
