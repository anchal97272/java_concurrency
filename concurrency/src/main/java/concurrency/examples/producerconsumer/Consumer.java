/**
 * 
 */
package concurrency.examples.producerconsumer;

/**
 * @author anchalagarwal
 *
 */
public class Consumer extends Thread {

	private Stock myStock;
	private StockList myStockList;
	private boolean stop;

	/**
	 * @param myStockList
	 */
	public Consumer(StockList parStock) {
		this.myStockList = parStock;
	}

	/**
	 * @param myStock
	 */
	public Consumer(Stock parStock) {
		this.myStock = parStock;
	}

	public void run() {
		while (!stop) {
			try {
				if (myStockList != null) {
					System.out.println(" Consuming product "
							+ myStockList.getStockItem());
				} else if (myStock != null) {
					System.out.println(" Consuming product "
							+ myStock.getStockItem());
				}

			} catch (InterruptedException e) {
				System.out.println("Consumption is interrupted");
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
