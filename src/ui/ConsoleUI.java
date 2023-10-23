package ui;

import enums.OrderAction;
import interfaces.IRenderable;
import models.Product;
import models.Purchasable;
import models.Service;
import models.Order;
import util.Formatter;
import util.Input;

public class ConsoleUI implements IRenderable {
	/**
	 * handles a new product and handles it
	 */
	@Override
	public Product orderProduct() {
		System.out.println("[Product] Name: ");
		String name = Input.readString();
		
		System.out.println("[Product] Unit price (in cents): ");
		int price = Input.readInt();
		
		System.out.println("[Product] Quantity: ");
		int quantity = Input.readInt();
		
		return new Product(name, price, quantity);
	}

	/**
	 * handles a new service and returns it
	 */
	@Override
	public Service orderService() {
		System.out.println("[Service] Type: ");
		String type = Input.readString();
		
		System.out.println("[Service] Number of persons: ");
		int persons = Input.readInt();
		
		System.out.println("[Service] Hours: ");
		int hours = Input.readInt();
		
		return new Service(type, persons, hours);	
	}

	/**
	 * provides menu with all interactions in the console
	 */
	@Override
	public void showMenu() {
		System.out.println("Your choice?");
		System.out.println("(0) Finish order");
		System.out.println("(1) Order product");
		System.out.println("(2) Order service");
	}

	/**
	 * displays the finished order, sums up all items with their prices, show sum at the end
	 */
	@Override
	public void showFinishedOrder(Order order) {
		for(Purchasable item : order.getItems()) {
			System.out.println(item.getName() + " = " + Formatter.formatPrice(item.getPrice()));
		}
		
		System.out.println("Sum: "+ Formatter.formatPrice(order.getSum()));
		System.out.println("Ordered: " + order.getFormattedCheckoutTimestamp());
	}

	/**
	 * displays the passed message as error
	 */
	@Override
	public void showErrorMessage(String message) {
		System.err.println(message);
	}

	/**
	 * handles the user input to identify the current action
	 */
	@Override
	public OrderAction fetchAction() {
		showMenu();
		int input = Input.readInt();
		switch(input) {
			case 0: 
				return OrderAction.finish;
			case 1:
				return OrderAction.newProduct;
			case 2:
				return OrderAction.newService;
			default:
				return OrderAction.unknown;
		}
	}
	
	@Override
	public boolean validateNewSession() {
		System.out.println("Möchtest du eine weitere Bestellung tätigen");
		return Input.readBoolean();
	}
	
	public void displayFarewell() {
		System.out.println("Vielen Dank für deinen Einkauf! Beehre uns bald wieder!");
	}
}