// author : Fred Migeon - IRIT - Université Toulouse 3
package b_reEntrance;

public class BasicObject {

//	Adding a static counter could be useful to control the number of 'setSum'	
//	static int count =0;
	private int sum = 0;
	
	public void calculate() {
		setSum(getSum()+1);
		
//		int val = getSum();
//		val++;
//		fib(30);
//		setSum(val);
	}

	private void setSum(int sum) {
		System.out.println(+Thread.currentThread().getId()+" setting sum to "+sum);
		this.sum = sum;
	}

	public int getSum() {
		return sum;
	}
		
	private static long fib(int n) {
		if (n < 2) return 1;
		else return fib(n-1)+fib(n-2);
	}
	
}
