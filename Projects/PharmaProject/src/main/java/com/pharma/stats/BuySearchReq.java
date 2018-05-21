package com.pharma.stats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BuySearchReq {
	@JsonProperty("customer")
	private String customer;
	
	@JsonProperty("num")
	private int num;
	
	@JsonProperty("invoiceId")
	private String invoiceId;

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

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
}
