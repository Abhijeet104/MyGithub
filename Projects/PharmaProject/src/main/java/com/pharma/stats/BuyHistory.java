package com.pharma.stats;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pharma.buy.Invoice;

public class BuyHistory {
	@JsonProperty("customer")
	private String customer;
	
	@JsonProperty("num")
	private int num;
	
	@JsonProperty("invoiceList")
	private List<Invoice> invoiceList;

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}

	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}
}
