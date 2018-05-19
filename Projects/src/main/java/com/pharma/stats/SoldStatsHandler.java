package com.pharma.stats;

import java.util.List;

import com.pharma.api.BaseHandler;
import com.pharma.database.DatabaseImpl;

public class SoldStatsHandler extends BaseHandler {

	int topNum;
	List<String> resultString;
	
	@Override
	public void prepareRequest(String topNum) throws Exception {
		//Nothing to do
	}

	@Override
	public void validateRequest(String topNum) throws Exception {
		try {
			this.topNum = Integer.parseInt(topNum);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			throw new Exception("Input received in call is invalid");
		}
	}

	@Override
	public void processRequest(String topNum) throws Exception {
		resultString = DatabaseImpl.getTopSoldMedicines(this.topNum);
	}

	@Override
	public String prepareResponse(String topNum) throws Exception {

		return resultString.toString();
	}

}
