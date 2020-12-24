package org.studyeasy;

class syncStatic {
	// synchronized method that cannot be called by multiple threads at a same time
	synchronized static void printBracket(String ThreadId) {
		for (int i = 0; i < 5; i++)
			System.out.print("[");
		for (int i = 0; i < 5; i++)
			System.out.print("]");
		System.out.println("Output from " + ThreadId);
	}
	
}

public class StaticSync {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++)
					syncStatic.printBracket("Thread1");
			}
		}).start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 5; i++)
					syncStatic.printBracket("Thread2");
			}
		}).start();
	}

}
