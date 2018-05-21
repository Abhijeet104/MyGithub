package com.pharma;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PharmaError {

	@JsonProperty("_id")
	String _id;
	
	@JsonProperty("errorMessage")
	String errorMessage;
	
	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	
	
}
