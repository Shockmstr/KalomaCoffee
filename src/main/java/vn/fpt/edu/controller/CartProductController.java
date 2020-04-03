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

import vn.fpt.edu.entity.CartProduct;
import vn.fpt.edu.service.CartProductService;

@Controller
public class CartProductController {
	@Autowired
	CartProductService service;
	
	@GetMapping("/api/cart/product/{cartId}/{coffeeId}")
	@ResponseBody
	public CartProduct getCart(@PathVariable(name = "cartId") int cartId, @PathVariable(name = "coffeeId") int coffeeId) throws Exception{
		return service.getCardProduct(cartId, coffeeId);
	}
	
	@PostMapping("/api/cart/product/")
	@ResponseBody
	public CartProduct createCart(@RequestBody CartProduct entity)throws Exception {
		return service.createCartProduct(entity);
	}
	
	@PutMapping("/api/cart/product/{cartId}/{coffeeId}")
	@ResponseBody
	public CartProduct updateCart(@PathVariable(name = "cartId") int cartId, @PathVariable(name = "coffeeId") int coffeeId, @RequestBody CartProduct entity) throws Exception {
		return service.updateCartProduct(cartId, coffeeId, entity);
	}
	
	@DeleteMapping("/api/cart/product/{cartId}/{coffeeId}")
	@ResponseBody
	public void deleteCart(@PathVariable(name = "cartId") int cartId, @PathVariable(name = "coffeeId") int coffeeId) throws Exception{
		service.deleteCartProduct(cartId, coffeeId);
	}
}
