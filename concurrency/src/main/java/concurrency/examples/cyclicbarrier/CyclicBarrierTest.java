package concurrency.examples.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

	private static class SumThread extends Thread {
		private CyclicBarrier barrier;
		private int limit;
		private int sum;

		public SumThread(CyclicBarrier barrier, int limit, String name) {
			super(name);
			this.barrier = barrier;
			this.limit = limit;
		}

		public void run() {
			for (int i = 1; i <= limit; i++) {
				sum += i;
			}

			if (barrier != null) {
				System.out.println(Thread.currentThread().getName() + " finished");
				try {
					barrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
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
		private CyclicBarrier barrier;
		private int limit;
		private int product = 1;
		public ProductThread(CyclicBarrier barrier, int limit, String name) {

			super(name);
			this.barrier = barrier;
			this.limit = limit;
		}

		public void run() {
			for (int i = 1; i <= limit; i++) {
				product *= i;
			}

			if (barrier != null) {
				System.out.println(Thread.currentThread().getName() + " finished");
				try {
					barrier.await();
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (BrokenBarrierException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * @return the product
		 */
		public int getProduct() {
			return product;
		}
	}

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		CyclicBarrier barrier = new CyclicBarrier(3, new Runnable(){
			public void run()
			{
				System.out.println("threads completed");
			}
		});
		SumThread sumThread = new SumThread(barrier, 100, "SumThread");
		ProductThread productThread = new ProductThread(barrier, 10,
				"ProductThread");
		sumThread.start();
		productThread.start();
		
		barrier.await();
		
		System.out.println("Sum of numbers :: " + sumThread.getSum());
		System.out.println("Product of numbers :: " + productThread.getProduct());

	}

	
}