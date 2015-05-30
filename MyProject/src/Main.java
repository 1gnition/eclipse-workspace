import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Main {

	public static void main(String[] args) throws Exception {
		Main main = new Main();
		new Thread(new Runnable() {
			@Override
			public void run() {
				main.foo();
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				main.bar();
			}
		}).start();
		

	}

	public void foo() {
		synchronized (this) {
			try {
				System.out.println("Thread " + Thread.currentThread().getName() + " waiting");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void bar() {
		synchronized (this) {
			System.out.println("Thread " + Thread.currentThread().getName() + " notifying");
			notifyAll();
		}
	}
}
