package models;

import enums.ItemType;
import interfaces.Purchasable;

public class Product extends Purchasable {
	private int unitPrice;
	private int quantity;

	public Product(String name, int unitPrice, int quantity) {
		super(name, ItemType.product);
		this.unitPrice = unitPrice;
		this.quantity = quantity;
	}
	
	@Override
	public int getPrice() {
		return unitPrice * quantity;
	}

	@Override
	public String toString() {
		return quantity + " * " + name;
	}
}
