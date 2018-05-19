package com.pharma.medicine;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SearchRequest {

	@JsonProperty("_id")
	private String _id;

	@JsonProperty("name")
	private String name;

	@JsonProperty("genericName")
	private String genericName;

	@JsonProperty("category")
	private String category;

	@JsonProperty("composition")
	private String composition;
	
	@JsonProperty("manufacturer")
	private String manufacturer;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGenericName() {
		return genericName;
	}

	public void setGenericName(String genericName) {
		this.genericName = genericName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getComposition() {
		return composition;
	}

	public void setComposition(String composition) {
		this.composition = composition;
	}
	
	
}
