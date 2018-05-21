package com.pharma.database;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.pharma.buy.Invoice;
import com.pharma.buy.Item;
import com.pharma.buy.Order;
import com.pharma.medicine.Medicine;
import com.pharma.stats.BuySearchReq;

public class DatabaseImpl {

	private static int invoiceSeq = 1;

	public synchronized static int getInvoiceSeq() {
		invoiceSeq++;
		return invoiceSeq;
	}

	public static void addMedicineRecords(List<Medicine> beanList) throws Exception {
		Database db = Database.getInstance();
		for (Medicine bean : beanList)
			db.getMedicineTable().addRecord(bean);
	}

	public static void updateMedicineRecords(List<Medicine> beanList) throws Exception {
		Database db = Database.getInstance();
		for (Medicine bean : beanList)
			db.getMedicineTable().updateRecord(bean);
	}

	public static Invoice buy(Order order) throws Exception {
		Database db = Database.getInstance();
		Invoice invoice = new Invoice();
		invoice.set_id("INVOICE" + getInvoiceSeq());
		for (Item item : order.getItems()) {
			Medicine medicine = db.getMedicineTable().getRecord(item.get_id());
			double price = 0;
			if (medicine == null || isBlacklisted(medicine.getGenericName().toLowerCase())
					|| isBlacklisted(medicine.getManufacturer().toLowerCase())) {
				System.out.println("Medicine stock not available");
				continue;
			}
			// if stock exists then add actual price else 0
			price = medicine.getPrice();
			item.setPrice(price);
			if (medicine.getQuantity() >= item.getQuantity()) {
				medicine.setQuantity(medicine.getQuantity() - item.getQuantity());
				item.setCost(price * item.getQuantity());
				PurchaseRecord record = populateRecord(order, item, invoice.get_id());
				db.getPurchaseHistoryTable().addRecord(record);

			} else if (medicine.getQuantity() > 0) {
				item.setCost(price * medicine.getQuantity());
				item.setQuantity(medicine.getQuantity());
				PurchaseRecord record = populateRecord(order, item, invoice.get_id());
				db.getPurchaseHistoryTable().addRecord(record);
				medicine.setQuantity(0);
			}
			order.setTotalCost(order.getTotalCost() + item.getCost());
		}

		invoice.setTotalCost(order.getTotalCost());
		invoice.setCustomer(order.getCustomer());
		invoice.setDate(new Date().toString());
		invoice.setItemList(order.getItems());

		return invoice;
	}

	private static PurchaseRecord populateRecord(Order order, Item item, String invoiceId) {
		PurchaseRecord record = new PurchaseRecord();
		record.setCustomer(order.getCustomer());
		record.setDate(new Date().toString());
		record.setItemId(item.get_id());
		record.setPrice(item.getPrice());
		record.setQuantity(item.getQuantity());
		record.setInvoiceId(invoiceId);
		return record;

	}

	// Given ID it should return only one record, but Returning list just to use
	// overriding
	public static List<Medicine> searchMedicine(String id) {
		List<Medicine> list = new ArrayList<Medicine>();
		Database db = Database.getInstance();
		Medicine medicine = db.getMedicineTable().getRecord(id);
		list.add(medicine);

		return list;
	}

	public static List<Medicine> searchMedicine(String name, String genName, String brand, String category,
			String composition) {
		List<Medicine> list = new ArrayList<Medicine>();
		Database db = Database.getInstance();
		for (Medicine medicine : db.getMedicineTable().getAllRecord()) {

			if (category != null && !category.isEmpty() && !category.equalsIgnoreCase(medicine.getCategory())) {
				continue;
			}

			if ((isBlacklisted(medicine.getGenericName())) || (isBlacklisted(medicine.getManufacturer()))) {
				System.out.println("Medicine stock not available");
				continue;
			}
			
			if ((genName != null && isBlacklisted(genName)) || (brand != null && isBlacklisted(brand))) {
				System.out.println("Medicine stock not available");
				continue;
			}

			if (brand != null && !isPartialMatch(brand.toLowerCase(), medicine.getManufacturer().toLowerCase())) {
				continue;
			}

			if (name != null && isPartialMatch(name.toLowerCase(), medicine.getName().toLowerCase())) {
				list.add(medicine);
				continue;
			}

			if (isPartialMatch(genName.toLowerCase(), medicine.getGenericName().toLowerCase())) {
				list.add(medicine);
				continue;
			}

			if (composition != null
					&& isPartialMatch(composition.toLowerCase(), medicine.getComposition().toLowerCase())) {
				list.add(medicine);
				continue;
			}

		}

		return list;
	}

	private static boolean isBlacklisted(String brand) {
		Database db = Database.getInstance();
		return db.getBlackListedTable().blacklistTable.containsKey(brand.toLowerCase());
	}

	public static List<String> getTopSoldMedicines(int num) {
		Database db = Database.getInstance();
		Collection<PurchaseRecord> history = db.getPurchaseHistoryTable().getAllRecords();
		HashMap<String, Integer> countMap = new HashMap<String, Integer>();
		for (PurchaseRecord record : history) {
			if (!countMap.containsKey(record.getItemId())) {
				countMap.put(record.getItemId(), record.getQuantity());
			} else {
				countMap.put(record.getItemId(), countMap.get(record.getItemId()) + record.getQuantity());
			}
		}

		String[][] array = new String[countMap.size()][2];
		int i = 0;
		for (String str : countMap.keySet()) {
			array[i][0] = str;
			array[i][1] = String.valueOf(countMap.get(str));
			i++;
		}

		MyComparator2 comparator = new MyComparator2();
		Arrays.sort(array, comparator);
		if (num > array.length)
			num = array.length;
		List<String> resultList = new ArrayList<String>(num);
		for (int j = 0; j < num; j++)
			resultList.add(array[j][0] + " : " + array[j][1] + "\n");

		return resultList;

	}

	public static List<Invoice> getCustomerBuyingHistory(BuySearchReq req) {
		Database db = Database.getInstance();
		Collection<PurchaseRecord> history = db.getPurchaseHistoryTable().getAllRecords();
		List<Invoice> invoiceList = new ArrayList<Invoice>();
		if ((req.getCustomer() == null || req.getCustomer().isEmpty())
				&& (req.getInvoiceId() != null || !req.getInvoiceId().isEmpty())) {
			// Get only invoice details
			Invoice invoice = new Invoice();
			List<Item> itemList = new ArrayList<Item>();
			double totalCost = 0;
			for (PurchaseRecord record : history) {
				if (record.getInvoiceId().equalsIgnoreCase(req.getInvoiceId())) {
					Item item = new Item();
					item.set_id(record.getItemId());
					item.setCost(record.getPrice() * record.getQuantity());
					totalCost += item.getCost();
					item.setPrice(record.getPrice());
					item.setQuantity(record.getQuantity());
					itemList.add(item);
					invoice.setCustomer(record.getCustomer());
					invoice.setDate(record.getDate());
					invoice.set_id(record.getInvoiceId());
				}
			}
			invoice.setItemList(itemList);
			invoice.setTotalCost(totalCost);
			invoiceList.add(invoice);
		} else if(req.getCustomer() != null || !req.getCustomer().isEmpty()){
			
			//allInvoices
			List<String> invoices = new ArrayList<String>();
			for (PurchaseRecord record : history) {
				if(record.getCustomer().equalsIgnoreCase(req.getCustomer())) {
					invoices.add(record.getInvoiceId());
				}
			}
			
			for(String invoiceId: invoices) {
				double totalCost = 0;
				List<Item> itemList = new ArrayList<Item>();
				Invoice invoice = new Invoice();
				for (PurchaseRecord record : history) {
					if (record.getInvoiceId().equalsIgnoreCase(invoiceId)) {
						Item item = new Item();
						item.set_id(record.getItemId());
						item.setCost(record.getPrice() * record.getQuantity());
						totalCost += item.getCost();
						item.setPrice(record.getPrice());
						item.setQuantity(record.getQuantity());
						itemList.add(item);
						invoice.setCustomer(record.getCustomer());
						invoice.setDate(record.getDate());
						invoice.set_id(record.getInvoiceId());
					}
				}
				invoice.setItemList(itemList);
				invoice.setTotalCost(totalCost);
				invoiceList.add(invoice);
			}
			
			//
			
			
		}

		return invoiceList;

	}

	public static boolean blacklist(String brand) {
		Database db = Database.getInstance();
		try {
			BlacklistTable map = db.getBlackListedTable();
			map.blacklistTable.put(brand.toLowerCase(), new Date().toString());
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	private static boolean isPartialMatch(String searchString, String medicineString) {
		searchString.replaceAll(",", " ");
		String[] stringParts = searchString.split(" ");
		for (String str : stringParts) {
			if (medicineString.contains(str)) {
				return true;
			}
		}

		return false;
	}

}

// List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,
// Integer>>();
// Set<Map.Entry<String, Integer>> entrySet = countMap.entrySet();
// list.addAll(entrySet);
// MyComparator comparator = new MyComparator();
// list.sort(comparator);
// list.subList(0, num);