// author : Fred Migeon - IRIT - Université Toulouse 3
package f_deadlock;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		View view = new View();
		model.setMyView(view);
		view.setMyModel(model);
		
		for(int i=0;i<10;i++) {
			view.updateView();
			model.updateModel(null);
		}
		System.out.println("En parallele");
		new Thread(()->{for(int i=0;i<1000;i++) model.updateModel(null);}).start();
		for(int i=0;i<1000;i++) view.updateView();
		
	}

}
