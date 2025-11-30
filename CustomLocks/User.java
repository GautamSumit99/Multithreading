package CustomLocks;

import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReadWriteLock;
public class User {

	public static void main(String[] args) {
//		ReentrantLocks sharedObject = new ReentrantLocks();
//		
//		Thread t1 = new Thread(() -> {sharedObject.produce();});
//		
//		Thread t2 = new Thread(() -> {sharedObject.produce();});
//			
//		t1.start();
//		t2.start();
		
//		ReadWriteLocks resource1 = new ReadWriteLocks();
//		
//		ReadWriteLock lock = new ReentrantReadWriteLock();
//		Thread t1 = new Thread(() -> {resource1.produce(lock);});
//		Thread t2 = new Thread(() -> {resource1.produce(lock);});
//		
//		ReadWriteLocks resource2 = new ReadWriteLocks();
//		Thread t3 = new Thread(() -> {resource2.consume(lock);});
//		t1.start();
//		t2.start();
//        try { Thread.sleep(200); } catch (InterruptedException e) { Thread.currentThread().interrupt(); }
//		t3.start();
		
		
//		StampedReadWriteLock resource1 = new StampedReadWriteLock();
//		
//
//		Thread t1 = new Thread(() -> {resource1.producer();});
//		Thread t2 = new Thread(() -> {resource1.producer();});
//		Thread t3 = new Thread(() -> {resource1.consumer();});
//		t1.start();
//		t2.start();
//		t3.start();
		
		
//	StampedOptimisticLock resource1 = new StampedOptimisticLock();
//		
//
	//		Thread t1 = new Thread(() -> {resource1.producer();});
//		Thread t2 = new Thread(() -> {resource1.producer();});
//		Thread t3 = new Thread(() -> {resource1.consumer();});
//		t1.start();
//		t2.start();
//		t3.start();
		
//		Thread-1 producer acquired lock
//		Thread-2 consumer acquired lock
//		Thread-0 producer acquired lock
//		Thread-2 consumer released lock
//		rollback is successful
//		rollback is successful
		
		SemaphoreResource resource1 = new SemaphoreResource();
		

		Thread t1 = new Thread(() -> {resource1.producer();});
		Thread t2 = new Thread(() -> {resource1.producer();});
		Thread t3 = new Thread(() -> {resource1.producer();});
		Thread t4 = new Thread(() -> {resource1.producer();});
		Thread t5 = new Thread(() -> {resource1.producer();});
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
	}

}
