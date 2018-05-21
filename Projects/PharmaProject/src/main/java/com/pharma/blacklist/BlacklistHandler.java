package com.pharma.blacklist;

import com.pharma.api.BaseHandler;
import com.pharma.database.DatabaseImpl;

public class BlacklistHandler extends BaseHandler {

	String brand;
	String genName;
	boolean success = false;
	String message;
	
	@Override
	public void prepareRequest(String brand) throws Exception {
		this.brand = brand;
	}

	@Override
	public void validateRequest(String brand) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void processRequest(String brand) throws Exception {
		boolean success = false;
		success = DatabaseImpl.blacklist(this.brand);
		if(success)
			message = this.brand + "-Manufacturer-blacklisted-successfully";
		else
			message =  "Manufacturer-does-not-exist-in-database-to-blacklist";
	}

	@Override
	public String prepareResponse(String str) throws Exception {
		return message;
	}

}
