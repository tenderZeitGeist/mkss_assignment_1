package models;

import enums.ItemType;
import util.AppConstants;

public class Service extends Purchasable {
	private int hours, persons;

	public ItemType itemType = ItemType.service;
	
	public Service(String name, int persons, int hours) {
		super(name, ItemType.service);
		this.persons = persons;
		this.hours = hours;
	}

	@Override
	public int getPrice() {
		return AppConstants.minPrice * hours * persons;
	}

	@Override
	public String toString() {
		return persons + " persons for " + hours + "h of " + name;
	}
}
