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

import vn.fpt.edu.entity.CheckoutEntity;
import vn.fpt.edu.service.CheckoutService;

@Controller
@CrossOrigin
public class CheckoutController {
	@Autowired
	CheckoutService service;
	
	@GetMapping("/api/checkout/{id}")
	@ResponseBody
	public CheckoutEntity getCheckout(@PathVariable int id) throws Exception{
		return service.getCheckout(id);
	}
	
	@PostMapping("/api/checkout/")
	@ResponseBody
	public CheckoutEntity createCheckout(@RequestBody CheckoutEntity entity)throws Exception {
		return service.createCheckout(entity);
	}
	
	@PutMapping("/api/checkout/{id}")
	@ResponseBody
	public CheckoutEntity updateCheckout(@PathVariable int id, @RequestBody CheckoutEntity entity) throws Exception {
		return service.updateCheckout(id, entity);
	}
	
	@DeleteMapping("/api/checkout/{id}")
	@ResponseBody
	public void deleteCheckout(@PathVariable int id) throws Exception{
		service.deleteCheckout(id);
	}
}
