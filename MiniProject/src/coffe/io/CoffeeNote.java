package coffe.io;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import coffe.model.vo.Manager;

public class CoffeeNote {
	
	File f = new File("coffeeList.txt");

	public JPanel CoffeeNote() {

		ImageIcon back = new ImageIcon("coffe.jpg");

		JPanel jpanel = new JPanel() {
			public void paintComponent(Graphics g) {
				g.drawImage(back.getImage(), 0, 0, null);
			}
		};

		jpanel.setLayout(null);
		
		// 입력 공간
		JTextField tf = new JTextField();
		tf.setSize(300, 30);
		tf.setLocation(20, 20);

		jpanel.add(tf);
		// 입력한 글이 보이는 창
		JTextArea ta = new JTextArea();
		JScrollPane jsp = new JScrollPane(ta);
		// 창 스크롤
		jsp.setSize(300, 200);
		jsp.setLocation(20, 60);
		jpanel.add(jsp);
		// 제일 처음에 보이는 글씨
		ta.setText("입력(ex) : 커피이름/물양/커피양/시간(분)" + "\n" + "☆검색 / 수정 / 삭제 시 이름 입력☆" + "\n");
		// 입력 버튼
		JButton btn1 = new JButton("입력");
		jpanel.add(btn1);
		btn1.setBounds(360, 20, 100, 30);
		btn1.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btn1.setBackground(new Color(255, 217, 180));

		// 출력 버튼
		JButton btn2 = new JButton("출력");
		jpanel.add(btn2);
		btn2.setBounds(360, 60, 100, 30);
		btn2.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btn2.setBackground(new Color(255, 217, 180));
		
		// 불러오기 버튼
		JButton btn3 = new JButton("불러오기");
		jpanel.add(btn3);
		btn3.setBounds(360, 100, 100, 30);
		btn3.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btn3.setBackground(new Color(255, 217, 180));

		// 검색 버튼
		JButton btn4 = new JButton("검색");
		jpanel.add(btn4);
		btn4.setBounds(360, 140, 100, 30);
		btn4.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btn4.setBackground(new Color(255, 217, 180));
		
		// 수정 버튼
		JButton btn5 = new JButton("수정");
		jpanel.add(btn5);
		btn5.setBounds(360, 180, 100, 30);
		btn5.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btn5.setBackground(new Color(255, 217, 180));

		// 삭제 버튼
		JButton btn6 = new JButton("삭제");
		jpanel.add(btn6);
		btn6.setBounds(360, 220, 100, 30);
		btn6.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btn6.setBackground(new Color(255, 217, 180));
			
		ArrayList<Manager> list = new ArrayList<Manager>();
		// ArrayList 선언
		// 입력 버튼 이벤트
		btn1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 한명씩 입력
				// 공백을 기준으로 내용을 나눔
				String[] temp = tf.getText().split("/");
				// 배열에 저장
				int water = Integer.parseInt(temp[1]);
				int bean = Integer.parseInt(temp[2]);
				int time = Integer.parseInt(temp[3]);
				list.add(new Manager(temp[0], water, bean, time));
				ta.append(tf.getText() + "\n");
			}
		});
		
		
		
		// 출력 버튼 이벤트
		btn2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// 전체 출력
				for (int i = 0; i < list.size(); i++) {
					ta.append(list.get(i).toString());

					List<Manager> sublist = new ArrayList<>();
					sublist.addAll(list);
					
					try (BufferedWriter bw = new BufferedWriter(new FileWriter(f));) {

						for (Manager m : list)
							bw.write(m + "\n");

					} catch (Exception e) {
						e.printStackTrace();
					}

				}

			}
		});

		// 불러오기
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try (BufferedReader br = new BufferedReader(new FileReader(f));) {

					String data = null;

					while ((data = br.readLine()) != null) {

						ta.append(data + "\n");

					}
				} catch (IOException e) {

					e.printStackTrace();
				}

			}
		});

		// 검색 버튼 이벤트
		btn4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				String name = tf.getText();// TextField.getText()
				Iterator<Manager> it = list.iterator();
				while (it.hasNext()) {
					Manager temp = it.next();
					// 이름으로 검색
					if (temp.getCoffeName().equals(name)) {
						ta.setText(temp.toString() + "\n");
						// 한명 출력 후 다음줄로 넘어감
					}
				}
			}
		});
		
		// 수정 버튼 이벤트
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String[] name1 = tf.getText().split("/");
				int water = Integer.parseInt(name1[1]);
				int bean = Integer.parseInt(name1[2]);
				int time = Integer.parseInt(name1[3]);
				Iterator<Manager> it1 = list.iterator();

				while (it1.hasNext()) {
					Manager temp = it1.next();
					// 이름 검색하여 수정할 내용 입력
					if (temp.getCoffeName().equals(name1[0])) {
						temp.setWater(water);
						temp.setBean(bean);
						temp.setTime(time);
					}
				}
			}
		});
		
		// 삭제 버튼 이벤트
		btn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				int num = 0;
				String name2 = tf.getText();
				Iterator<Manager> it2 = list.iterator();
				while (it2.hasNext()) {
					Manager temp = it2.next();
					// 이름 검색해서 삭제
					if (temp.getCoffeName().equals(name2)) {
						list.remove(num);
					}
					num++;
				}
			}
		});

		
		return jpanel;
	}
}