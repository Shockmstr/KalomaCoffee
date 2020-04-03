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
@Table(name = "Coffee")
public class CoffeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coffeeid")
	private Integer id;
	@Column(name = "coffeename")
	private String name;
	private double price;
	private String description;
	private String ingredients;
	private String origin;
	@Column(name = "coffeeimage")
	private byte[] image;
	
	public CoffeeEntity() {
		// TODO Auto-generated constructor stub
	}

	public CoffeeEntity(int id, String name, double price, String description, String ingredients, String origin,
			byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.ingredients = ingredients;
		this.origin = origin;
		this.image = image;
	}

	public CoffeeEntity(String name, double price, String description, String ingredients, String origin,
			byte[] image) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.ingredients = ingredients;
		this.origin = origin;
		this.image = image;
	}
	
	
}
