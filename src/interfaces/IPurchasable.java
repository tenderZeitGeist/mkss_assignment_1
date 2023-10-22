package interfaces;

import enums.ItemType;

public interface IPurchasable implements Comparable<IPurchasable> {
	public ItemType itemType = ItemType.unknown;
	String getName();
	int getPrice();
}
