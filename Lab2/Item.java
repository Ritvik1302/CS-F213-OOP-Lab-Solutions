
public class Item {
	private String itemName;
	private String itemidNo;
	private int itemQuantity;
	private double itemPrice;
	
	public Item(String itemName, String itemidNo, Integer itemQuantity, Double itemPrice){
		this.itemName=itemName;
		this.itemidNo=itemidNo;
		this.itemQuantity=itemQuantity;
		this.itemPrice=itemPrice;
	}
	public Item(String itemName, String itemidNo, Integer itemQuantity){
		this.itemName=itemName;
		this.itemidNo=itemidNo;
		this.itemQuantity=itemQuantity;
		this.itemPrice=500;
	}
	public Item(String itemName, String itemidNo){
		this.itemName=itemName;
		this.itemidNo=itemidNo;
		this.itemQuantity=1;
		this.itemPrice=500;
	}
	public String GetName(){
		System.out.println("Name: "+this.itemName);
		return itemName;
	}
	public void UpdateName(String name){
		this.itemName=name;
		System.out.println("New Name: "+this.itemName);
	}
	
	public String GetidNo(){
		System.out.println("idNo: "+this.itemidNo);
		return itemidNo;
	}
	public void UpdateidNo(String idNo){
		this.itemidNo=idNo;
		System.out.println("New idNo: "+this.itemidNo);
	}
	
	public int GetQuantity(){
		System.out.println("Quantity: "+this.itemQuantity);
		return itemQuantity;
	}
	public void UpdateitemQuantity(int name){
		this.itemQuantity=name;
		System.out.println("New itemQuantity: "+this.itemQuantity);
	}
	
	public double GetitemPrice(){
		System.out.println("itemPrice: "+this.itemPrice);
		return itemPrice;
	}
	public void UpdateitemPrice(double itemPrice){
		this.itemPrice=itemPrice;
		System.out.println("New itemPrice: "+this.itemPrice);
	}
	
	public String toString() {
		return ("Name: "+itemName+" ID: "+itemidNo+" Price: "+itemPrice+" Quantity: "+itemQuantity);
	}
	
}
