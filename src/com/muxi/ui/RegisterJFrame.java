package com.muxi.ui;

import javax.swing.*;
import java.awt.*;

public class RegisterJFrame extends JFrame {
	public RegisterJFrame() {
		this.setSize(488, 500);
		Image ic = Toolkit.getDefaultToolkit().getImage("puzzlegame/logo/拼图.png");  //更换图标
		this.setIconImage(ic);
		this.setTitle("拼图游戏-注册");
		this.setAlwaysOnTop(true);    //置顶
		this.setLocationRelativeTo(null);   //页面居中
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  //关闭方式
		this.setVisible(true);
	}
}
