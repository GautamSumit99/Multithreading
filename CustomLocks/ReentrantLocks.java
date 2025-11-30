package CustomLocks;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {
		
	public boolean isAvailable; 
	
	ReentrantLock lock = new ReentrantLock();
	
	public void produce() {
		try{
			lock.lock();
			System.out.println("Lock acquired in produce by "+ Thread.currentThread().getName());
			isAvailable = true;
		}
		catch(Exception e) {
			//catch an exception
		}
		finally {
			lock.unlock();
			System.out.println("Lock released in produce by "+ Thread.currentThread().getName());
		}
	}
	
	public void consume() {
		try {
			lock.lock();
			System.out.println("Lock acquired in consume by "+ Thread.currentThread().getName());
			isAvailable = false;
		}
		catch(Exception e) {
			//catch an exception
		}
		finally {
			lock.unlock();
			System.out.println("Lock released in consume by "+ Thread.currentThread().getName());
		}
	}
}
