package com.dresses.example.first.model;

public class DressProduct {
	
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
