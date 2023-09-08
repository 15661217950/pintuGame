package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame2 extends JFrame implements MouseListener {
	public MyJFrame2() {
		this.setSize(488, 500);
		this.setTitle("测试 2");
		Image image = Toolkit.getDefaultToolkit().getImage("logo/拼图.png");
		this.setIconImage(image);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


		JButton jbt1 = new JButton("按钮");
		jbt1.setBounds(0, 0, 75, 30);
		jbt1.addMouseListener(this);
		this.getContentPane().add(jbt1);
		this.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println("单击");
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("按下");
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("释放");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("划入");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println("划出");
	}
}
