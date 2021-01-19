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

public class Gonoview extends JFrame {
	public Gonoview(int w, int h, String title) {
		MyUtil.init(this, w, h, title);
		ImagePanel panel = new ImagePanel("고노드리퍼.jpg");
		JLabel lb1 = new JLabel("***고노드리퍼***");
		JLabel lb2 = new JLabel("고노 드리퍼는 짧은 것이 특징이며");
		JLabel lb3 = new JLabel("고노드리퍼는 시중에서 잘사용하지 않는다");
		JLabel lb4 = new JLabel("고노 드리퍼 로 커피를 내리려면 드립경력부터 쌓아야한다.");
		JLabel lb5 = new JLabel("점드립 추출방식이며, 물방울을 한 방울씩 떨어뜨리는방식");
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
		new Gonoview(500, 500, "고노드리퍼").setVisible(true);

	}

}