class Buffer {

	private int v;
	//volatile - ensures that computer reloads the variable each time it is called.
	private volatile boolean empty=true;

	//synchronized - When a thread calls a synchronized method, 
	//it gains exclusive control over it. 
	//All other threads can't access the method anymore 
	//and must wait, until "lock" is released

	public synchronized void insert (int x) {
		while (!empty) {  
		// if not-empty, can't add. must wait
			try {
				wait(); // moves thread into the wait set, 
				//so that another thread can come and access the buffer (to do something in it).
			}
			catch (InterruptedException e) {}
		}
		//else:-(if empty)
		empty = false;
		v = x;
		System.out.println("Added " + v + " into the buffer.");
		notify();
		// notify() - moves a thread in wait set back to runnable set so it can run again.
	}
		
	public synchronized int remove() {
		while (empty) {
		//if empty, can't remove. must wait
			try {
				wait(); // moves thread into the wait set, 
				//so that another thread can come and access the buffer (to do something in it).
			}
			catch (InterruptedException e) {}
		}
		// else:-
		empty = true;
		notify();
		// notify() - moves a thread in wait set back to runnable set so it can run again.
		System.out.println("Removed " + v " from buffer");
		return v;
	}
}