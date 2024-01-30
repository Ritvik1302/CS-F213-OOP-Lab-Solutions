import java.io.*;

public class Exercise1 {
	
	public static void main(String args[])throws IOException{
		
		InputStreamReader isr = new InputStreamReader(System.in);
		
		BufferedReader br= new BufferedReader(isr) ;
		int sum =0;
		int num;
		for(int i=0;i<10;i++){
			System.out.println("Enter the "+(i+1)+"th Number");
			num = Integer.parseInt(br.readLine());
			sum+=num;
		}
		System.out.println("Sum is: " + sum);
	}
}
