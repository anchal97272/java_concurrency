/**
 * 
 */
package concurrency.examples.producerconsumer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author anchalagarwal
 *
 */
public class Stock {
	private List<StockItem> myItemList = new ArrayList<StockItem>(0);
	

	public StockItem getStockItem() throws InterruptedException {
		StockItem theStockItem = null;
		synchronized (this) {
			while (myItemList.isEmpty()) {
				System.out
						.println("Stock item list is empty, so waiting for item..");
				wait();
			}
			theStockItem = myItemList.remove(0);
			// System.out.println("Removed stock item.");
			notify();
		}
		return theStockItem;
	}

	public void putStockItem(StockItem parStockItem)
			throws InterruptedException {
		synchronized (this) {
			while (myItemList.size() > 1) {
				System.out
						.println("Stock item list is full, so waiting for empty space..");
				wait();
			}
			// System.out.println("Adding stock item.");
			myItemList.add(parStockItem);
			notify();
		}
	}
}
