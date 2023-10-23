import models.Order;
import models.Product;
import models.Service;
import util.Input;
import java.util.ArrayList;
import interfaces.Purchasable;
import java.util.List;

public class OrderService {
	private Order order;
	private List<Order> orders = new ArrayList<Order>();
	
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
		order.sortItems();
	}
	
	private void orderProduct() {
		System.out.println("Name: ");
		String l = Input.readString();
		System.out.println("Unit price (in cents): ");
		int p = Input.readInt();
		System.out.println("Quantity: ");
		int s = Input.readInt();
		order.addItem(new Product(l,p,s));
	}
	
	private void orderService() {
		System.out.println("Service type: ");
		String l = Input.readString();
		System.out.println("Number of persons: ");
		int p = Input.readInt();
		System.out.println("Hours: ");
		int s = Input.readInt();
		order.addItem(new Service(l,p,s));
	}
	
	private void finishOrder() {
		int sum = 0;
		for(Purchasable item : order.getItems()) {
			System.out.println(item.getName() + " = " + formatPrice(item.getPrice()));
			sum += item.getPrice();
		}
		
		System.out.println("Sum: "+ formatPrice(sum));
	}

	private String formatPrice(int priceInCent) {
		float price = (float)priceInCent / 100f;
		return price + "EUR";
	}
}
