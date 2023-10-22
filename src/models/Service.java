package models;

import enums.ItemType;
import interfaces.IPurchasable;

public class Service implements IPurchasable, Comparable<IPurchasable> {
	private String name;
	private int hours, persons;
	
	private final int basePrice = 1242;

	public ItemType itemType = ItemType.service;
	
	public Service(String name, int persons, int hours) {
		this.name = name;
		this.persons = persons;
		this.hours = hours;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return basePrice * hours * persons;
	}

	@Override
	public String toString() {
		return persons + " persons for " + hours + "h of " + name;
	}
	
	@Override
	public int compareTo(IPurchasable item) {
		return item.getPrice() - getPrice();
	}
}
