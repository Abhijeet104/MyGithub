package com.pharma.api;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pharma.PharmaError;

public abstract class  BaseHandler<T> implements HandlerInterface {

	String id ;
	String handleRequest(String reqString) throws Exception {
		
		try {
			
			prepareRequest(reqString);
			
			validateRequest(reqString);

			processRequest(reqString);
			
			return prepareResponse(reqString);
			
		} catch (Exception e) {
			
			return prepareErrorResponse(e.getMessage());

		}
	}
	
	public String prepareErrorResponse(String errorMsg) {
		PharmaError err = new PharmaError();
		err.set_id(id);
		err.setErrorMessage(errorMsg);
		return objConvrtToString(err, PharmaError.class);
	}
	
	protected List<T> reqConvertToObjList(String reqString, Class classType) throws Exception {
		
		ObjectMapper mapper = new ObjectMapper();
		List myObjects = null;
		try {

			myObjects = mapper.readValue(reqString, mapper.getTypeFactory().constructCollectionType(List.class, classType));
		
			return myObjects;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception("Error while parsing input body");
		}
		
	}
	
	protected Object reqConvertToObj(String reqString, Class classType) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			 mapper = new ObjectMapper();
			return mapper.readValue(reqString, classType);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	protected String objConvrtToString(Object obj, Class classType) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			return mapper.writeValueAsString( obj);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
		
}
