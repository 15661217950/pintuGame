package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {
	JButton jbt1 = new JButton("按钮1");
	JButton jbt2 = new JButton("按钮2");

	public MyJFrame() {
		this.setSize(488, 500);
		this.setTitle("测试游戏 v1.0");
		Image icon = Toolkit.getDefaultToolkit().getImage("logo\\拼图.png");
		this.setIconImage(icon);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);




//		jbt1.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("点我呀");
//			}
//		});
		jbt1.setBounds(0, 0, 75, 30);
		jbt2.setBounds(75, 0, 75, 30);
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		this.getContentPane().add(jbt1);
		this.getContentPane().add(jbt2);


		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == jbt1) {
			jbt1.setSize(100, 50);
		} else if (source == jbt2) {
			Random r = new Random();
			jbt2.setLocation(r.nextInt(300), r.nextInt(400));
		} else {
			System.out.println("没有按钮点击");
		}
	}
}
