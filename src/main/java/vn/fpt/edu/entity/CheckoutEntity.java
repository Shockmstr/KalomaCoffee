package vn.fpt.edu.entity;

import java.sql.Timestamp;

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
@Table(name = "Checkout")
public class CheckoutEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "checkoutid")
	private Integer id;
	@Column(name = "username")
	private String username;
	@Column(name = "cartid")
	private int cartId;
	@Column(name = "datecreated")
	private Timestamp dateCreated;
	
	public CheckoutEntity() {
		// TODO Auto-generated constructor stub
	}

	public CheckoutEntity(int id, String username, int cartId, Timestamp dateCreated) {
		super();
		this.id = id;
		this.username = username;
		this.cartId = cartId;
		this.dateCreated = dateCreated;
	}

	public CheckoutEntity(String username, int cartId, Timestamp dateCreated) {
		super();
		this.username = username;
		this.cartId = cartId;
		this.dateCreated = dateCreated;
	}
	
	
}
