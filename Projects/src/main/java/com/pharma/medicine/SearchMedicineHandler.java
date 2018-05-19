package com.pharma.medicine;

import java.util.List;

import com.pharma.PharmaError;
import com.pharma.api.BaseHandler;
import com.pharma.database.DatabaseImpl;

public class SearchMedicineHandler extends BaseHandler {

	SearchRequest search;
	List<Medicine> resultList;
	@Override
	public void prepareRequest(String reqString) throws Exception {

		search = (SearchRequest) reqConvertToObj(reqString, SearchRequest.class);
	}

	@Override
	public void validateRequest(String reqString) throws Exception {

	}

	@Override
	public void processRequest(String reqString) throws Exception {
		
		DatabaseImpl db = new DatabaseImpl();
		if (search.get_id() != null && !search.get_id().isEmpty()) {
			resultList = db.searchMedicine(search.get_id());
		}else {
			resultList = db.searchMedicine(search.getName(), search.getGenericName(), search.getManufacturer(), search.getCategory(),
					search.getComposition());

		}
	}

	@Override
	public String prepareResponse(String str) throws Exception {
		if(resultList== null || resultList.size()==0) {
			PharmaError err = new PharmaError();
			err.set_id("ERROR");
			err.setErrorMessage("Stock not available for prescribed medicines");
			return objConvrtToString(err, PharmaError.class);
		}
		return objConvrtToString(resultList, Medicine.class);
	}

}
