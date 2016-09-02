import java.util.concurrent.ArrayBlockingQueue;

public class Main {

	private static final int ThreadCount = 4;

	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueue<Long> S1 = new ArrayBlockingQueue<>(11);
		ArrayBlockingQueue<Long> S2 = new ArrayBlockingQueue<>(11);
		
		long[]array = {4,5,8,12,21,22,34,35,36,37,42};
		
		for (long l : array) {
			S1.put(l);
		}
		
		Consumer c = new Consumer(S1, S2);
		
		for (int i = 0; i < ThreadCount; i++) {
			Producer p = new Producer(S1, S2);
			p.registerObserver(c);
			new Thread(p).start();
		}
		
		c.start();
		
		
		
	}

	
}
