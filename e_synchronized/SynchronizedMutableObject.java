//credits : https://www.baeldung.com/java-synchronized
// author : Fred Migeon - IRIT - Université Toulouse 3
package e_synchronized;

public class SynchronizedMutableObject {

	private int sum = 0;
	
	public synchronized void calculate() {
		setSum(getSum()+1);
	}

	private void setSum(int sum) {
		this.sum = sum;
	}

	public int getSum() {
		return sum;
	}
	
}
