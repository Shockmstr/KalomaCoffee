package vn.fpt.edu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode
@Entity
@Table(name = "Cart")
public class CartEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartid")
	private Integer id;
	@Column(name = "username")
	private String username;
	@Column(name = "totalprice")
	private double totalPrice;
	
	public CartEntity() {
		// TODO Auto-generated constructor stub
	}

	public CartEntity(int id, String username, double totalPrice) {
		super();
		this.id = id;
		this.username = username;
		this.totalPrice = totalPrice;
	}

	public CartEntity(String username, double totalPrice) {
		super();
		this.username = username;
		this.totalPrice = totalPrice;
	}
	
	
}
