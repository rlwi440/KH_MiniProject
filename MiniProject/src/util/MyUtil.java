package util;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class MyUtil {

	public static void init(JFrame f, int w, int h, String title) {
		f.setTitle(title);
		f.setSize(w, h);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

//	public static void changePanel(JFrame parent, CustomPanel current, JPanel next) {
//		parent.remove(current);
//		parent.add(next);
//		
//		//컨테이너하위에 계층구조를 새로고침하는 기능, 리무브, 애드로 안됨
//		parent.revalidate();
//		//화면 다시 그리기
//		parent.repaint();
//		
//	}

}
