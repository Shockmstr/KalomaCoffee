package vn.fpt.edu.service;

import vn.fpt.edu.entity.CartEntity;

public interface CartService {
	public CartEntity getCart(int id) throws Exception;
	public CartEntity updateCart(int id, CartEntity entity)throws Exception;
	public CartEntity createCart(CartEntity entity)throws Exception;
	public void deleteCart(int id)throws Exception;
}
