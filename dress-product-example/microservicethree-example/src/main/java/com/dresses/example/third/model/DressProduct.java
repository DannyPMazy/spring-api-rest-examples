package com.dresses.example.third.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DressProduct {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idProduct;
	
	private String name;
	private String texture;
	private double price;
	
	public DressProduct() {
		
	}

	public DressProduct(String name, String texture, double price) {
		this.name = name;
		this.texture = texture;
		this.price = price;
	}

	public long getIdProduct() {
		return idProduct;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
