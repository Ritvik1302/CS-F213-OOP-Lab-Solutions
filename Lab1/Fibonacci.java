public class Fibonacci {
	public static void main(String[] args) {
		int sum = 0;
		float av =0;
		int prev=1,curr = 1;
		for(int i=0; i<18; i++){
		sum = prev+curr;
		av+=sum;
		prev=curr;
		curr=sum;
		System.out.println(" " + sum);
			}
		av=av/20;
		System.out.println(" Average = "+av);
		}
}
