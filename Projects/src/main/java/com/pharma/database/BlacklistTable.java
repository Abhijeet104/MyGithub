package com.pharma.database;

import java.util.HashMap;

public class BlacklistTable {
	HashMap<String,String> blacklistTable;
	protected BlacklistTable(){
		blacklistTable = new HashMap<String,String>(128);
	}
	
}
