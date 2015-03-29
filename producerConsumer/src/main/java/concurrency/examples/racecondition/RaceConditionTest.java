package concurrency.examples.racecondition;

public class RaceConditionTest {

	private class SharedResource
	{
		private int x;
		SharedResource(int x)
		{
			this.x = x;
		}
		public void incrementX() // Add synchronization to handle race condition
		{
			x= x + 1;
			System.out.println("x = " + x);
		}
	}
	private class T1 extends Thread {
		private SharedResource sharedResource;

		T1(SharedResource sharedResource) {
			this.sharedResource = sharedResource;
		}

		public void run() {
			System.out.println("inside thread T1");
			sharedResource.incrementX();
		}
	}

	private class T2 extends Thread {                   
		private SharedResource sharedResource;

		T2(SharedResource sharedResource) {
			this.sharedResource = sharedResource;
		}

		public void run() {
			System.out.println("inside thread T2");
			sharedResource.incrementX();
		}
	}

	public static void main(String[] args) {
		RaceConditionTest test = new RaceConditionTest();
		SharedResource sharedResource = test.new SharedResource(5);
		T1 t1 = test.new T1(sharedResource); // Expect X = 6
		T2 t2 = test.new T2(sharedResource); // Expect X = 7
		t1.start();
		t2.start();
	}
}
