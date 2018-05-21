package com.pharma.database;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TreeMap;

public class PurchaseHistoryTable {
	private TreeMap<Integer, PurchaseRecord> table;
	private int seq = 1;

	protected PurchaseHistoryTable() {
		table = new TreeMap<Integer, PurchaseRecord>();
	}

	public void addRecord(PurchaseRecord record) {
		record.setSeq(seq);
		table.put(seq, record);
		seq++;
	}

	public List<PurchaseRecord> getRecordsByInvoice(String invoiceId) {
		List<PurchaseRecord> list = new ArrayList<PurchaseRecord>();

		return list;
	}

	public List<PurchaseRecord> getRecordsByCustomer(String customerId) {
		List<PurchaseRecord> list = new ArrayList<PurchaseRecord>();

		return list;
	}

	public List<PurchaseRecord> getRecordsByDate(String days) {
		List<PurchaseRecord> list = new ArrayList<PurchaseRecord>();

		return list;
	}

	public Collection<PurchaseRecord> getAllRecords() {

		return table.values();
	}
}
