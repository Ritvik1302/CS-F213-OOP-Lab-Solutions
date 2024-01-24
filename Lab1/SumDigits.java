
public class SumDigits {

	public static void main(String[] args) {
		int sum=0;
		String number = args[0];
		for(int i=0;i<number.length();i++){
			sum+=(int)number.charAt(i)-48;
		}
		System.out.println("Sum = "+sum);
	}

}
