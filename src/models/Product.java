package models;

import enums.ItemType;
import interfaces.IPurchasable;

public class Product implements IPurchasable {
	private String name;
	private int unitPrice;
	private int quantity;
	public ItemType itemType = ItemType.product;

	public Product(String name, int unitPrice, int quantity) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return unitPrice * quantity;
	}

	@Override
	public String toString() {
		return quantity + " * " + name;
	}
	
	@Override
	public int compareTo(IPurchasable item) {
		return item.getPrice() - getPrice();
	}
}
