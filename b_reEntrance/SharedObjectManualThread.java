// author : Fred Migeon - IRIT - Université Toulouse 3
package b_reEntrance;

public class SharedObjectManualThread extends Thread {

	// Given by the constructor
	private BasicObject summation;
	private int computationCount;

	public SharedObjectManualThread(BasicObject summation, int computationCount) {
		this.summation = summation;
		this.computationCount = computationCount;
	}

	@Override
	public void run() {
		for (int i = 0; i < computationCount; i++) {
			summation.calculate();
		}
	}

	public int getSum() {
		return summation.getSum();
	}
}
