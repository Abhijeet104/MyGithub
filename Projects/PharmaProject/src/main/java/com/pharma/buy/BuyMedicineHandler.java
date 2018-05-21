package com.pharma.buy;

import java.util.Date;

import com.pharma.PharmaError;
import com.pharma.api.BaseHandler;
import com.pharma.database.DatabaseImpl;

public class BuyMedicineHandler extends BaseHandler{

	Order order;
	Invoice invoice;
	
	@Override
	public void prepareRequest(String reqString) throws Exception {

		order = (Order) reqConvertToObj(reqString, Order.class);

	}

	@Override
	public void validateRequest(String reqString) throws Exception {

		for (Item item : order.getItems()) {
			if (item.get_id().isEmpty())
				throw new Exception("Id empty");
		}
	}

	@Override
	public void processRequest(String reqString) throws Exception {
		invoice = DatabaseImpl.buy(order);
	}

	@Override
	public String prepareResponse(String str) {
		if(invoice.getTotalCost() == 0) {
			PharmaError err = new PharmaError();
			err.set_id("ERROR");
			err.setErrorMessage("Stock not available for any of the prescribed medicines");
			return objConvrtToString(err, PharmaError.class);
		}
		else
			return objConvrtToString(invoice, Invoice.class);
	}

}
