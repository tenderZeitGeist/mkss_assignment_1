import models.Order;
import interfaces.IRenderable;
import ui.ConsoleUI;
import enums.OrderAction;
import java.time.LocalDate;
import java.time.LocalTime;

public class OrderService {
	/**
	 * the order that is processed in this service
	 */
	private Order order;
	
	/**
	 * the UI of the application, currently this is just a console application
	 * can be changed with some real GUI later
	 */
	private IRenderable renderView;
	
	public void startService() {
		while(true) {
			startSession();
			boolean result = validateNewSession();
			if(!result) {
				displayFarewell();
				return;
			}
		}
	}
	
	/**
	 * main loop to 
	 */
	private void startSession() {
		order = new Order();
		
		// creates the renderView to be able to display the logic
		renderView = new ConsoleUI();
		
		OrderAction action = OrderAction.unknown;
		do {
			action = renderView.fetchAction();
			validateAction(action);
		} while(action != OrderAction.finish);
	}
	
	/**
	 * validates the passed action and triggers the correct handling
	 * @param action that was entered by user / UI
	 */
	private void validateAction(OrderAction action) {
		switch(action) {
		case newProduct:
			orderProduct();
			break;
		case newService:
			orderService();
			break;
		case finish:
			finishOrder();
			break;
		default:
			displayInvalidInput();
			break;
		}
	}
	
	/**
	 * adds a new product to the order
	 */
	private void orderProduct() {
		order.addItem(renderView.orderProduct());
	}
	
	/**
	 * adds a new service to the order
	 */
	private void orderService() {	
		order.addItem(renderView.orderService());
	}
	
	/**
	 * displays an invalid input as an error
	 */
	private void displayInvalidInput() {
		renderView.showErrorMessage("invalid input");
	}
	
	private boolean validateNewSession() {
		return renderView.validateNewSession();
	}
	
	private void displayFarewell() {
		renderView.displayFarewell();
	}
	
	/**
	 * finishes the order, for now, the order with its items is just displayed
	 */
	private void finishOrder() {
		order.sortItems();
		order.setCheckoutTimestamp(LocalDate.now(), LocalTime.now());
		renderView.showFinishedOrder(order);
	}
}
