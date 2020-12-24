package org.studyeasy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Pool extends Thread{
	private String ThreadId;

	public Pool(String threadId) {
		ThreadId = threadId;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Starting thread :"+ ThreadId);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Ending thread :"+ ThreadId);
	}
}

public class ThreadPool {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Pool Thread1 = new Pool("Thread1");
		Pool Thread2 = new Pool("Thread2");
		Pool Thread3 = new Pool("Thread3");
		Pool Thread4 = new Pool("Thread4");
		Pool Thread5 = new Pool("Thread5");
		Pool Thread6 = new Pool("Thread6");
		
		executor.execute(Thread1);
		executor.execute(Thread2);
		executor.execute(Thread3);
		executor.execute(Thread4);
		executor.execute(Thread5);
		executor.execute(Thread6);
		
		executor.shutdown();
		
	}

}
