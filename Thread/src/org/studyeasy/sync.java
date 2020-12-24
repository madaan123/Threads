package org.studyeasy;

class syncMethod {
	// synchronized method that cannot be called by multiple threads at a same time
	synchronized void printBracket() {
		for (int i = 0; i < 5; i++)
			System.out.print("[");
		for (int i = 0; i < 5; i++)
			System.out.print("]");
		System.out.println();
	}
	
	// Synchronized block
	public void printBracket_1() {
		synchronized (this){
			for (int i = 0; i < 5; i++)
				System.out.print("[");
			for (int i = 0; i < 5; i++)
				System.out.print("]");
			System.out.println();
		}

	}
}

public class sync {
	public static int counter = 0;

	public static void main(String[] args) {
//		Thread t1 = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				for (int i = 0; i < 1000; i++)
//					sync.counter++;
//			}
//		});
//
//		Thread t2 = new Thread(new Runnable() {
//
//			@Override
//			public void run() {
//				for (int i = 0; i < 1000; i++)
//					sync.counter++;
//			}
//		});
//
//		t1.start();
//		t2.start();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println(sync.counter);

		System.out.println("***********************");

		syncMethod sync1 = new syncMethod();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++)
					sync1.printBracket_1();
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++)
					new syncMethod().printBracket_1();
			}
		}).start();

	}

}
