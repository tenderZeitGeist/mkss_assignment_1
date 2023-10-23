package interfaces;

import enums.ItemType;

public abstract class Purchasable implements Comparable<Purchasable> {
	protected ItemType type;
	protected String name;
	
	public Purchasable(String name, ItemType type) {
		this.name = name;
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return 0;
	}
	
	public ItemType getType() {
		return type;
	}
	
	@Override
	public int compareTo(Purchasable o) {
		return getPrice() - o.getPrice();
	}
}
