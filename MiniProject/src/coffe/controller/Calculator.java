package coffe.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import util.MyUtil;

public class Calculator extends JFrame {

	JTextField inputWater;
	JTextField inputBean;
	JTextArea textArea;
	JTextField extract;

	public JPanel Calculator() {
		
		//배경 입력
		ImageIcon back = new ImageIcon("coffe.jpg");

		setLayout(null);

		// 배경패널
		JPanel backPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(back.getImage(), 0, 0, null);
			}
		};
		
		//패널의 크기 및 레이아웃 지정
		backPanel.setBounds(0, 0, 500, 500);
		backPanel.setLayout(null);

		// 계산 패널
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 500, 250);
		panel.setLayout(null);
		panel.setOpaque(false);

		// 물 라벨
		JLabel waterLabel = new JLabel();
		waterLabel.setText("물   (ml)");
		waterLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		waterLabel.setBounds(10, 10, 100, 50);
		panel.add(waterLabel);

		// 콩 라벨
		JLabel beanLabel = new JLabel();
		beanLabel.setText("커피 (g)");
		beanLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		beanLabel.setBounds(10, 70, 100, 50);
		panel.add(beanLabel);

		// 비율 라벨
		JLabel extractLabel = new JLabel();
		extractLabel.setText("비율 (ml/g) ");
		extractLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		extractLabel.setBounds(10, 140, 100, 50);
		panel.add(extractLabel);

		// 물의 양 입력
		inputWater = new JTextField();
		// 커피원두의 양 입력
		inputBean = new JTextField();
		// 비율 출력칸
		extract = new JTextField();
		
		//텍스트필드의 크기 및 위치
		inputWater.setBounds(120, 20, 250, 35);
		inputBean.setBounds(120, 80, 250, 35);
		extract.setBounds(120, 150, 250, 35);
		extract.setHorizontalAlignment(JTextField.CENTER);
		extract.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		//계산 버튼 설정
		JButton printBtn = new JButton("계산");
		printBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		printBtn.setBackground(new Color(255, 217, 180));
		printBtn.setBounds(380, 140, 100, 50);
		printBtn.setFocusable(false);

		// 버튼 입력 시 텍스트 에어리어에 출력
		printBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == printBtn) {
					//비어있을 시 메시지창 출력
					if (inputWater.getText().equals("") || inputBean.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "칸이 비었습니다.");
					} else {
						//입력 값을 변환
						double waterLiter = Double.parseDouble((inputWater.getText()));
						double beanGram = Double.parseDouble((inputBean.getText()));

						Controller c = new Controller();
						//계산 메소드 호출 후 필드에 출력
						extract.setText(c.calCoffee(waterLiter, beanGram));
						
						double extraction = Double.parseDouble(c.calCoffee(waterLiter, beanGram));
						//계산후 출력 메소드를 통해 텍스트에어리어에 입력
						if (extraction >= 15 && extraction <= 20) {
							textArea.append(c.printCoffee(waterLiter, beanGram));
						} else if (extraction > 20) {
							textArea.append(c.printCoffee(waterLiter, beanGram));
						} else if (extraction < 15) {
							textArea.append(c.printCoffee(waterLiter, beanGram));
						}

					}

				}

			}
		});

		// 출력 패널
		JPanel panel2 = new JPanel();
		panel2.setLayout(null);
		panel2.setBounds(0, 250, 500, 300);
		panel2.setOpaque(false);

		//텍스트에어리어 설정
		textArea = new JTextArea();
		textArea.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		textArea.setBounds(120, 10, 250, 180);

		// 지우기 버튼
		JButton eraseBtn = new JButton("초기화");
		eraseBtn.setBounds(380, 10, 100, 50);
		eraseBtn.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		eraseBtn.setBackground(new Color(255, 217, 180));
		eraseBtn.setFocusable(false);

		// 버튼 누를 시 지우기
		eraseBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (e.getSource() == eraseBtn) {
					//모두 초기화
					inputWater.setText("");
					inputBean.setText("");
					extract.setText("");
					textArea.setText("");
				}

			}
		});
		
		//각 컴포넌트 패널에 입력
		panel.add(extract);
		panel.add(printBtn);
		panel.add(inputBean);
		panel.add(inputWater);
		panel2.add(textArea);
		panel2.add(eraseBtn);
		backPanel.add(panel);
		backPanel.add(panel2);
		
		//메인 패널로 리턴
		return backPanel;

	}

}
