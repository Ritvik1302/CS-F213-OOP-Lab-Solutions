import java.io.*;
import java.util.Scanner; 

public class Exercise2 {
	
	public static void main(String args[])throws IOException{
		
		Scanner in = new Scanner(System.in);
		int sum =0;
		int num;
		for(int i=0;i<10;i++){
			System.out.println("Enter the "+(i+1)+"th Number");
			num = in.nextInt();
			sum+=num;
		}
		System.out.println("Sum is: " + sum);
	}
}
