package util;

/**
 * provides different formatter methods for the application
 */
public class Formatter {
	public static String formatPrice(int priceInCent) {
		float price = (float)priceInCent / 100f;
		return price + "EUR";
	}
}
