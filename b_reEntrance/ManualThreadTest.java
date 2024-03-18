// author : Fred Migeon - IRIT - Université Toulouse 3
package b_reEntrance;

import static org.junit.Assert.*;

import org.junit.Test;

public class ManualThreadTest {

	private static final int SHORT_TIME = 1000;
	private static final int LONG_TIME = 10000;
	private static final int VERY_LONG_TIME = 100000;

	private static final int TEN_COMPUTATIONS = 10;
	private static final int HUNDRED_COMPUTATIONS = 100;
	private static final int THOUSAND_COMPUTATIONS = 1000;

	private static final int TEN_THREADS = 10;

	@Test
	public void tenThreadsDoingTenComputation() {
		long startTime = System.currentTimeMillis();

		BasicObject summation = new BasicObject();
		for (int i = 0; i < TEN_THREADS; i++) {
			new SharedObjectManualThread(summation, TEN_COMPUTATIONS).start();
		}

		waitNow(SHORT_TIME);
		long endTime = System.currentTimeMillis();
		long elapsedTime = (endTime - startTime);
		System.out.println("Execution time for short test : " + elapsedTime);

		assertEquals(TEN_THREADS * TEN_COMPUTATIONS, summation.getSum());
	}

//	@Test
//	public void tenThreadsDoingHundredComputation() {
//		long startTime = System.currentTimeMillis();
//
//		BasicObject summation = new BasicObject();
//		for (int i = 0; i < TEN_THREADS; i++) {
//			new SharedObjectManualThread(summation,HUNDRED_COMPUTATIONS).start();
//		}
//		
//		waitNow(LONG_TIME);
//		long endTime = System.currentTimeMillis();
//		long elapsedTime = (endTime - startTime);
//		System.out.println("Execution time for long test : " + elapsedTime);
//				
//		assertEquals(TEN_THREADS * HUNDRED_COMPUTATIONS, summation.getSum());
//	}
//
//	@Test
//	public void tenThreadsDoingThousandComputation() {
//		long startTime = System.currentTimeMillis();
//
//		BasicObject summation = new BasicObject();
//		for (int i = 0; i < TEN_THREADS; i++) {
//			new SharedObjectManualThread(summation,THOUSAND_COMPUTATIONS).start();
//		}
//		
//		waitNow(LONG_TIME);
//		long endTime = System.currentTimeMillis();
//		long elapsedTime = (endTime - startTime);
//		System.out.println("Execution time for very long test : " + elapsedTime);
//				
//		assertEquals(TEN_THREADS * THOUSAND_COMPUTATIONS, summation.getSum());
//	}

	public synchronized void waitNow(long time) {
		try {
			this.wait(time);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
