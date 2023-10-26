package models;

import enums.ItemType;

public abstract class Purchasable implements Comparable<Purchasable> {
	/**
	 * the type of purchasable that is used
	 */
	protected ItemType type;
	
	/**
	 * name of the item
	 */
	protected String name;
	
	public Purchasable(String name, ItemType type) {
		this.name = name;
		this.type = type;
	}
	
	/**
	 * returns the name of the purchasable
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * returns the price of the purchasable. Has to be defined by implementing class.
	 * @return
	 */
	abstract public int getPrice();

	/**
	 * returns the type of the purchasable
	 * @return
	 */
	public ItemType getType() {
		return type;
	}
	
	/**
	 * compares two purchasable for sorting, implements the compareTo method 
	 * that is needed for the Comparable interface
	 */
	@Override
	public int compareTo(Purchasable o) {
		return getPrice() - o.getPrice();
	}
}
