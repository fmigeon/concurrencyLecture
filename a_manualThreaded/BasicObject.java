// author : Fred Migeon - IRIT - Universit√© Toulouse 3
package a_manualThreaded;

public class BasicObject {

	private int sum = 0;
	
	public void calculate() {
		setSum(getSum()+1);
	}

	private void setSum(int sum) {
		this.sum = sum;
	}

	public int getSum() {
		return sum;
	}
	
}
