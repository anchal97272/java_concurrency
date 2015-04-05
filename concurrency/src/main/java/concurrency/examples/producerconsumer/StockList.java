/**
 * 
 */
package concurrency.examples.producerconsumer;

import java.util.ArrayList;
import java.util.List;


/**
 * Use wait(), notify() for producer-consumer
 * 
 * @author anchalagarwal
 *
 */
public class StockList {
	private final int capacity;
	private final List<Integer> myItemList;

	/**
	 * @param capacity
	 */
	public StockList(int capacity) {
		this.capacity = capacity;
		myItemList = new ArrayList<Integer>(capacity);
	}

	public Integer getStockItem() throws InterruptedException {
		Integer theItem = null;
		synchronized (this) {
			if (myItemList.isEmpty()) {
				System.out
						.println("Stock item list is empty, so waiting for item..");
				wait();
			}
			else
			{
				// System.out.println("Removed stock item.");
				theItem = myItemList.remove(0);
				notify();
			}
		}
		return theItem;
	}

	public void putStockItem(Integer parItem)
			throws InterruptedException {
		synchronized (this) {
			if (myItemList.size() > capacity) {
				System.out
						.println("Stock item list is full, so waiting for empty space..");
				wait();
			}
			else
			{
				// System.out.println("Adding stock item.");
				myItemList.add(parItem);
				notify();
			}
		}
		}
}
