package com.pharma.stats;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatResultClass {

	@JsonProperty("item")
	private String item;
	
	@JsonProperty("quantitySold")
	private String quantitySold;

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getQuantitySold() {
		return quantitySold;
	}

	public void setQuantitySold(String quantitySold) {
		this.quantitySold = quantitySold;
	}
	
}
