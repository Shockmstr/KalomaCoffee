package vn.fpt.edu.entity;

import java.io.Serializable;
import java.util.Objects;

public class CartProductId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4377306751117039983L;
	private Integer cartId;
	private int coffeeId;
	
	public CartProductId() {
		// TODO Auto-generated constructor stub
	}

	public CartProductId(Integer cartId, int coffeeId) {
		super();
		this.cartId = cartId;
		this.coffeeId = coffeeId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cartId, coffeeId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof CartProductId))
			return false;
		CartProductId other = (CartProductId) obj;
		return Objects.equals(cartId, other.cartId) && coffeeId == other.coffeeId;
	}
	
	
}

