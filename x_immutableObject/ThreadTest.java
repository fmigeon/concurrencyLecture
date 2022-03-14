// author : Fred Migeon - IRIT - Université Toulouse 3
package x_immutableObject;

import static org.junit.Assert.*;

import org.junit.Test;

public class ThreadTest {

	@Test
	public void nonMutableUse() {
		ImmutableObject summation = new ImmutableObject(0);
		
		for(int i=0;i<1000;i++) {
			summation = summation.calculate();
		}
		assertEquals(1000,summation.getSum());
	}

}
