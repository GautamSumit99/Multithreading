package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {
	
	Queue<Integer> sharedBuffer;
	int maxBuffer = 3;
	
	public SharedResource( int maxB) {
		sharedBuffer = new LinkedList<>();
		maxBuffer = maxB;
	}
	
	
	
	public synchronized void produce(int val) throws Exception{
//			System.out.println("produce method  invoked");
			while(sharedBuffer.size()>=maxBuffer) {
				System.out.println("Buffer full");
				wait();
			}
			
			sharedBuffer.add(val);
			System.out.println(val+" Produced");
			notifyAll();
	}
	
	
	public synchronized void consume() throws Exception{
		
		while(sharedBuffer.size() <=0) {
			System.out.println("Buffer empty");
			wait();
		}
		
		int val = sharedBuffer.remove();
		System.out.println(val+" consumed");
		notifyAll();
	}
}
