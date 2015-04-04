/**
 * 
 */
package concurrency.examples.producerconsumer;

/**
 * @author anchalagarwal
 *
 */
public class ProducerJob implements Runnable {

	private Stock myStock;
	
	/**
	 * @param myStock
	 */
	public ProducerJob(Stock parStock) {
		this.myStock = parStock;
	}


	public void run() {
		String theItemName = "Item";
		for (int i = 0; i < 10 ; i++)
		{
			try {
				StockItem theStockItem = new StockItem(theItemName + i);
				System.out.println("Producing item " + theStockItem);
				myStock.putStockItem(theStockItem);
			} catch (InterruptedException e) {
				System.out.println("Production is interrupted");
				break;
			}
		}
		
	}

}
