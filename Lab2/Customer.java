
public class Customer {
	private String name;
	private String idNo;
	private double balance;
	private Item item;
	
	public Customer(String name, String idNo, double balance) {
		this.name = name;
		this.idNo = idNo;
		this.balance = balance;
	}

	public Customer(String name, String idNo) {
		this.name = name;
		this.idNo = idNo;
		this.balance = 5000;
	}
	
	public String Getname(){
		System.out.println("Name: "+name);
		return name;
	}
	public String GetidNo(){
		System.out.println("idNo: "+idNo);
		return idNo;
	}
	public double Getbalance(){
		System.out.println("balance: "+balance);
		return balance;
	}
	public Item Getitem(){
		System.out.println("item: "+item);
		return item;
	}
	
	public void Updatename(String name){
		this.name = name;
		System.out.println("New Name: "+name);
	}
	
	public void UpdateidNo(String idNo){
		this.idNo = idNo;
		System.out.println("New idNo: "+idNo);
	}
	
	public void print(){
		System.out.println("Name: "+name+" ID: "+idNo+" Balance: "+balance+" Item: "+item);
	}
	
	public void buyItem(Item item){
		
		System.out.println(item);
		System.out.println("Balance: "+balance);
		if(balance<item.GetitemPrice()*item.GetQuantity()){
			System.out.println("Insufficent Balance");
		}
		else if(item.GetQuantity()<1){
			System.out.println("Order is not valid");
		}
		else{
			this.item=item;
			balance-=item.GetitemPrice()*item.GetQuantity();
			System.out.println("Item Bought");
		}
	}
	
}
