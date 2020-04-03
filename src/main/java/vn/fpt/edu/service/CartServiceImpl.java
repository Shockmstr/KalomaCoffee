package vn.fpt.edu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.fpt.edu.entity.CartEntity;
import vn.fpt.edu.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService{
	
	@Autowired
	CartRepository repository;

	@Override
	public CartEntity getCart(int id) throws Exception {
		Optional<CartEntity> optCart = repository.findById(id);
		return optCart.orElse(null);
	}

	@Override
	public CartEntity updateCart(int id, CartEntity entity) throws Exception {
		Optional<CartEntity> optCart = repository.findById(id);
		if (optCart.isPresent()) {
			CartEntity oldCart = optCart.get();
			entity.setId(oldCart.getId());
			return repository.save(entity);
		}
		throw new Exception("Cart's not found");
	}

	@Override
	public CartEntity createCart(CartEntity entity) throws Exception {
		return repository.save(entity);
	}

	@Override
	public void deleteCart(int id) throws Exception {
		repository.deleteById(id);	
	}

	
	
}
