package SharedResource;

public class SharedResource {

	boolean itemAvailable =false;
	
	
	public synchronized void produce() {
		System.out.println("inside produce method");
		itemAvailable = true;
		notifyAll();
	}
	
	public synchronized void consume() throws InterruptedException {
		System.out.println("inside consume");
		while(!itemAvailable) {
			try {		
				System.out.println("waiting for resource avaiability");
				wait();
			}
			catch(Error e) {
				System.out.println("caught an error "+e);
			}
		}
		System.out.println("consumed item");
		itemAvailable = false;
	}

}
