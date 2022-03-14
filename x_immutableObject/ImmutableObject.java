// author : Fred Migeon - IRIT - Université Toulouse 3
package x_immutableObject;

public class ImmutableObject {
	
	private final int sum;
	
	public ImmutableObject(int initialValue) {
		sum = initialValue;
	}
	
	public ImmutableObject calculate() {
		return new ImmutableObject(sum+1);
	}
	
	public int getSum() {
		return sum;
	}

}
