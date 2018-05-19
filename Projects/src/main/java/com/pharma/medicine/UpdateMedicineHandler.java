package com.pharma.medicine;

import java.util.List;

import com.pharma.api.BaseHandler;
import com.pharma.database.DatabaseImpl;

public class UpdateMedicineHandler extends BaseHandler {

	List<Medicine> beanList = null;

	@Override
	public void prepareRequest(String reqString) throws Exception {

		beanList = (List<Medicine>) reqConvertToObjList(reqString, Medicine.class);

	}

	@Override
	public void validateRequest(String reqString) throws Exception {

		for (Medicine bean : beanList) {
			if (bean.get_id() == null || bean.get_id().isEmpty())
				throw new Exception("Id can not be empty");

			if (bean.getCategory() == null || bean.getCategory().isEmpty())
				throw new Exception("category can not be empty");

			if (bean.getPrice() < 0)
				throw new Exception("Price can not be negative");

			if (bean.getGenericName() == null || bean.getGenericName().isEmpty())
				throw new Exception("Generic Name can not be empty");

			if (bean.getQuantity() < 1)
				throw new Exception("Quantity can not be negative or zero");

			// TODO: if expiry date less than current date throw exception
			if (bean.getExpirtDate() == null || bean.getExpirtDate().isEmpty())
				throw new Exception("Expiry date can not be empty");

		}
	}

	@Override
	public void processRequest(String reqString) throws Exception {
		DatabaseImpl.updateMedicineRecords(beanList);

	}

	@Override
	public String prepareResponse(String str) {
		return objConvrtToString(beanList, Medicine.class);
	}

}
