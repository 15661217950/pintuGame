package com.muxi.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class LoginJFrame extends JFrame implements MouseListener {
	//创建一个集合存储正确的用户名和密码
	static ArrayList<User> list = new ArrayList<>();

	static {
		list.add(new User("zhangsan", "123456"));
		list.add(new User("lisi", "123456"));
	}

	JTextField username = new JTextField();
	JTextField password = new JTextField();
	JLabel rightCode = new JLabel();
	String codeStr = CodeUtil.getCode();
	JTextField code = new JTextField();
	JButton login = new JButton();


	public LoginJFrame() {
		//初始化界面
		initJFrame();

		//在这个界面中添加内容
		initView();

		//让当前界面显示出来
		this.setVisible(true);
	}

	//创建一个集合存储正确的用户名和密码
	public void initView() {
		//1. 添加用户名文字
		JLabel usernameText = new JLabel(new ImageIcon("image\\login\\用户名.png"));
		usernameText.setBounds(116, 135, 47, 17);
		this.getContentPane().add(usernameText);

		//2.添加用户名输入框
		username.setBounds(195, 134, 200, 30);
		this.getContentPane().add(username);

		//3.添加密码文字
		JLabel passwordText = new JLabel(new ImageIcon("image\\login\\密码.png"));
		passwordText.setBounds(130, 195, 32, 16);
		this.getContentPane().add(passwordText);

		//4.密码输入框

		password.setBounds(195, 195, 200, 30);
		this.getContentPane().add(password);

		//验证码提示
		JLabel codeText = new JLabel(new ImageIcon("image\\login\\验证码.png"));
		codeText.setBounds(133, 256, 50, 30);
		this.getContentPane().add(codeText);

		//验证码的输入框
		code.setBounds(195, 256, 100, 30);
		this.getContentPane().add(code);
		//设置内容
		rightCode.setText(codeStr);
		//位置和宽高
		rightCode.setBounds(300, 256, 50, 30);
		//添加到界面
		rightCode.addMouseListener(this);
		this.getContentPane().add(rightCode);
		//5.添加登录按钮

		login.setBounds(123, 310, 128, 47);
		login.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
		//去除按钮的默认边框
		login.setBorderPainted(false);
		//去除按钮的默认背景
		login.setContentAreaFilled(false);
		login.addMouseListener(this);
		this.getContentPane().add(login);

		//6.添加注册按钮
		JButton register = new JButton();
		register.setBounds(256, 310, 128, 47);
		register.setIcon(new ImageIcon("image\\login\\注册按钮.png"));
		//去除按钮的默认边框
		register.setBorderPainted(false);
		//去除按钮的默认背景
		register.setContentAreaFilled(false);
		this.getContentPane().add(register);

		//7.添加背景图片
		JLabel background = new JLabel(new ImageIcon("image\\login\\background.png"));
		background.setBounds(0, 0, 470, 390);
		this.getContentPane().add(background);

	}

	public void initJFrame() {
		this.setSize(488, 430);//设置宽高
		Image ic = Toolkit.getDefaultToolkit().getImage("logo/拼图.png");  //更换图标
		this.setIconImage(ic);
		this.setTitle("拼图游戏 V1.0登录");//设置标题
		this.setDefaultCloseOperation(3);//设置关闭模式
		this.setLocationRelativeTo(null);//居中
		this.setAlwaysOnTop(true);//置顶
		this.setLayout(null);//取消内部默认布局
	}


	//要展示用户名或密码错误
	public void showJDialog(String content) {
		//创建一个弹框对象
		JDialog jDialog = new JDialog();
		Image icLogo = Toolkit.getDefaultToolkit().getImage("logo/拼图.png");  //更换图标
		jDialog.setIconImage(icLogo);
		jDialog.setTitle("提示：");
		//给弹框设置大小
		jDialog.setSize(200, 80);
		//让弹框置顶
		jDialog.setAlwaysOnTop(true);
		//让弹框居中
		jDialog.setLocationRelativeTo(null);
		jDialog.setLayout(null);
		//弹框不关闭永远无法操作下面的界面
		jDialog.setModal(true);

		//创建Jlabel对象管理文字并添加到弹框当中
		JLabel warning = new JLabel(content);
		warning.setBounds(50, 0, 200, 50);
		jDialog.getContentPane().add(warning);

		//让弹框展示出来
		jDialog.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
		if (source == rightCode) {
			//设置内
			codeStr = CodeUtil.getCode();
			rightCode.setText(codeStr);
		} else if (source == login) {
			login.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
			int unameLen = username.getText().length();
			int pwdLen = password.getText().length();
			if (!(codeStr.equalsIgnoreCase(code.getText()))) {
				showJDialog("验证码错误！");
//				code.setText(null);                            //清空验证码
			} else if (unameLen == 0 || pwdLen == 0) {
				showJDialog("用户名和密码为空！");
			} else {
				boolean flag = checkUserInfo();
				if (flag) {
					this.setVisible(false);
					new GameJFrame();
				} else {
					showJDialog("用户名和密码错误");
/*					username.setText(null);					//清空内容
					password.setText(null);*/
				}
			}
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object source = e.getSource();
		if (source == login) {
			login.setIcon(new ImageIcon("image\\login\\登录按下.png"));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Object source = e.getSource();
		if (source == login) {
			login.setIcon(new ImageIcon("image\\login\\登录按钮.png"));
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	private boolean checkUserInfo() {
		for (int i = 0; i < list.size(); i++) {
			User u = list.get(i);
			if (u.getUname().equals(username.getText()) && u.getPassword().equals(password.getText())) {
				return true;
			}
		}
		return false;
	}

}
