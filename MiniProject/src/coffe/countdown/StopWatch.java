package coffe.countdown;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class StopWatch implements ActionListener {
	
	JButton startButton = new JButton("시작");
	JButton resetButton = new JButton("초기화");
	JLabel timeLabel = new JLabel();
	int elapsedTime = 0;
	int seconds = 0;
	int minutes = 0;
	int hours = 0;
	boolean started = false;
	String seconds_string = String.format("%02d", seconds);
	String minutes_string = String.format("%02d", minutes);
	String hours_string = String.format("%02d", hours);
	JPanel panelContainer;
	
	//타이머 메소드 호출
	Timer timer = new Timer(1000, new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
		
			elapsedTime += 1000;
			hours = (elapsedTime/3600000);
			minutes = (elapsedTime/60000) % 60;
			seconds = (elapsedTime/1000) % 60;
			seconds_string = String.format("%02d", seconds);
			minutes_string = String.format("%02d", minutes);
			hours_string = String.format("%02d", hours);
			timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
			
		}
	});
	
	public JPanel StopWatch() {
		
		//배경 설정
		ImageIcon back = new ImageIcon("coffe.jpg");

		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(back.getImage(), 0, 0, null);
			}
		};
		
		//시간 출력분 설정
		timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
		timeLabel.setBounds(100, 100, 300, 100);
		timeLabel.setFont(new Font("맑은 고딕", Font.BOLD, 55));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		//시작 버튼 설정
		startButton.setBounds(135, 300, 100, 45);
		startButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		startButton.setFocusable(false);
		startButton.addActionListener(this);
		startButton.setBackground(new Color(255, 217, 180));
		
		//리셋버튼 설정
		resetButton.setBounds(255, 300, 100, 45);
		resetButton.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		resetButton.setBackground(new Color(255, 217, 180));
				
		//패널에 입력		
		panel.setLayout(null);
		panel.add(startButton);
		panel.add(resetButton);
		panel.add(timeLabel);
		
		
		return panel;
	}
	
	
	//액션 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		//시작, 중지 버튼 설정
		if((e.getSource() == startButton)) {
			start();
			if(started == false) {
				started = true;
				startButton.setText("중지");
				start();
			
			} else {
				started = false;
				startButton.setText("시작");
				stop();
			}
		}
		
		//초기화버튼 설정
		if(e.getSource() == resetButton) {
			started = false;
			startButton.setText("시작");
			reset();
		}
		
	}
	//시작 버튼 시 불러올 메소드
	void start() {
		timer.start();
	}
	//종료 버튼 시 불러올 메소드
	void stop() {
		timer.stop();
		
	}
	//초기화 메소드 설정
	void reset() {
		timer.stop();
		elapsedTime = 0;
		seconds = 0;
		minutes = 0;
		hours = 0;
		seconds_string = String.format("%02d", seconds);
		minutes_string = String.format("%02d", minutes);
		hours_string = String.format("%02d", hours);
		timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
	}
}
