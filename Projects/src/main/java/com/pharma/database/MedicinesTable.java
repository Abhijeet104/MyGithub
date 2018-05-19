package com.pharma.database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.pharma.medicine.Medicine;

class MedicinesTable {

	 private int size = 128;
	 private int count = 0;
	 private List columns = new ArrayList<String>(9);
	 private int noOfAttributes = 9; //columns.size(); 
	 //private String[][] table; 
	 private HashMap<String, Medicine> table;
	 protected MedicinesTable() {
		 //table = new String[size][noOfAttributes];
		 table = new HashMap<String,Medicine>(size);
	 }
	 
	 public Collection<Medicine> getAllRecord() {
		 return table.values();
	 }
/*	 protected void addRecord(Medicine bean) {
		 table[count][0] = bean.get_id();
		 table[count][1] = bean.getName();
		 table[count][2] = bean.getCategory();
		 table[count][3] = bean.getManufacturer();
		 table[count][4] = bean.getComposition();
		 table[count][5] = bean.getPrice();
		 table[count][6] = bean.getExpirtDate();
		 table[count][7] = bean.getQuantity();
		 count++;
		 
	 }
	*/
	 protected Medicine getRecord(String _id) {
		 return table.get(_id);
	 }
	 
	 protected void addRecord(Medicine bean) throws Exception {
		 if(table.containsKey(bean.get_id()))			 
			 //Note: in such case it can be updated too
			 throw new Exception(bean.get_id() + " Record already exists in database");

		 table.put(bean.get_id(),bean);
	 }	 
	 
	 protected void updateRecord(Medicine bean) throws Exception {
		 if(!table.containsKey(bean.get_id()))
				 throw new Exception(bean.get_id() + " Record does not exist to update");
		 Medicine medicine = table.get(bean.get_id());
		 medicine.setQuantity(medicine.getQuantity() + bean.getQuantity());
		 //TODO: Handle Expiry 
		 
		 table.put(bean.get_id(),medicine);
	 } 
	 
	 protected void deleteRecord(Medicine bean) throws Exception {
		 if(!table.containsKey(bean.get_id()))
			 throw new Exception(bean.get_id() + " Record does not exist to delete");
			 table.remove(bean.get_id());
	 }
	 
}
