package vn.fpt.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.fpt.edu.entity.AccountEntity;
import vn.fpt.edu.service.AccountService;

@Controller
@CrossOrigin
public class AccountController {
	@Autowired
	AccountService service;
	
	@GetMapping(value = "/api/account/login")
	public boolean checkLogin(String username, String password) {
		return service.loginAccount(username, password);
	}
	
	@GetMapping(value = "/api/account/{user}")
	@ResponseBody
	public AccountEntity getAccount(@PathVariable(name = "user", required = true) String username) throws Exception {
		return service.getAccount(username);
	}
	
	@PostMapping(value = "/api/account")
	@ResponseBody
	public AccountEntity createAccount(@RequestBody AccountEntity account) throws Exception {
		return service.createAccount(account);
	}
	
	@PutMapping(value = "/api/account/{user}")
	@ResponseBody
	public AccountEntity updateAccount(@PathVariable String username, @RequestBody AccountEntity account) throws Exception {
		return service.updateAccount(username, account);
	}
	
	@DeleteMapping(value = "/api/account/{user}")
	@ResponseBody
	public void deleteAccount(@PathVariable String username) throws Exception {
		service.deleteAccount(username);
	}
}
