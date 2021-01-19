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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import util.MyUtil;

public class View {

	public JPanel View() {
						
			ImagePanel panel = new ImagePanel("coffe.jpg");
		
			JButton bt1 = new JButton("***메뉴입력***"); // 갈색 메뉴판 버튼 패널 변경
			JButton bt2 = new JButton("칼리다 핸드드립"); // 아메리카노 이미지
			JButton bt3 = new JButton("멜리타 핸드드립"); // 에스프레레소 이미지
			JButton bt4 = new JButton("고노 핸드드립"); //
			JButton bt5 = new JButton("하리오 핸드드립");
									
			
			panel.setLayout(null);		// 배경패널
			panel.add(bt1);
			panel.add(bt2);
			panel.add(bt3);
			panel.add(bt4);
			panel.add(bt5);
			
			// add 사용
			bt1.setBounds(10, 5, 150, 50);
			bt2.setBounds(10, 47, 150, 50);
			bt3.setBounds(10, 90, 150, 50);
			bt4.setBounds(10, 130, 150, 50);
			bt5.setBounds(10, 170, 150, 50);
		
			// 위치 설정
			bt1.setFocusable(false);
			bt2.setFocusable(false);
			bt3.setFocusable(false);
			bt4.setFocusable(false);
			bt5.setFocusable(false);
			
			// 폰트설정
			bt1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			bt2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			bt3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			bt4.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			bt5.setFont(new Font("맑은 고딕", Font.BOLD, 14));
			
			
			// Color 버튼 색깔 위치 설정
			Color co1 = new Color(192, 127, 90);
			Color co2 = new Color(255, 217, 180);
						
			bt1.setBackground(co1);
			bt2.setBackground(co2);
			bt3.setBackground(co2);
			bt4.setBackground(co2);
			bt5.setBackground(co2);
			
			bt2.addActionListener(new ActionListener() { // 새창 열기 버튼 구간
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "칼리타 드리퍼");
					new Kalview(500, 500, "kalview").setVisible(true);
				}
			});
			
			bt3.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "멜리타 드리퍼");
					new Melitaview(500, 500, "Melitaview").setVisible(true);
				}
			});
			
			bt4.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "고노 드리퍼 ");
					new Gonoview(500, 500, "gonoview").setVisible(true);
				}
			});
			
			bt5.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null, "하리오 드리퍼");
					new Harioview(500, 500, "Harioview").setVisible(true);
				}
			});
			
			return panel;
		}

		public class ImagePanel extends JPanel {
			private BufferedImage image;
			private int w;
			private int h;
			protected JFrame f;

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

		
	}

