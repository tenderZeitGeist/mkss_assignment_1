package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalTime;

public class Order {
	private List<Purchasable> items;
	private LocalDate checkoutDate;
	private LocalTime checkoutTime;
	
	public Order() {
		items = new ArrayList<Purchasable>();
	}
	
	public List<Purchasable> getItems() {
		return items;
	}
	
	public void addItem(Purchasable item) {
		items.add(item);
	}
	
	public void sortItems() {
		Collections.sort(items);
	}
	
	public String getFormattedCheckoutTimestamp() {
		if(checkoutDate == null || checkoutTime == null) return "Kein Bestelldaum verfügbar";
		return "Ordered on " + checkoutDate + " at " + checkoutTime;
	}
	
	public void setCheckoutTimestamp(LocalDate date, LocalTime time) {
		checkoutDate = date;
		checkoutTime = time;
	}
	
	public int getSum() {
		int sum = 0;
		for(Purchasable item: items) {
			sum += item.getPrice();
		}
		
		return sum;
	}
}
