package com.pharma.api;

public interface HandlerInterface {
	void prepareRequest(String reqString) throws Exception;
	
	void validateRequest(String reqString) throws Exception;

	void processRequest(String reqString) throws Exception;
	
	String prepareResponse(String str) throws Exception;
	
	String prepareErrorResponse(String msg) throws Exception;
}
