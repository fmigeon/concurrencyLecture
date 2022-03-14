//credits : https://www.infoworld.com/article/2075692/avoid-synchronization-deadlocks.html
// author : Fred Migeon - IRIT - Université Toulouse 3
package f_deadlock;

public class Model {
	private View myView;
	public synchronized void updateModel(Object someArg) {
		doSomething(someArg);
		myView.somethingChanged();
	}

	public synchronized Object getSomething() {
		return someMethod();
	}
	

	public void setMyView(View myView) {
		this.myView = myView;
	}

	private Object someMethod() {
		return null;
	}

	private void doSomething(Object someArg) {
		System.out.println("Something done on the model");
	}

}
