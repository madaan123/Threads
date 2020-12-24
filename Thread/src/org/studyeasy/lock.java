package org.studyeasy;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class lock {

	int counter = 0;
	Lock lock = new ReentrantLock();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		lock l = new lock();
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				l.lock.lock();
				try {
					for (int i = 0; i < 100; i++)
						l.counter++;
				} finally {
					l.lock.unlock();
				}
			}
		});

		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				l.lock.lock();
				try {
					for (int i = 0; i < 100; i++)
						l.counter++;
				} finally {
					l.lock.unlock();
				}
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			// t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(l.counter);
	}

}
