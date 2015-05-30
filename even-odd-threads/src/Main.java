

public class Main {
	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("starting...");
				System.out.println("interrupted is " + Thread.currentThread().isInterrupted());
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					System.out.println("in catch block");
					System.out.println("interrupted is " + Thread.currentThread().isInterrupted());
				}
			}
		});
		
		thread.start();
		
		Thread.sleep(100);
		
		thread.interrupt();
		
		
		thread = new Thread(new Runnable() {

			@Override
			public void run() {
				System.out.println("starting...");
				System.out.println("interrupted is "
						+ Thread.currentThread().isInterrupted());
				while (!Thread.currentThread().isInterrupted()) {
					
				}
				System.out.println("interrupted is "
						+ Thread.currentThread().isInterrupted());
			}
		});
		
		thread.start();

		Thread.sleep(100);

		thread.interrupt();
		
	}
}
