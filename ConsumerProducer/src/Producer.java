import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class Producer extends Thread {

	private ArrayBlockingQueue<Long> S1;
	private ArrayBlockingQueue<Long> S2;
	
	List<Observer> observers = new ArrayList<>();

	public void registerObserver(Observer o){
		observers.add(o);
	}
	
	public void notifyAllObservers(){
		for(Observer observer : observers){
			observer.wakeup();
		}
	} 

	public Producer(ArrayBlockingQueue<Long> S1, ArrayBlockingQueue<Long> S2) {
		super();
		this.S1 = S1;
		this.S2 = S2;
	}

	@Override
	public void run() {
		while(!S1.isEmpty()){
			try {
				S2.put(fib(S1.poll()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notifyAllObservers();
			//System.out.println("hej");
		}
		super.run();
	}

	@Override
	public synchronized void start() {

		super.start();
	}

	private long fib(long n) {
		if ((n == 0) || (n == 1)) {
			return n;
		} else {
			return fib(n - 1) + fib(n - 2);
		}
	}

}
