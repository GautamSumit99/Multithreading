package SharedResource;

public class User {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
			SharedResource resource = new SharedResource();
			
			Thread produceThread = new Thread(() -> {
				try {
					Thread.sleep(5000);
				}
		 catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				resource.produce();});
			Thread consumeThread = new Thread(() -> {try {
				resource.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}});
			
			produceThread.start();
			consumeThread.start();
	}

}
