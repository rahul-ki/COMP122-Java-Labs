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
				System.out.println("The buffer is full. you must wait, until something is removed");
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
				System.out.println("The buffer is empty. You must wait, until something is added");
				wait(); // moves thread into the wait set, 
				//so that another thread can come and access the buffer (to do something in it).				
			}
			catch (InterruptedException e) {}
		}
		// else:-
		empty = true;
		notify();
		// notify() - moves a thread in wait set back to runnable set so it can run again.
		System.out.println("Removed " + v + " from buffer");
		return v;
	}
}

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
		int l = 7;
	
		b.insert(m);
		b.insert(d);
		b.insert(l);
	}
}

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
