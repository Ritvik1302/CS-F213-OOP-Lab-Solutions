import java.util.Random;

public class Player1 implements Runnable {
	private Data d; // shared object
	Random rand = new Random(); // random number generator

	public Player1(Data d) {
		this.d = d;
	} // constructor

	public synchronized void run() {
		//Q.3 (a) How to access the shared object?
		//Q.3 (b) What is the reason for the monitor to wait?
		synchronized(d.getLock()){
			while(d.ispChance()==false) {
					try {
						d.getLock().wait(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					d.setResult(rand.nextInt(2)); //tossing coin and writing result
					//Q.3 (c) The player should do some important work after writing the result of coin toss to the shared object
					d.setpChance(false);
					d.setmChance(true);
				}
			} // end of run method
		}
	}

