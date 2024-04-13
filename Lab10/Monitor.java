import java.io.*;
import java.io.PrintWriter;

public class Monitor implements Runnable {

	private Data d; // shared object
	private int tails = 0; // count number of tails
	private int heads = 0; // count number of heads

	public Monitor(Data d) {
		this.d = d;
	} // constructor

	public void run() {

		// Q.2 (a) How long should this thread run?
		for (int i = 0; i < d.getNop(); i++) {
			// Q.2 (b) How to access the shared object?
			// Q.2 (c) What is the reason for the monitor to wait?
			while (d.ispChance() == true) {
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			synchronized (d) {
				System.out.println("monitor is going to read value ...");
				if (d.getResult() == 0)
					tails++;
				else
					heads++;
				// Q.2 (d) The monitor should do some important work after reading the result of
				// last player and before attempting to read the
				// result of current player in the next iteration
				d.setpChance(true);
				d.setmChance(false);
				d.notify();
			}
		}
		// Q.2 (e) Write the results i.e., number of heads and number of tails to a file
		// named "out.txt"
		try {
			PrintWriter out = new PrintWriter(new File("out.txt"));
			out.println("Heads: " + heads);
			out.println("Tails: " + tails);
			out.close();
		} catch (FileNotFoundException e) {
			System.out.println("File Not Found");
		}
	} // end of run method
}// end of class definition
