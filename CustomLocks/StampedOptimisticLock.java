package CustomLocks;

import java.util.concurrent.locks.StampedLock;

public class StampedOptimisticLock {
		int value = 10;
		
		StampedLock lock = new StampedLock();
		
		public void producer() {
			long stamp = lock.tryOptimisticRead();

			try {
				System.out.println(Thread.currentThread().getName()+" producer acquired lock");
				value = 11;
				Thread.sleep(6000);
				
				if(lock.validate(stamp)) {
					System.out.println("updated the value successfully");
				}
				else {
					value=10;
					System.out.println("rollback is successful");
				}
			}
			catch(Exception e) {
				//catch exception
			}
		}
		
		public void consumer() {
			long stamp = lock.writeLock();
			try {
				System.out.println(Thread.currentThread().getName()+" consumer acquired lock");
				value = 9;
			}
			catch(Exception e) {
				
			}
			finally {
				lock.unlock(stamp);
				System.out.println(Thread.currentThread().getName()+" consumer released lock");
			}
		}
		
}
