class Producer extends Thread { 
	private Buffer b;	// instantiate object from Buffer class
	// Constructor
	public Producer (Buffer buf) { 
		b = buf;
	}

	//run() tells what the thread does during its process-duration.
	public void run() {
		//Producer can add items into buffer
		int m = 10;
		int d = 9;
	
		b.insert(m);
		b.insert(d);
	}
}