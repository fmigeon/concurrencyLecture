// author : Fred Migeon - IRIT - Université Toulouse 3
package f_deadlock;

public class Main {

	public static void main(String[] args) {
		Model model = new Model();
		View view = new View();
		model.setMyView(view);
		view.setMyModel(model);
		
		System.out.println("En séquentiel");
		for(int i=0;i<10;i++) {
			view.updateView();
			model.updateModel(i);
		}
		
		System.out.println("\nEn parallele");
		new Thread(()->{for(int i=0;i<1000;i++) model.updateModel(i);}).start();
		for(int i=0;i<1000;i++) view.updateView();
		
	}

}
