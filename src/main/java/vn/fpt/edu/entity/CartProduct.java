package vn.fpt.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "CartProduct")
@IdClass(value = CartProductId.class)
public class CartProduct {
	@Id
	@Column(name = "cartid")
	private Integer cartId;
	@Id
	@Column(name = "coffeeid")
	private int coffeeId;
	
	@Column(name = "quantity")
	private int quantity;
	@Column(name = "subtotal")
	private double subtotal;
}
