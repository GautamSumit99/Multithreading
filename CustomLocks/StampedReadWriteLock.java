package CustomLocks;

import java.util.concurrent.locks.StampedLock;

public class StampedReadWriteLock {
	boolean isAvailable =false;
	
	StampedLock lock = new StampedLock();
	
	
	public void producer() {
		long stamp = lock.readLock();

		try {
			System.out.println(Thread.currentThread().getName()+" producer acquired lock");
			isAvailable = true;
			Thread.sleep(6000);
		}
		catch(Exception e) {
			//catch exception
		}
		finally {
			lock.unlock(stamp);
			System.out.println(Thread.currentThread().getName()+" producer released lock");
		}
	}
	
	public void consumer() {
		long stamp = lock.writeLock();
		try {
			System.out.println(Thread.currentThread().getName()+" consumer acquired lock");
			isAvailable = false;
		}
		catch(Exception e) {
			
		}
		finally {
			lock.unlock(stamp);
			System.out.println(Thread.currentThread().getName()+" consumer released lock");
		}
	}
}
