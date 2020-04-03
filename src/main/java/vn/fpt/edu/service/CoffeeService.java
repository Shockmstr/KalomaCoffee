package vn.fpt.edu.service;

import java.util.List;

import vn.fpt.edu.entity.CoffeeEntity;

public interface CoffeeService {
	public CoffeeEntity getCoffee(int id) throws Exception;
	public List<CoffeeEntity> getAllCoffee() throws Exception;
	public CoffeeEntity createCoffee(CoffeeEntity entity) throws Exception;
	public CoffeeEntity updateCoffee(int id, CoffeeEntity entity) throws Exception;
	public void deleteCoffee(int id) throws Exception;
}
