package com.pharma.database;

import java.util.Comparator;

class MyComparator2 implements Comparator<String[]>{

	@Override
	public int compare(String[] o1, String[] o2) {
		
		return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
	}
}
