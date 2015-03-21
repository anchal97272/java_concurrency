/**
 * 
 */
package concurrency.examples.producerconsumer;

/**
 * @author anchalagarwal
 *
 */
public class ConsumerJob implements Runnable {

private Stock myStock;
	
	/**
	 * @param myStock
	 */
	public ConsumerJob(Stock parStock) {
		this.myStock = parStock;
	}


	public void run() {
		for (int i = 0; i < 10 ; i++)
		{
			try {
				System.out.println("Consuming product " + myStock.getStockItem());
			} catch (InterruptedException e) {
				System.out.println("Consumption is interrupted");
				break;
			}
		}
		
	}

}
