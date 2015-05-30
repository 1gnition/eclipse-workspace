import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class Preloader {
	private final FutureTask<Boolean> future = new FutureTask<Boolean>(
			new Callable<Boolean>() {
				public Boolean call() throws Exception {
					return true;
				}
			});
	private final Thread thread = new Thread(future);

	public void start() {
		thread.start();
	}

	public Boolean get() throws Exception {
		try {
			return future.get(5, TimeUnit.SECONDS);
		} catch (ExecutionException e) {
			throw e;
		}
	}
}
