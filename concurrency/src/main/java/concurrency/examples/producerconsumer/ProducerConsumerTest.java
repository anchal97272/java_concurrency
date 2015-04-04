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
	 */
	public static void main(String[] args) {
		Stock theStock = new Stock();
		Thread theProducerThread = new Thread(new ProducerJob(theStock));
		Thread theConsumerThread = new Thread(new ConsumerJob(theStock));
		
		theProducerThread.start();
		theConsumerThread.start();

	}

}
