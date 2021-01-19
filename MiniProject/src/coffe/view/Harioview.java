package coffe.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import util.MyUtil;

public class Harioview extends JFrame {
	public Harioview(int w, int h, String title) {
		MyUtil.init(this, w, h, title);
		ImagePanel panel = new ImagePanel("하리오드리퍼.jpg");
		JLabel lb1 = new JLabel("***하리오드리퍼***");
		JLabel lb2 = new JLabel("원추형 모양의 드리퍼이며.");
		JLabel lb3 = new JLabel("커피가루 층이 깊게 형성되며 커피성분을 잘 뽑아낸다");
		JLabel lb4 = new JLabel("나선형 모양의 리브이며 ");
		JLabel lb5 = new JLabel("빠른 속도의 추출을 도와준다.");

		// panel
		panel.setLayout(null);
		// panel
		panel.add(lb1);
		panel.add(lb2);
		panel.add(lb3);
		panel.add(lb4);
		panel.add(lb5);

		JButton back1 = new JButton();
		back1.setBounds(450, 3, 30, 30);
		back1.setFocusable(false);
		back1.setIcon(new ImageIcon("xicon.png"));
		Color co6 = new Color(255, 217, 180);
		back1.setBackground(co6);
		back1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

			}
		});

		panel.add(back1);

		// panel저장공간
		lb1.setBounds(150, 320, 500, 30);
		lb2.setBounds(5, 340, 500, 30);
		lb3.setBounds(5, 360, 500, 30);
		lb4.setBounds(5, 380, 500, 30);
		lb5.setBounds(5, 400, 500, 30);

		// Font 수정

		lb1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb5.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		add(panel);
	}

	public class ImagePanel extends JPanel {
		private BufferedImage image;
		private int w;
		private int h;

		public ImagePanel(String fileName) {
			try {
				image = ImageIO.read(new File(fileName));
				w = image.getWidth();
				h = image.getHeight();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		/**
		 * 현재 패널크기를 백그라운드 이미지의 크기로 지정
		 */
		@Override
		public Dimension getPreferredSize() {
			return new Dimension(w, h);
		}

		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			// img객체를 x,y값만큼 떨어뜨려(offset) 그리기 메소드
			// boolean java.awt.Graphics.drawImage(Image img, int x, int y, ImageObserver
			// observer)
			g.drawImage(image, 0, 0, null);
		}
	}

	public static void main(String[] args) {
		new Harioview(500, 500, "하리오커피").setVisible(true);

	}

}