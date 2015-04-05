package concurrency.examples.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	private static class SumThread extends Thread {
		private CountDownLatch latch;
		private int limit;
		private int sum;

		public SumThread(CountDownLatch latch, int limit, String name) {
			super(name);
			this.latch = latch;
			this.limit = limit;
		}

		public void run() {
			for (int i = 1; i <= limit; i++) {
				sum += i;
			}

			if (latch != null) {
				System.out.println(Thread.currentThread().getName() + " finished");
				latch.countDown();
			}
		}

		/**
		 * @return the sum
		 */
		public int getSum() {
			return sum;
		}
	}

	private static class ProductThread extends Thread {
		private CountDownLatch latch;
		private int limit;
		private int product = 1;
		public ProductThread(CountDownLatch latch, int limit, String name) {

			super(name);
			this.latch = latch;
			this.limit = limit;
		}

		public void run() {
			for (int i = 1; i <= limit; i++) {
				product *= i;
			}

			if (latch != null) {
				System.out.println(Thread.currentThread().getName() + " finished");
				latch.countDown();
			}
		}

		/**
		 * @return the product
		 */
		public int getProduct() {
			return product;
		}
	}

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch latch = new CountDownLatch(2);
		Thread sumThread = new SumThread(latch, 100, "SumThread");
		Thread productThread = new ProductThread(latch, 10,
				"ProductThread");
		sumThread.start();
		productThread.start();
		System.out.println("Waiting for sum and product threads to finish");
		latch.await();
		System.out.println("latch current count " + latch.getCount());
		System.out.println("Sum of numbers :: " + ((SumThread)sumThread).getSum());
		System.out.println("Product of numbers :: " + ((ProductThread)productThread).getProduct());

	}

	
}