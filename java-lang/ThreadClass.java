import java.lang.*;
import java.util.*;
import java.io.*;

class MyThread extends Thread {
	public MyThread() {
		System.out.println("Creating my thread instance");
	}

	@Override
	public void run() {
		System.out.println("Running my thread instance");
	}
}

class MyRunnable implements Runnable {
	boolean runFlag;

	public void stopThread() {
		this.runFlag = false;
	}

	public MyRunnable() {
		runFlag = true;
	}

	public void run() {
		System.out.println("MyRunnable");
		while (runFlag) {
			try {
				System.out.println("Going to sleep");
				Thread.sleep(1010);
			} catch (Exception e) {
				System.out.println("Got exception");
			}
			System.out.println("Came back from sleep");
		}
	}
}

class TwoSums {
	private int sum1 = 0;
	private int sum2 = 0;

	private Integer sum1Lock = new Integer(1);
	private Integer sum2Lock = new Integer(2);

	public void add(int val1, int val2) {
		synchronized (this.sum1Lock) {
			sum1 += val1;
		}
		synchronized (this.sum2Lock) {
			sum2 += val2;
		}
	}
}

class SyncTest {
	private int value = 0;

	public void add(int val) {
		System.out.println("Changing the value");
		this.value += val;
	}

	public synchronized void sleep() {
		System.out.println("Going to sleep " + this.value);
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
		}
		System.out.println("Waking up " + this.value);
	}
}

class MySignal {
	protected boolean signal = false;

	public synchronized boolean hasDataToProcess() {
		return signal;
	}

	public synchronized void setHasDataToProcess() {
		this.signal = true;
	}
}

public class ThreadClass {
	public static void main(String[] args) {
		System.out.println("Created thread example");
		// Thread t = new MyThread();
		// Thread t1 = new Thread() {
		// public void run() {
		// System.out.println("Anonymous class instance ");
		// }
		// };

		// t.start();
		// t1.start();

		// Runnable r = () -> System.out.println("Lambda Runnable");
		// MyRunnable r1 = new MyRunnable();

		// Thread tr = new Thread(r, "This Thread");
		// Thread tr1 = new Thread(r1);

		// tr.start();
		// tr1.start();

		// try {
		// Thread.sleep(6450);
		// } catch (Exception e) {
		// System.out.println("Caught an exception");
		// }
		// r1.stopThread();

		SyncTest st = new SyncTest();
		Thread testSync1 = new Thread(() -> {
			st.add(10);
		});

		Thread testSync2 = new Thread(() -> {
			st.sleep();
		});

		testSync2.start();
		testSync1.start();
	}
}