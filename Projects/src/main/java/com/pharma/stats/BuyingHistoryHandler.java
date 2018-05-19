package com.pharma.stats;

import com.pharma.PharmaError;
import com.pharma.api.BaseHandler;
import com.pharma.database.DatabaseImpl;

public class BuyingHistoryHandler extends BaseHandler {
	BuySearchReq searchReq = null;
	BuyHistory result = null;

	@Override
	public void prepareRequest(String reqString) throws Exception {
		searchReq = (BuySearchReq) reqConvertToObj(reqString, BuySearchReq.class);
	}

	@Override
	public void validateRequest(String reqString) throws Exception {
		// TODO validate fields

	}

	@Override
	public void processRequest(String reqString) throws Exception {
		result = new BuyHistory();
		result.setInvoiceList(DatabaseImpl.getCustomerBuyingHistory(searchReq));
		result.setCustomer(result.getInvoiceList().get(0).getCustomer());
	}

	@Override
	public String prepareResponse(String str) throws Exception {
		if (result == null || result.getInvoiceList().size() == 0) {
			PharmaError err = new PharmaError();
			err.set_id("ERROR");
			err.setErrorMessage("No invoices found for given customer/invoiceId");
			return objConvrtToString(err, PharmaError.class);

		}
		return objConvrtToString(result, BuyHistory.class);
	}

}
