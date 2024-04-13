import java.io.*;
import java.util.Scanner;

public class Data {
	// store the result of coin toss 
	private int result;
	// set if it is player's chance
	private boolean pChance;
	// set if it is monitor's chance
	private boolean mChance;
	// number of players
	private int nop;
	private Object lock;

	public Data() {

	//Fig.1 (input.txt)
	//
	//-1    // initial value of result 
	//true  // player chance flag
	//false // monitor chance flag
	//10    // number of Players 

	//Q.1 Initialize the first four state variables by reading data from a file named "input.txt". See Fig.1 for file format.
		Scanner in;
		try {
			in = new Scanner(new File("input.txt"));
			{
				result = in.nextInt();
				pChance = in.nextBoolean();
				mChance = in.nextBoolean();
				nop = in.nextInt();
				lock = new Object();
				in.close();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	}
// GETTERANDSETTERMETHODSAREALREADYPROVIDED

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public boolean ispChance() {
		return pChance;
	}

	public void setpChance(boolean pChance) {
		this.pChance = pChance;
	}

	public boolean ismChance() {
		return mChance;
	}

	public void setmChance(boolean mChance) {
		this.mChance = mChance;
	}

	public int getNop() {
		return nop;
	}

	public void setNop(int nop) {
		this.nop = nop;
	}

	public Object getLock() {
		return lock;
	}

	public void setLock(Object lock) {
		this.lock = lock;
	}
	
}
