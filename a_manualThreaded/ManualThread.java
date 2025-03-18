// author : Fred Migeon - IRIT - Université Toulouse 3
package a_manualThreaded;

public class ManualThread extends Thread {

	private BasicObject summation = new BasicObject();

	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			summation.calculate();
		}
	}

	public int getSum() {
		return summation.getSum();
	}
	
	public static void main(String[] args) {
		ManualThread mt = new ManualThread();
		mt.start();
	}
}
