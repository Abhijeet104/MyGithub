package com.pharma.database;

import java.util.HashMap;

public class Database {
	private static MedicinesTable medicineTable = null; 
	private static PurchaseHistoryTable purchaseHistoryTable = null; 
	private static BlacklistTable blacklistTable = null; 
	//Customer table
	//Admin table
	//Store 
	//
	private static Database instance = null;
	
	private Database() {
		medicineTable = new MedicinesTable();
		purchaseHistoryTable = new PurchaseHistoryTable();
		blacklistTable = new BlacklistTable();
	}
	
	
	public static Database getInstance() {
		if(instance == null) {
			 synchronized (Database.class)
		      {
				if(instance == null)
					instance = new Database();
		      }
			return instance;
		}else
			return instance;
		
	}
	
	public MedicinesTable getMedicineTable() {
		return medicineTable;
	}
	
	public PurchaseHistoryTable getPurchaseHistoryTable() {
		return purchaseHistoryTable;
	}
	
	protected BlacklistTable getBlackListedTable() {
		return blacklistTable;
	}
	
}
