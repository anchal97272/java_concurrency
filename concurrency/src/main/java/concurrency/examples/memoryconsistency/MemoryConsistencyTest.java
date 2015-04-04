package concurrency.examples.memoryconsistency;

public class MemoryConsistencyTest {

	
	private static class Job implements Runnable
	{

		public void run() {
			for (int i=0 ; i < 10;i++)
				System.out.println("i " + i);
			
		}
		
	}
	public static void main(String[] args) throws InterruptedException {
		System.out.println("going to create new thread");
		Thread newThread = new Thread(new Job());
		System.out.println("going to start new thread");
		newThread.start();
		for (int j=0 ; j < 10;j++)
			System.out.println("j " + j);
		System.out.println("going to join new thread");
		newThread.join(); // applies happens-before relation
		System.out.println("new thread finished");

	}

}
