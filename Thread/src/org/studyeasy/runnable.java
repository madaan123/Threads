package org.studyeasy;

import java.util.Random;

class Counter_Run implements Runnable {
	private int ThreadId;

	public Counter_Run(int threadId) {
		ThreadId = threadId;
	}

	@Override
	public void run() {
		Random rand = new Random();
		for (int i = 1; i <= 10; i++) {
			try {
				Thread.sleep(rand.nextInt(500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Counter " + i + " ThreadId " + ThreadId);
		}
	}

}

public class runnable {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Counter_Run(1));
		Thread thread2 = new Thread(new Counter_Run(2));

		thread1.start();
		thread2.start();

		Thread thread3 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				for (int i = 0; i < 5; i++) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("Hello");
				}

			}
		});
		thread3.start();

	}

}
