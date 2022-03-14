//credits : https://www.infoworld.com/article/2075692/avoid-synchronization-deadlocks.html
// author : Fred Migeon - IRIT - Université Toulouse 3
package f_deadlock;

public class View {
	private Model myModel;
	public synchronized void updateView() {
		Object o = myModel.getSomething();
	}
	public synchronized void somethingChanged() {
		doSomething();
	}
	public void setMyModel(Model myModel) {
		this.myModel = myModel;
	}
	private void doSomething() {
		System.out.println("Something done on the view");
	}
}