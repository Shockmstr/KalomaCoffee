package vn.fpt.edu.service;

import vn.fpt.edu.entity.CartProduct;

public interface CartProductService {
	public CartProduct getCardProduct(int cartId, int coffeeId) throws Exception;
	public CartProduct createCartProduct(CartProduct entity) throws Exception;
	public CartProduct updateCartProduct(int cartId, int coffeeId, CartProduct entity) throws Exception;
	public void deleteCartProduct(int cartId, int coffeeId) throws Exception;
}
