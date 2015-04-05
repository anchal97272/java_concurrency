/**
 * 
 */
package concurrency.examples.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Use blocking queue for producer-consumer
 * 
 * @author anchalagarwal
 *
 */
public class Stock {

	private final BlockingQueue<Integer> myItemList;

	/**
	 * @param capacity
	 */
	public Stock(int capacity) {
		myItemList = new LinkedBlockingQueue<Integer>(capacity);
	}

	public Integer getStockItem() throws InterruptedException {
		// System.out.println("Removed stock item.");
		return myItemList.take();
	}

	public void putStockItem(Integer parItem) throws InterruptedException {

		// System.out.println("Adding stock item.");
		myItemList.put(parItem);
	}
}
