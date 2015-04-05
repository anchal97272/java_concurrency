/**
 * 
 */
package concurrency.examples.producerconsumer;

/**
 * @author anchalagarwal
 *
 */
public class Producer extends Thread {

	private StockList myStockList;
	private Stock myStock;
	private boolean stop;

	/**
	 * @param myStockList
	 */
	public Producer(StockList parStock) {
		this.myStockList = parStock;
	}

	/**
	 * @param myStock
	 */
	public Producer(Stock parStock) {
		this.myStock = parStock;
	}

	public void run() {
		int i = 0;
		while (!stop) {
			try {
				if (myStockList != null) {
					myStockList.putStockItem(i++);
				} else if (myStock != null) {
					myStock.putStockItem(i++);
				}
				System.out.println("Produced item " + i);
			} catch (InterruptedException e) {
				System.out.println("Production is interrupted");
				return;
			}
		}
	}

	/**
	 * @return the stop
	 */
	public boolean isStop() {
		return stop;
	}

	/**
	 * @param stop
	 *            the stop to set
	 */
	public void setStop(boolean stop) {
		this.stop = stop;
	}
}
