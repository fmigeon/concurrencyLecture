// author : Fred Migeon - IRIT - Universit√© Toulouse 3
package a_manualThreaded;

import static org.junit.Assert.*;

import org.junit.Test;

public class ManualThreadTest {

	private static final int DURATION = 1000;

	@Test
	public void badThreadUse() {
		ManualThread thread = new ManualThread();
		thread.start();
		
		/* test wont pass because thread has not finished 'starting'
		 * (which is iterating 1000 times on calculate)
		 * while thread object is activated by jvm thread to get sum value
		 */
		assertEquals(1000, thread.getSum());
	}
	
	@Test
	public void anotherBadThreadUse() {
		ManualThread thread = new ManualThread();
		thread.start();
		
		waitNow(1000);

		/* test passes but only because we wait enough.
		 * If DURATION is lowered, test don't pass anymore.
		 */
		assertEquals(DURATION, thread.getSum());
	}
	
	public synchronized void waitNow(long time) {
		try {
			this.wait(time);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
