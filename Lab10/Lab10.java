public class Lab10 {
	public static void main(String[] args) {
		Data d = new Data();
		Thread[] players;
		Thread monitor;

		//Q.4 (a) Create and start player threads
		players = new Thread[d.getNop()];
		for(int i=0;i<d.getNop();i++) {
			players[i] = new Thread(new Player1(d));
			players[i].start();
		}
		
		//Q.4 (b) Create and start monitor thread
		monitor = new Thread(new Monitor(d));
		monitor.start();
	}
}
