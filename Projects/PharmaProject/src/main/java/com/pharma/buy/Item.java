package com.pharma.buy;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Item {
	@JsonProperty("_id")
	String _id;
	
	@JsonProperty("quantity")
	int quantity;
	
	@JsonProperty("cost")
	double cost;

	@JsonProperty("price")
	double price;
	
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
}
