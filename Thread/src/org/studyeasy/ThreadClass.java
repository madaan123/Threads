package org.studyeasy;

class MyCounter extends Thread{
	private int ThreadId;

	public MyCounter(int threadId) {
		ThreadId = threadId;
	}

	@Override
	public String toString() {
		return "MyCounter [ThreadId=" + ThreadId + "]";
	}

	public int getThreadId() {
		return ThreadId;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		countMe();
	}
	
	public void countMe()
	{
		for(int i=1;i<=5;i++)
		{
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Counter " + i + " ThreadId "+ ThreadId);
		}
	}
	
}

public class ThreadClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCounter counter1 = new MyCounter(1);
		MyCounter counter2 = new MyCounter(2);
		
		long startTime = System.currentTimeMillis();
		counter1.start();
		counter2.start();
		long endTime = System.currentTimeMillis();
		System.out.println("Time taken "+ (endTime-startTime));
	}

}
