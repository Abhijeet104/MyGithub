package com.pharma.medicine;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Medicine {

	@JsonProperty("name")
	private String name;
	
	@JsonProperty("_id")
	private String _id;
	
	@JsonProperty("price")
	private double price;
	
	@JsonProperty("manufacturer")
	private String manufacturer;
	
	@JsonProperty("category")
	private String category;
	
	@JsonProperty("genericName")
	private String genericName;
	
	@JsonProperty("quantity")
	private int quantity;
	
	//TODO: date
	@JsonProperty("expiryDate")
	private String expirtDate;
	
	@JsonProperty("composition")
	private String composition;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getExpirtDate() {
		return expirtDate;
	}

	public void setExpirtDate(String expirtDate) {
		this.expirtDate = expirtDate;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}


	
	
}
