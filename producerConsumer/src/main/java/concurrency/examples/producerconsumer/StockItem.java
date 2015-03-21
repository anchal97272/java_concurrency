package concurrency.examples.producerconsumer;

public class StockItem {
	
	private String name;

	/**
	 * @param name
	 */
	public StockItem(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "StockItem [name=" + name + "]";
	}

	

}
