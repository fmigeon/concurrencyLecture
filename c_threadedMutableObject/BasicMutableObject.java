package c_threadedMutableObject;

public class BasicMutableObject {

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
