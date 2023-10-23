package models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import interfaces.Purchasable;

public class Order {
	private List<Purchasable> items;
	private int id;
	
	public Order(int id) {
		this.id = id;
		items = new ArrayList<Purchasable>();
	}
	
	public int getId() {
		return id;
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
}
