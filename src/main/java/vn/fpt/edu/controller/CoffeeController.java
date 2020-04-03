package vn.fpt.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import vn.fpt.edu.entity.CoffeeEntity;
import vn.fpt.edu.service.CoffeeService;

@Controller
public class CoffeeController {
	@Autowired
	CoffeeService service;
	
	@GetMapping("/api/coffee/")
	@ResponseBody
	public List<CoffeeEntity> getListCoffee() throws Exception{
		return service.getAllCoffee();
	}
	
	@GetMapping("/api/coffee/{id}")
	@ResponseBody
	public CoffeeEntity getCoffee(@PathVariable int id) throws Exception{
		return service.getCoffee(id);
	}
	
	@PostMapping("/api/coffee/")
	@ResponseBody
	public CoffeeEntity createCoffee(@RequestBody CoffeeEntity entity)throws Exception {
		return service.createCoffee(entity);
	}
	
	@PutMapping("/api/coffee/{id}")
	@ResponseBody
	public CoffeeEntity updateCoffee(@PathVariable int id, @RequestBody CoffeeEntity entity) throws Exception {
		return service.updateCoffee(id, entity);
	}
	
	@DeleteMapping("/api/coffee/{id}")
	@ResponseBody
	public void deleteCoffee(@PathVariable int id) throws Exception{
		service.deleteCoffee(id);
	}
}
