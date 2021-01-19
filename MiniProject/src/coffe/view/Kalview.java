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

public class Kalview extends JFrame {
	private JButton newButton;

	public Kalview(int w, int h, String title) {
		MyUtil.init(this, w, h, title);
		ImagePanel panel = new ImagePanel("칼리타드립.png");
		JLabel lb1 = new JLabel("***칼리타드리퍼***");
		JLabel lb2 = new JLabel("칼리타드리퍼는 초보자들도 쉽게 사용할 수 있다.");
		JLabel lb3 = new JLabel("칼리타는 과소,과다 추출의 위험을 줄일수 있다는 특징이 있고");
		JLabel lb4 = new JLabel("칼리타 드리퍼는 반침지식특징 갖고있으며,");
		JLabel lb5 = new JLabel("개성이 강한커피를 추출하기에 아주 적합하다.");
		JLabel lb6 = new JLabel("저렴한 가격으로 맛있는 커피를 추출 할 수가 있다.");
		// panel
		panel.setLayout(null);
		// panel
		panel.add(lb1);
		panel.add(lb2);
		panel.add(lb3);
		panel.add(lb4);
		panel.add(lb5);
		panel.add(lb6);

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
		lb6.setBounds(5, 420, 500, 30);
		// Font 수정

		lb1.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb2.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb3.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb4.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb5.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		lb6.setFont(new Font("맑은 고딕", Font.BOLD, 15));
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
		new Kalview(500, 500, "칼리타 커피").setVisible(true);

	}

}
