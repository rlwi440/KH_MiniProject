package coffe.choice;


import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class BeanChoice {

	JLabel flavorLabel;
	JLabel acidityLabel;
	JLabel bitterLabel;
	JPanel backPanel;

	public JPanel BeanChoice() {

		ImageIcon back = new ImageIcon("coffe.jpg");

		// 배경패널
		backPanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(back.getImage(), 0, 0, null);
			}
		};

		backPanel.setLayout(null);
		backPanel.setBounds(0, 0, 500, 500);
		// 향 선택
		topPanel();
		flavorPanel();
		// 산미 선택
		middlePanel();
		acidPanel();
		// 쓴맛 선택
		bottomPanel();
		bitterPanel();
		// 결과 패널
		resultPanel();

		return backPanel;
	}

	// 상위 패널
	private void topPanel() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("향을 선택하세요");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel.add(label);
		panel.setBounds(140, 10, 200, 50);
		panel.setOpaque(true);
		backPanel.add(panel);

	}
	//향 선택 패널
	private void flavorPanel() {

		JPanel panel = new JPanel();
		JRadioButton small1 = new JRadioButton("약");
		JRadioButton medium1 = new JRadioButton("중");
		JRadioButton large1 = new JRadioButton("강");

		ButtonGroup group = new ButtonGroup();
		group.add(small1);
		group.add(medium1);
		group.add(large1);

		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == small1) {
					flavorLabel.setText("도미니카 AA");
				} else if (e.getSource() == medium1) {
					flavorLabel.setText("코스타리카 SHB");
				} else if (e.getSource() == large1) {
					flavorLabel.setText("콜롬비아 슈프리모");
				}

			}
		};

		small1.addActionListener(listener);
		medium1.addActionListener(listener);
		large1.addActionListener(listener);

		panel.add(small1);
		panel.add(medium1);
		panel.add(large1);
		panel.setBounds(140, 60, 200, 50);

		backPanel.add(panel);

	}
	
	//중간 패널
	private void middlePanel() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("산미를 선택하세요");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel.add(label);
		panel.setBounds(140, 130, 200, 50);
		panel.setOpaque(true);
		backPanel.add(panel);

	}
	//산도 선택 패널
	private void acidPanel() {

		JPanel panel = new JPanel();
		JRadioButton small = new JRadioButton("약");
		JRadioButton medium = new JRadioButton("중");
		JRadioButton large = new JRadioButton("강");

	
		ButtonGroup group = new ButtonGroup();
		group.add(small);
		group.add(medium);
		group.add(large);

		
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == small) {
					acidityLabel.setText("인도네시아 만델링");
				} else if (e.getSource() == medium) {
					acidityLabel.setText("엘살바도르 펜시SHB");
				} else if (e.getSource() == large) {
					acidityLabel.setText("에디오피아 예가체프");
				}

			}
		};
		
		small.addActionListener(listener);
		medium.addActionListener(listener);
		large.addActionListener(listener);

		panel.add(small);
		panel.add(medium);
		panel.add(large);
		panel.setBounds(140, 180, 200, 50);

		backPanel.add(panel);

	}
	
	//마지막 패널
	private void bottomPanel() {
		JPanel panel = new JPanel();
		JLabel label = new JLabel("쓴맛을 선택하세요");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		panel.add(label);
		panel.setBounds(140, 250, 200, 50);
		panel.setOpaque(true);
		backPanel.add(panel);

	}
	//쓴맛 선택 패널
	private void bitterPanel() {

		JPanel panel = new JPanel();
		JRadioButton small = new JRadioButton("약");
		JRadioButton medium = new JRadioButton("중");
		JRadioButton large = new JRadioButton("강");

		// 그루핑
		ButtonGroup group = new ButtonGroup();
		group.add(small);
		group.add(medium);
		group.add(large);

		// 선택 시 출력
		ActionListener listener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == small) {
					bitterLabel.setText("브라질 산토스");
				} else if (e.getSource() == medium) {
					bitterLabel.setText("니카라과 SHB");
				} else if (e.getSource() == large) {
					bitterLabel.setText("말라위 AAA+");
				}
			}
		};
		// 다 같은 메소드가 호출되도록
		small.addActionListener(listener);
		medium.addActionListener(listener);
		large.addActionListener(listener);

		panel.add(small);
		panel.add(medium);
		panel.add(large);
		panel.setBounds(140, 300, 200, 50);

		backPanel.add(panel);

	}

	
	private void resultPanel() {

		
		JPanel titlePanel = new JPanel();
		JLabel label = new JLabel("선택 결과 (향, 산미, 쓴맛 순)");
		label.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		titlePanel.add(label);
		titlePanel.setBounds(140, 370, 200, 30);
		
		JPanel panel = new JPanel();

		flavorLabel = new JLabel();
		acidityLabel = new JLabel();
		bitterLabel = new JLabel();
		
		flavorLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		acidityLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		bitterLabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));

		panel.setOpaque(true);
		panel.setBounds(140, 400, 200, 80);
		panel.add(flavorLabel);
		panel.add(acidityLabel);
		panel.add(bitterLabel);
		
		backPanel.add(titlePanel);
		backPanel.add(panel);

	}

}
