import java.util.concurrent.ArrayBlockingQueue;

public class Consumer extends Thread implements Observer {
	
	private ArrayBlockingQueue<Long> S1;
	private ArrayBlockingQueue<Long> S2;
	
	private long sum = 0;
	
	public Consumer(ArrayBlockingQueue<Long> s1, ArrayBlockingQueue<Long> s2) {
		super();
		S1 = s1;
		S2 = s2;
	}

	@Override
	public void run() {
		while(!S2.isEmpty()){
//			System.out.println(S2.poll());
			sum+=S2.poll();
			System.out.println(sum);
		}
		super.run();
	}
	
	@Override
	public synchronized void start() {
		
		super.start();
	}

	@Override
	public void wakeup() {
		
		if(!this.isAlive()){
			this.run();
		}
	}
	
	public long getSum(){
		
		return sum;
	}

}
