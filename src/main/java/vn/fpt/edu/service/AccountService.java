package vn.fpt.edu.service;

import vn.fpt.edu.entity.AccountEntity;

public interface AccountService {
	public boolean loginAccount(String username, String password);
	public AccountEntity getAccount(String username) throws Exception;
	public AccountEntity createAccount(AccountEntity entity) throws Exception;
	public void deleteAccount(String username) throws Exception;
	public AccountEntity updateAccount(String username, AccountEntity entity) throws Exception;
}
