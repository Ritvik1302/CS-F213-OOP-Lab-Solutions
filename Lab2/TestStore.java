
public class TestStore {
	
	public static void main(String[] args)
	{
		Customer c = new Customer("Ritvik", "2545", 50000);
	
		Item i1 = new Item("Comb","123",1,5000.0);
		Item i2 = new Item("Brush","124",1,5000.0);
		
		c.buyItem(i1);
		c.buyItem(i2);
	}
}
