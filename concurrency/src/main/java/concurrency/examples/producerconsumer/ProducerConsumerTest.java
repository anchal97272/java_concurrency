/**
 * 
 */
package concurrency.examples.producerconsumer;

/**
 * @author anchalagarwal
 *
 */
public class ProducerConsumerTest {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		// CLassic approach
//		StockList theStockList = new StockList(10);
//		Producer theProducerThread = new Producer(theStockList);
//		Consumer theConsumerThread = new Consumer(theStockList);
		
		// Advance approach
		Stock theStock = new Stock(10);
		Producer theProducerThread = new Producer(theStock);
		Consumer theConsumerThread = new Consumer(theStock);

		theProducerThread.start();
		theConsumerThread.start();
		// sleep for 5 seconds
		Thread.sleep(5);
		
		theProducerThread.setStop(true);
		theConsumerThread.setStop(true);
	}

}
