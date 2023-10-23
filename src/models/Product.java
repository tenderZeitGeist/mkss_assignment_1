package models;

import enums.ItemType;

public class Product extends Purchasable {
	/**
	 * unit price of the product
	 */
	private int unitPrice;
	
	/**
	 * product's quantity
	 */
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
