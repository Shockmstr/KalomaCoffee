package vn.fpt.edu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.fpt.edu.entity.CartProduct;
import vn.fpt.edu.entity.CartProductId;
import vn.fpt.edu.repository.CartProductRepository;

@Service
public class CartProductServiceImpl implements CartProductService {
	@Autowired
	CartProductRepository repository;
	
	@Override
	public CartProduct getCardProduct(int cartId, int coffeeId) throws Exception {
		return repository.findById(new CartProductId(cartId, coffeeId)).orElse(null);
	}

	@Override
	public CartProduct createCartProduct(CartProduct entity) throws Exception {
		return repository.save(entity);
	}

	@Override
	public CartProduct updateCartProduct(int cartId, int coffeeId, CartProduct entity) throws Exception {
		Optional<CartProduct> optCartPro = repository.findById(new CartProductId(cartId, coffeeId));
		if (optCartPro.isPresent()) {
			CartProduct oldPro = optCartPro.get();
			entity.setCartId(oldPro.getCartId());
			entity.setCoffeeId(oldPro.getCoffeeId());
			return repository.save(entity);
		}
		else throw new Exception("Cart Product's not found");
	}

	@Override
	public void deleteCartProduct(int cartId, int coffeeId) throws Exception {
		repository.deleteById(new CartProductId(cartId, coffeeId));
	}

}
