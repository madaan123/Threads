package org.studyeasy;

import java.util.concurrent.ArrayBlockingQueue;

class Producer implements Runnable{

	private ArrayBlockingQueue<Integer> queue;
	
	public Producer(ArrayBlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(1000);
				queue.put(ProducerConsumer.counter++);
				System.out.println("value added in queue: "+ ProducerConsumer.counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class Consumer implements Runnable{

	private ArrayBlockingQueue<Integer> queue;
	
	public Consumer(ArrayBlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		while(true)
		{
			try {
				Thread.sleep(2000);
				queue.take();
				ProducerConsumer.counter--;
				System.out.println("value Removed from queue: "+ ProducerConsumer.counter);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

public class ProducerConsumer {

	public static int counter = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(5);
		Producer p = new Producer(queue);
		Thread producerThread = new Thread(p);
		producerThread.start();
		
		Consumer c = new Consumer(queue);
		Thread consumerThread = new Thread(c);
		consumerThread.start();
	}

}
