
public class PrivateStaticMethodExample {
	//public static varType myVar = initializeClassVariable();
	 public static int myVar = initializeClassVariable();
	 private static int initializeClassVariable() {
	 //initialization code goes here
		System.out.println("1");
		return 1;
	 }
	public static void main(String args[]){
		PrivateStaticMethodExample test1 = new PrivateStaticMethodExample();
	}
}
