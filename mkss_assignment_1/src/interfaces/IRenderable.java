package interfaces;

import models.Order;
import models.Product;
import models.Service;
import enums.OrderAction;

public interface IRenderable {
	/**
	 * user tries to create a new product
	 * @return
	 */
	Product orderProduct();
	
	/**
	 * user tries to create a new service
	 * @return
	 */
	Service orderService();
	
	/**
	 * user should be see the action menu
	 */
	void showMenu();
	
	/**
	 * user finished order and should see a summary
	 * @param order
	 */
	void showFinishedOrder(Order order);
	
	/**
	 * user entered something wrong and should see an error
	 * @param message
	 */
	void showErrorMessage(String message);
	
	/**
	 * user should enter an input to trigger an action
	 * @return
	 */
	OrderAction fetchAction();
	
	boolean validateNewSession();
	
	void displayFarewell();
}
