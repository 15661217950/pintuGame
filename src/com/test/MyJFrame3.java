package com.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyJFrame3 extends JFrame implements KeyListener {
	public MyJFrame3() {
		this.setSize(488, 500);
		this.setTitle("测试 2");
		Image image = Toolkit.getDefaultToolkit().getImage("logo/拼图.png");
		this.setIconImage(image);
		this.setAlwaysOnTop(true);
		this.setLocationRelativeTo(null);
		this.setLayout(null);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		this.addKeyListener(this);
		this.setVisible(true);
	}


	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
//		System.out.println("按下");
	}

	@Override
	public void keyReleased(KeyEvent e) {
//
		 Object source =e.getKeyCode();
		 if(source.equals(65)){
			 System.out.println("当前是A");
		 }else if(source.equals(66)){
			 System.out.println("当前是B");
		 }
	}

}
