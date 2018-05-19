package com.pharma.buy;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Invoice {
	
	//TODO: shop name, address
	@JsonProperty("_id")
	String _id;
	
	@JsonProperty("customer")
	String customer;
	
	@JsonProperty("date")
	String date;
	
	@JsonProperty("itemList")
	List<Item> itemList;
	
	@JsonProperty("totalCost")
	double totalCost;
	

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}
	
	public List<Item> getItemList() {
		return itemList;
	}

	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
}
