package org.studyeasy;

public class notify {

	public static int balance = 0;

	public void withdraw(int amount) {
		synchronized (this) {
			if (balance <= 0) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
			}
			if (amount < balance) {
				balance = balance - amount;
				System.out.println("Amount withdrawn");
			}
			else {
				System.out.println("Balance less than amount to be withdrawn");
			}
		}
	}

	public void deposit(int amount) {
		balance += amount;
		System.out.println("Amount Deposited");
		synchronized (this) {
			notifyAll();
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		notify n = new notify();

		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				n.withdraw(1000);
			}
		});

		thread1.start();

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				n.deposit(2000);
			}
		});

		thread2.start();
	}

}
