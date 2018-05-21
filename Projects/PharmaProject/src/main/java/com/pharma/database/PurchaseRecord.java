package com.pharma.database;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PurchaseRecord {
	
	//PurchaseRecord n Invoce tables can be seperated
	
	
	@JsonProperty("seq")
	private int seq;
	
	@JsonProperty("customer")
	private String customer;
	
	@JsonProperty("itemId")
	private String itemId;
	
	@JsonProperty("quantity")
	private int quantity;
	
	@JsonProperty("invoiceId")
	private String invoiceId;
	
	@JsonProperty("date")
	private String date;
	
	@JsonProperty("price")
	private double price;
	
	@JsonProperty("tax")
	private double tax;

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}
	
	
	
}
