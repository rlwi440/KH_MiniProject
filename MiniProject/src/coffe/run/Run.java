package coffe.run;


import java.awt.EventQueue;
import coffe.view.MainMenu;


public class Run {
	
	public static void main(String[] args) {
		
		//gui 에러 방지용
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MainMenu().setVisible(true);
			}
		});
	}


}
