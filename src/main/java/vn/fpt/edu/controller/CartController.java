package vn.fpt.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.fpt.edu.entity.CartEntity;
import vn.fpt.edu.service.CartService;

@Controller
public class CartController {
	@Autowired
	CartService service;
	
	@GetMapping("/api/cart/{id}")
	@ResponseBody
	public CartEntity getCart(@PathVariable int id) throws Exception{
		return service.getCart(id);
	}
	
	@PostMapping("/api/cart/")
	@ResponseBody
	public CartEntity createCart(@RequestBody CartEntity entity)throws Exception {
		return service.createCart(entity);
	}
	
	@PutMapping("/api/cart/{id}")
	@ResponseBody
	public CartEntity updateCart(@PathVariable int id, @RequestBody CartEntity entity) throws Exception {
		return service.updateCart(id, entity);
	}
	
	@DeleteMapping("/api/cart/{id}")
	@ResponseBody
	public void deleteCart(@PathVariable int id) throws Exception{
		service.deleteCart(id);
	}
}
