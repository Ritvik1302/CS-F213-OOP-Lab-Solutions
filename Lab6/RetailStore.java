public class RetailStore {
	private int[] itemId = { 1001, 1002, 1003, 1004, 1005 };
	private double[] price = { 13.50, 18.00, 19.50, 25.50 };

	private double computePrice(int value) {
		for (int i = 0; i < price.length; ++i) {
			if (itemId[i] == value) {
				return price[i];
			}
		}
		System.out.println("Item Not Found In Array");
		return -1;
		// method which takes in the index and
		// returns the price of the item
		//return price[value];
	}

	public static void main(String[] args) {
		// main method. Execution begins here
		RetailStore retailOne = new RetailStore();
		System.out.println("price of item id 1002 is "
				+ retailOne.computePrice(1003));
		System.out.println("price of item id 1004 is "
				+ retailOne.computePrice(1004));
		
		 System.out.println("price of item id 1009 is "
		 +retailOne.computePrice(1007));
		
	}
}