// author : Fred Migeon - IRIT - Universit√© Toulouse 3
package a_manualThreaded;

public class ManualThread extends Thread {

	private BasicObject summation = new BasicObject();

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			summation.calculate();
		}
	}

	public int getSum() {
		return summation.getSum();
	}
}
