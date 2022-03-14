//credits : https://www.baeldung.com/java-synchronized
// author : Fred Migeon - IRIT - Université Toulouse 3

package c_threadedMutableObject;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import org.junit.Test;

public class ThreadTest {

	@Test
	public void singleThread() {
		ExecutorService service = Executors.newFixedThreadPool(1);
		BasicMutableObject summation = new BasicMutableObject();

		IntStream.range(0, 1000).forEach(value -> service.submit(summation::calculate));
		try {
			service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(1000, summation.getSum());
	}

	@Test
	public void multiThread() {
		ExecutorService service = Executors.newFixedThreadPool(3);
		BasicMutableObject summation = new BasicMutableObject();

		IntStream.range(0, 1000).forEach(value -> service.submit(summation::calculate));
		try {
			service.awaitTermination(1000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		assertEquals(1000, summation.getSum());
	}

}
