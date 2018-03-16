class Consumer extends Thread { 
	private Buffer b;	// instantiate object from Buffer class
	// Constructor
	public Consumer (Buffer buf) { 
		b = buf;
	}

	//run() tells what the thread does during its process-duration.
	public void run() {
		//Consumer can remove items from buffer
		int n = b.remove();
		int k = b.remove();
	}
}