package coffe.countdown;

import java.awt.*;
import static java.awt.Frame.MAXIMIZED_BOTH;

import javax.swing.*;



import java.awt.event.*;

public class CountDown extends JFrame implements ActionListener {

	private int hour;
	private int minute;
	private int second;
	private JLabel displayTimeLabel;
	private long watchStart;
	private Timer theChronometer;
	private long pausedTime;
	private boolean paused = false;
	private JButton activateTimerButton;
	int startHour, startMin, startSec;
	int elapsedTime;
	int hours;
	int minutes;
	int seconds;


	public JPanel CountDown() {

		//패널 설정
		setLayout(null);
		setSize(500, 500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("카운트 다운");
	
		//배경이미지
		ImageIcon back = new ImageIcon("coffe.jpg");
		
		JPanel backpanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(back.getImage(), 0, 0, null);
			}
		};
		
		//배경이미지 설정
		backpanel.setLayout(null);
		backpanel.setBounds(0, 0, 500, 500);
		
		//font 설정
		Font largeFontBOLD = new Font("맑은 고딕", Font.BOLD, 20);
		Font largeFontPLAIN = new Font("맑은 고딕", Font.BOLD, 55);
		
		//버튼 패널 설정
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		JPanel controlButtonPanel = new JPanel();
		controlButtonPanel.setLayout(new FlowLayout());
		
		//버튼 설정
		activateTimerButton = new JButton("시작");// 
		activateTimerButton.setBackground(new Color(255, 217, 180));
		JButton stopTimerButton = new JButton("중지");
		stopTimerButton.setBackground(new Color(255, 217, 180));
		JButton pauseTimerButton = new JButton("일시정지");
		pauseTimerButton.setBackground(new Color(255, 217, 180));
		JButton minPlusButton = new JButton("+1분");
		minPlusButton.setBackground(new Color(255, 217, 180));
		JButton minMinusButton = new JButton("-1분");
		minMinusButton.setBackground(new Color(255, 217, 180));
		
		//미구현
//		JButton secondButton = new JButton("+1초");
//		JButton secminusButton = new JButton("-1초");

		//액션리스너 설정
		minPlusButton.addActionListener(this);
		minMinusButton.addActionListener(this);
		activateTimerButton.addActionListener(this);
		stopTimerButton.addActionListener(this);
		pauseTimerButton.addActionListener(this);
		
		//시간라벨 설정
		displayTimeLabel = new JLabel("00:00:00");
		displayTimeLabel.setHorizontalAlignment(JLabel.CENTER);
		displayTimeLabel.setFont(largeFontPLAIN);
		displayTimeLabel.setBounds(100, 100, 300, 100);
		displayTimeLabel.setOpaque(true);
		
		//폰트지정
		activateTimerButton.setFont(largeFontBOLD);
		minMinusButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		minPlusButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		stopTimerButton.setFont(largeFontBOLD);
		pauseTimerButton.setFont(largeFontBOLD);
	
		//조절 버튼 패널에 버튼 추가
		controlButtonPanel.add(minPlusButton);
		controlButtonPanel.add(minMinusButton);
		
		//조절 버튼 패널 설정
		controlButtonPanel.setBounds(0, 300, 500, 50);
		controlButtonPanel.setOpaque(false);
		
		//버튼 패널에 버튼 추가
		buttonPanel.add(activateTimerButton);
		buttonPanel.add(stopTimerButton);
		buttonPanel.add(pauseTimerButton);
		
		//버튼 패널 설정
		buttonPanel.setBounds(0, 400, 500, 100);
		buttonPanel.setOpaque(false);
					
		//백패널에 패널 추가
		backpanel.add(controlButtonPanel);
		backpanel.add(displayTimeLabel);
		backpanel.add(buttonPanel);
		
		//타이머 메소드
		theChronometer = new Timer(1, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//시간 계산
				seconds = (int) (System.currentTimeMillis() - watchStart) / 1000;
				int days = seconds / 86400;
				int hours = (seconds / 3600) - (days * 24);
				int min = (seconds / 60) - (days * 1440) - (hours * 60);
				int sec = seconds % 60;
								
				String stop = String.format("%02d:%02d:%02d", 0, 0, 0);
				
				//시간 정지 
				if (displayTimeLabel.getText().equals(stop)) {
					//String s = String.format("%02d:%02d:%02d", 0, 0, 0);
					theChronometer.stop();
					//displayTimeLabel.setText(s);
					
				} else {
					
					String s = String.format("%02d:%02d:%02d", startHour - hours,
							(((startMin >= 1) ? (startMin - 1) : startMin) - min),
							((startSec == 0) ? startSec = 59 : startSec) - sec);
					displayTimeLabel.setText(s);
				}

			}
		});
		return backpanel;
	}

	public void actionPerformed(ActionEvent e) {
		
		//중지 버튼 입력시 초기화
		if (e.getActionCommand().equals("중지")) {
			theChronometer.stop();
			elapsedTime = 0;
			hour = 0;
			startMin = 0;
			minutes = 0;
			startSec = 0;
			second = 0;
			String s = String.format("%02d:%02d:%02d", hour, minute, second);

			displayTimeLabel.setText(s);

		}
		//시작 버튼 설정과, 재시작 버튼 설정
		else if (e.getActionCommand().equals("시작") || e.getActionCommand().equals("재시작")) {
			if (!paused) {
				watchStart = System.currentTimeMillis();
				theChronometer.start();
			} else {
				watchStart = System.currentTimeMillis() + pausedTime;
				pausedTime = 0;
				theChronometer.start();
				paused = false;
				activateTimerButton.setText("시작");
			}
		}
		//일시정지 설정
		else if (e.getActionCommand().equals("일시정지")) {
			long now = System.currentTimeMillis();
			pausedTime -= (now - watchStart);
			theChronometer.stop();
			paused = true;
			activateTimerButton.setText("재시작");
		}
		
		//1분 추가 설정
		if (e.getActionCommand().equals("+1분")) {
			// startHour = 0;
			startMin += 1;
			// startSec = 0;
			String s = String.format("%02d:%02d:%02d", startHour, startMin,
					((startSec == 0) ? startSec = 0 : startSec));

			displayTimeLabel.setText(s);

		}
		//1분 감소 설정
		if (e.getActionCommand().equals("-1분")) {
			if (startMin > 0) {// startHour = 0;
				startMin -= 1;
				// startSec = 0;
				String s = String.format("%02d:%02d:%02d", startHour, startMin,
						((startSec == 0) ? startSec = 0 : startSec));
				displayTimeLabel.setText(s);
				
			//초와 분이 0일시 감소 설정 방지
			} else {
				startMin = 0;
				startSec = 0;
				String s = String.format("%02d:%02d:%02d", startHour, startMin,
						((startSec == 0) ? startSec = 0 : startSec));
				displayTimeLabel.setText(s);
			}
		}
		
		
		//미구현 기능 
//		if (e.getActionCommand().equals("+1초")) {
//			// startHour = 0;
//			//startMin = 0;
//			startSec += 1;
//			String s = String.format("%02d:%02d:%02d", startHour, startMin,
//					startSec);
//
//			displayTimeLabel.setText(s);
//
//		}
//		if (e.getActionCommand().equals("-1초")) {
//			if (startSec > 0) {// startHour = 0;
//				//startMin -= 1;
//				startSec -= 1;
//				String s = String.format("%02d:%02d:%02d", startHour, startMin,
//						((startSec == 0) ? startSec = 0 : startSec));
//				displayTimeLabel.setText(s);
//				
//			} else {
//				startMin = 0;
//				startSec = 0;
//				String s = String.format("%02d:%02d:%02d", startHour, startMin,
//						((startSec == 0) ? startSec = 0 : startSec));
//				displayTimeLabel.setText(s);
//			}
//		}
	}
}