package ProducerConsumer;

public class User {

	public User() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		SharedResource sr = new SharedResource(3);
		
		Thread t1 = new Thread(() -> {
			for(int i =0 ; i < 6;i++) {
				try {
					sr.produce(i);					
				}
				catch(Exception e) {
					//catch an exception here
				}
			}
		});
		
		Thread t2 = new Thread(() -> {
			for(int i =0 ; i < 6 ; i++) {
				try {
					sr.consume();
				}
				catch(Exception e) {
					//catch exception
				}
			}
		});
		
		
		t1.start();
		t2.start();

	}

		/*
0 Produced
1 Produced
2 Produced
Buffer full
0 consumed
1 consumed
2 consumed
Buffer empty
3 Produced
4 Produced
5 Produced
3 consumed
4 consumed
5 consumed
	 */

}
