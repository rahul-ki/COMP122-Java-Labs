public class Prodcon {
	//MAIN THREAD
	public static void main (String args[]) {
		// Create buffer, producer & consumer
		Buffer b = new Buffer();
		Producer p = new Producer(b);
		Consumer c = new Consumer(b);
		//start() calls run() and initialises the thread
		p.start(); 
		c.start();
	}
}