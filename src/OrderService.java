import models.Product;
import models.Service;
import util.Input;
import java.util.ArrayList;
import java.util.Collections;

import interfaces.IPurchasable;
import java.util.List;

public class OrderService {
	private List<IPurchasable> items = new ArrayList<IPurchasable>();

	public void menuloop() {
		int input;
		do {
			printMenu();
			input = Input.readInt();
			switch (input) {
				case 0: break ;
				case 1: orderProduct(); break;
				case 2: orderService(); break;
				default: System.out.println("invalid"); break;
			}
		} while(input != 0);
		sortItems();
		finishOrder();
	}
	
	private void printMenu() {
		System.out.println("Your choice?");
		System.out.println("(0) Finish order");
		System.out.println("(1) Order product");
		System.out.println("(2) Order service");
	}
	
	private void sortItems() {	
		Collections.sort(items);
		
		// for (int i = 0; i< items.size()-1; i++) {
		//	for (int j = 0; j< items.size()-1; j++) {
		//		if ( items[j+1] != null && items[j+1].getPrice()< items[j].getPrice()) {
		//			Product temp = items[j + 1] ;
		//			items[j+1] = items[ j ] ;
		//			items[j] = temp ;
		//		}
		//	}
		// }
	}
	
	/*
	private void sortProducts() {
		for (int i = 0; i< products.length-1; i++) {
			for (int j = 0; j< products.length-1; j++) {
				if ( products[j+1] != null && products[j+1].getPrice()< products[j].getPrice()) {
					Product temp = products[j + 1] ;
					products[j+1] = products[ j ] ;
					products[j] = temp ;
				}
			}
		}
	}

	private void sortServices() {
		for (int i = 0; i< services.length-1; i++) {
			for (int j = 0; j< services.length-1; j++) {
				if ( services[j+1] != null && services[j+1].getPrice()< services[j].getPrice()) {
					Service temp = services[j + 1] ;
					services[j+1] = services[ j ] ;
					services[j] = temp ;
				}
			}
		}
	}
	*/
	
	private void orderProduct() {
		System.out.println("Name: ");
		String l = Input.readString();
		System.out.println("Unit price (in cents): ");
		int p = Input.readInt();
		System.out.println("Quantity: ");
		int s = Input.readInt();
		items.add(new Product(l,p,s));
	}
	
	private void orderService() {
		System.out.println("Service type: ");
		String l = Input.readString();
		System.out.println("Number of persons: ");
		int p = Input.readInt();
		System.out.println("Hours: ");
		int s = Input.readInt();
		items.add(new Service(l,p,s));
	}
	
	private void finishOrder() {
		int sum = 0;
		for(IPurchasable item : items) {
			System.out.println(item.getName() + " = " + formatPrice(item.getPrice()));
			sum += item.getPrice();
		}
		
		System.out.println("Sum: "+ formatPrice(sum));
	}

	private String formatPrice(int priceInCent) {
		return (priceInCent / 100) + "." + (priceInCent % 100 < 10 ? "0" : "")
			+ priceInCent % 100 + " EUR";
	}
}
