package coffe.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import coffe.choice.BeanChoice;
import coffe.controller.Calculator;
import coffe.countdown.CountDown;
import coffe.countdown.StopWatch;
import coffe.io.CoffeeNote;


public class MainMenu extends JFrame {

	private JPanel jPanel1;
	private JButton homeBtn;
	private JPanel panelContainer;
	private JButton changeCount;

	public MainMenu() {
		
		setTitle("핸드드립커피");
		initComponents();
		setLocationRelativeTo(null);
		
		//패널에 패널 추가
		panelContainer.add(mainPanel(), "");
		panelContainer.add(new View().View(), "view");
		panelContainer.add(new Calculator().Calculator(), "calculator");
		panelContainer.add(new StopWatch().StopWatch(), "stopwatch");
		panelContainer.add(new CountDown().CountDown(), "countdown");
		panelContainer.add(new CoffeeNote().CoffeeNote(), "note");
		panelContainer.add(new BeanChoice().BeanChoice(), "find");
				

	}
	
	//밑 버튼 패널
	private void initComponents() {

		jPanel1 = new JPanel();
		homeBtn = new JButton();
		panelContainer = new JPanel();
		changeCount = new JButton();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		jPanel1.setBackground(Color.WHITE);
		
		//홈버튼 설정
		homeBtn.setIcon(new ImageIcon("homeicon.png"));
		homeBtn.setFocusable(false);
		homeBtn.setBackground(new Color(255, 217, 180));
			
		//패널의 크기 및 레이아웃 지정
		panelContainer.setPreferredSize(new Dimension(500, 500));
		panelContainer.setLayout(new CardLayout());
		
		//홈버튼 추가
		jPanel1.setOpaque(true);
		jPanel1.add(homeBtn);
		
		//스톱워치, 타이머 교환 버튼 추가 및 설정
		changeCount.setText("타이머");
		changeCount.setFocusable(false);
		changeCount.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		changeCount.setBackground(new Color(255, 217, 180));
		
		//교환버튼은 보이지 않은 채로 추가
		jPanel1.add(changeCount).setVisible(false);

		getContentPane().add(jPanel1, BorderLayout.PAGE_END);
		getContentPane().add(panelContainer, BorderLayout.CENTER);

		//홈버튼 클릭 시 액션
		homeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				CardLayout cardLayout = (CardLayout) panelContainer.getLayout();
				cardLayout.first(panelContainer);
				changeCount.setVisible(false);
		
				
			}
		});
		
		changeCount.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panelContainer.getLayout();
				if (changeCount.getText().equals("타이머")) {
					cardLayout.show(panelContainer, "countdown");
					changeCount.setText("스톱워치");
				} else if (changeCount.getText().equals("스톱워치")) {
					cardLayout.show(panelContainer, "stopwatch");
					changeCount.setText("타이머");
				}
			}
		});

		pack();
	}

	//메인 패널
	public JPanel mainPanel() {
		
		
		ImageIcon back = new ImageIcon("coffe.jpg");
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(back.getImage(), 0, 0, null);
			}
		};
		
		JButton bt1 = new JButton("핸드드립의 종류"); // 갈색 메뉴판 버튼 패널 변경
		JButton bt2 = new JButton("비율 계산기"); // 아메리카노 이미지
		JButton bt3 = new JButton("스톱워치/타이머"); // 에스프레레소 이미지
		JButton bt4 = new JButton("나의 커피 기록"); //
		JButton bt5 = new JButton("나의 원두 찾기"); //
		
		panel.setLayout(null); // 배경패널
		
		panel.add(bt1);
		panel.add(bt2);
		panel.add(bt3);
		panel.add(bt4);
		panel.add(bt5);

		bt1.setBounds(125, 40, 250, 50);
		bt2.setBounds(125, 120, 250, 50);
		bt3.setBounds(125, 200, 250, 50);
		bt4.setBounds(125, 280, 250, 50);
		bt5.setBounds(125, 360, 250, 50);

		bt1.setFocusable(false);
		bt2.setFocusable(false);
		bt3.setFocusable(false);
		bt4.setFocusable(false);
		bt5.setFocusable(false);

		bt1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		bt2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		bt3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		bt4.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		bt5.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		Color co1 = new Color(255, 217, 180);
	
		bt1.setBackground(co1);
		bt2.setBackground(co1);
		bt3.setBackground(co1);
		bt4.setBackground(co1);
		bt5.setBackground(co1);
		
		bt1.setIcon(new ImageIcon(getClass().getResource("/image/dripper.png")));
		bt2.setIcon(new ImageIcon(getClass().getResource("/image/calculator.png")));
		bt3.setIcon(new ImageIcon(getClass().getResource("/image/stopwatch.png")));
		bt4.setIcon(new ImageIcon(getClass().getResource("/image/note.png")));
		bt5.setIcon(new ImageIcon(getClass().getResource("/image/bean.png")));
		
		//드립 종류 메뉴
		bt1.addActionListener(new ActionListener() { 
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panelContainer.getLayout();
				cardLayout.show(panelContainer, "view");
			}
		});
		
		//비율 계산기
		bt2.addActionListener(new ActionListener() { // 새창 열기 버튼 구간
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panelContainer.getLayout();
				cardLayout.show(panelContainer, "calculator");
			}
		});
		
		//스톱워치/타이머 
		bt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panelContainer.getLayout();
				cardLayout.show(panelContainer, "stopwatch");
				changeCount.setVisible(true);
				
			}
		});
		
		//노트 
		bt4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panelContainer.getLayout();
				cardLayout.show(panelContainer, "note");
			}

		});
		//원두 찾기
		bt5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CardLayout cardLayout = (CardLayout) panelContainer.getLayout();
				cardLayout.show(panelContainer, "find");
			}

		});

		return panel;

	}


}