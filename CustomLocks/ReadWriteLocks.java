package CustomLocks;

import java.util.concurrent.locks.ReadWriteLock;

public class ReadWriteLocks {

 public boolean isAvailable;

 public void produce(ReadWriteLock lock) {
     // indicate intent
     System.out.println(Thread.currentThread().getName() + " attempting to acquire READ lock");
     lock.readLock().lock();
     try {
         System.out.println("READ lock acquired in produce by " + Thread.currentThread().getName());
         try {
             Thread.sleep(8000);
         } catch (InterruptedException e) {
             Thread.currentThread().interrupt();
         }
         isAvailable = true;
     } finally {
         lock.readLock().unlock();
         System.out.println("READ lock released in produce by " + Thread.currentThread().getName());
     }
 }

 public void consume(ReadWriteLock lock) {
     System.out.println(Thread.currentThread().getName() + " attempting to acquire WRITE lock");
     lock.writeLock().lock();
     try {
         System.out.println("WRITE lock acquired in consume by " + Thread.currentThread().getName());
         isAvailable = false;
         // simulate work
         try {
             Thread.sleep(1000);
         } catch (InterruptedException e) {
             Thread.currentThread().interrupt();
         }
     } finally {
         lock.writeLock().unlock();
         System.out.println("WRITE lock released in consume by " + Thread.currentThread().getName());
     }
 }
}
