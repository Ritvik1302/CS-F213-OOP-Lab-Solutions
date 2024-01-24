
public class HarmonicSum {
	
	public static void main(String[] args){
		double n = 50000;
		float sumL2R = 0.0f;
		float sumR2L = 0.0f;
		
		for(float i=1;i<n+1;i++){
			sumL2R+=1/i;
		}
		System.out.println("Sum From Left To Right ="+sumL2R);
		
		for(float i=50000;i>0;i--){
			sumR2L+=1/i;
		}
		System.out.println("Sum From Right To Left ="+sumR2L);
		System.out.println("Difference = "+(sumR2L-sumL2R));
	}
}
