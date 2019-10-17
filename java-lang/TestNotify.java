import java.io.*;
import java.lang.*;
import java.util.*;

class MonitorObject {

}

class WaitNotify {
	Object mo;

	public WaitNotify(Object mo) {
		this.mo = mo;
	}

	public void doWait() {
		synchronized (mo) {
			try {
				mo.wait();
			} catch (InterruptedException e) {
				System.out.println("Interrupted wait");
			}
		}
	}

	public void doNotify() {
		synchronized (mo) {
			mo.notify();
		}
	}
}

class Lock {
	Thread lockingThread = null;
	private boolean isLocked = false;

	public Lock() {
	}

	public synchronized void lock() throws InterruptedException {
		System.out.println("Trying to take lock");
		while (isLocked) {
			wait();
		}
		lockingThread = Thread.currentThread();
		isLocked = true;
		System.out.println("Got lock");
	}

	public synchronized void unlock() {
		System.out.println("Trying to free the lock");
		if (lockingThread != Thread.currentThread()) {
			throw new IllegalMonitorStateException("Calling thread has not locked this lock");
		}
		isLocked = false;
		lockingThread = null;
		notify();
		System.out.println("Freed the lock");
	}

}

// class FairLock {
// private boolean isLocked = false;
// private Thread thread = null;
// private Queue<QueueObject> q = new PriorityQueue<QueueObject>();

// public void lock() {

// }

// public synchronized void unlock() {

// }

// class QueueObject {
// long timestamp;

// public QueueObject() {
// this.timestamp = System.currentTimeMillis();
// }
// }

// }
class SyncTest {
	public synchronized void m1() {
		try {
			System.out.println("Inside m1");
			Thread.sleep(10000);
			System.out.println("Leaving m1");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	public synchronized void m2() {
		try {
			System.out.println("Inside m2");
			Thread.sleep(10000);
			System.out.println("Leaving m2");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}

public class TestNotify {
	public static void main(String[] args) {

		// Lock l = new Lock();

		// Runnable r = () -> {
		// 	try {
		// 		l.lock();
		// 		Thread.sleep(10000);
		// 		l.unlock();
		// 	} catch (Exception e) {

		// 	}
		// };

		// Thread t1 = new Thread(r);
		// Thread t2 = new Thread(r);

		// t1.start();
		// t2.start();

		SyncTest st = new SyncTest();
		Thread t1 = new Thread(() -> st.m1());
		Thread t2 = new Thread(() -> st.m2());

		t1.start();
		t2.start();
		

	}
}