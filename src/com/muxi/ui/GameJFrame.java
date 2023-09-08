package com.muxi.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GameJFrame extends JFrame implements KeyListener, ActionListener {

	String path = "image\\girl\\girl1\\";
	int[][] data = new int[4][4];
	int x = 0;
	int y = 0;
	int[][] win = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
	int step = 0;

	JMenu rePicture = new JMenu("更换图片");
	JMenuItem replayItem = new JMenuItem("重新游戏");
	JMenuItem reLoginItem = new JMenuItem("重新登录");
	JMenuItem closeGameItem = new JMenuItem("关闭游戏");
	JMenuItem officialAccount = new JMenuItem("关于我");

	JMenuItem girlPic = new JMenuItem("美女");
	JMenuItem animalPic = new JMenuItem("动物");
	JMenuItem sportPic = new JMenuItem("运动");

	public GameJFrame() {

		initJFrame();

		initJMenuBar();

		initData();

		initImageIcon();

		this.setVisible(true);
	}

	private void initData() {
		//		创建一个一维数组 ，然后将其内容打乱
		int[] tempArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
		Random r = new Random();
		for (int i = 0; i < tempArr.length; i++) {
			int index = r.nextInt(tempArr.length);
			int temp = tempArr[i];
			tempArr[i] = tempArr[index];
			tempArr[index] = temp;
		}
//		在将打乱的一维数组，每4位，放到二维数组中  // 方法一:
		for (int i = 0; i < tempArr.length; i++) {
			if (tempArr[i] == 0) {
				x = i / 4;
				y = i % 4;
			}
			data[i / 4][i % 4] = tempArr[i];
		}
	}

	private void initImageIcon() {
		this.getContentPane().removeAll();
		JLabel stepLabel = new JLabel("步数：" + step);
		stepLabel.setBounds(50, 20, 100, 12);
		this.getContentPane().add(stepLabel);
		if (Victory()) {
			JLabel jWin = new JLabel(new ImageIcon("image/win.png"));
			jWin.setBounds(203, 283, 197, 73);
			this.getContentPane().add(jWin);
		}
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				JLabel jLabel = new JLabel(new ImageIcon(path + data[i][j] + ".jpg"));
				jLabel.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
				jLabel.setBorder(new BevelBorder(BevelBorder.RAISED));
				this.getContentPane().add(jLabel);
			}
		}
		JLabel background = new JLabel(new ImageIcon("image\\background.png"));
		background.setBounds(40, 40, 508, 560);
		this.getContentPane().add(background);
		this.getContentPane().repaint();
	}

	private void initJFrame() {
		this.setSize(603, 680);
		Image ic = Toolkit.getDefaultToolkit().getImage("logo/拼图.png");  //更换图标
		this.setIconImage(ic);
		this.setTitle("拼图游戏(单机版) v1.0");
		this.setAlwaysOnTop(true);    //置顶
		this.setLocationRelativeTo(null);   //页面居中
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  //关闭方式
		this.setLayout(null);
		this.addKeyListener(this);
	}

	private void initJMenuBar() {
		JMenuBar jMenuBar = new JMenuBar();
		JMenu functionMenu = new JMenu("功能");
		JMenu aboutMenu = new JMenu("关于");
		jMenuBar.add(functionMenu);
		jMenuBar.add(aboutMenu);

		functionMenu.add(rePicture);
		functionMenu.add(replayItem);
		functionMenu.add(reLoginItem);
		functionMenu.add(closeGameItem);
		aboutMenu.add(officialAccount);


		rePicture.add(girlPic);
		rePicture.add(animalPic);
		rePicture.add(sportPic);

		replayItem.addActionListener(this);
		reLoginItem.addActionListener(this);
		closeGameItem.addActionListener(this);
		officialAccount.addActionListener(this);
		girlPic.addActionListener(this);
		animalPic.addActionListener(this);
		sportPic.addActionListener(this);
		this.setJMenuBar(jMenuBar);

	}


	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (Victory()) {
			return;
		}
		int code = e.getKeyCode();
		if (code == 65 || code == 97) {
			this.getContentPane().removeAll();
			JLabel allPic = new JLabel(new ImageIcon(path + "all.jpg"));
			allPic.setBounds(83, 134, 420, 420);
			this.getContentPane().add(allPic);
			this.getContentPane().repaint();
			JLabel background = new JLabel(new ImageIcon("image\\background.png"));
			background.setBounds(40, 40, 508, 560);
			this.getContentPane().add(background);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (Victory()) {
			return;
		}
		int code = e.getKeyCode();
		if (code == 37) {
			System.out.println("左");
			if (y == 0) {
				return;
			}
			data[x][y] = data[x][y - 1];
			data[x][y - 1] = 0;
			y--;
			step++;
			initImageIcon();
		} else if (code == 38) {
			System.out.println("上");
			if (x == 3) {
				return;
			}
			data[x][y] = data[x + 1][y];
			data[x + 1][y] = 0;
			x++;
			step++;
			initImageIcon();
		} else if (code == 39) {
			System.out.println("右");
			if (y == 3) {
				return;
			}
			data[x][y] = data[x][y + 1];
			data[x][y + 1] = 0;
			y++;
			step++;
			initImageIcon();
		} else if (code == 40) {
			System.out.println("下");
			if (x == 0) {
				return;
			}
			data[x][y] = data[x - 1][y];
			data[x - 1][y] = 0;
			x--;
			step++;
			initImageIcon();

		} else if (code == 65 || code == 97) {
			initImageIcon();
		} else if (code == 87) {
			data = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 0}};
			initImageIcon();
		}


	}

	public boolean Victory() {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (data[i][j] != win[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == replayItem) {
			step = 0;
			initData();
			initImageIcon();
		} else if (source == officialAccount) {
			JDialog jDialog = new JDialog();
			jDialog.setTitle("联系方式");
			Image image = Toolkit.getDefaultToolkit().getImage("logo/拼图.png");
			jDialog.setIconImage(image);
			JLabel aboutJlabel = new JLabel(new ImageIcon("image\\about.png"));
			aboutJlabel.setBounds(0, 0, 258, 258);
			jDialog.getContentPane().add(aboutJlabel);
			jDialog.setSize(344, 344);
			jDialog.setAlwaysOnTop(true);
			jDialog.setLocationRelativeTo(null);
			jDialog.setModal(true);  //不关闭此弹窗，禁用其他功能
			jDialog.setVisible(true);
		} else if (source == reLoginItem) {
			this.setVisible(false);
			new LoginJFrame();
		} else if (source == closeGameItem) {
			System.exit(0);
		} else if (source == girlPic) {
			int[] girlArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
			Random r = new Random();
			int index = r.nextInt(girlArr.length);
			path = "image\\girl\\girl" + girlArr[index] + "\\";
			initData();
			initImageIcon();
			System.out.println("更换为:" + girlArr[index]);
			initData();
		} else if (source == animalPic) {
			int[] animalPicArr = {1, 2, 3, 4, 5, 6, 7, 8};
			Random r = new Random();
			int index = r.nextInt(animalPicArr.length);
			path = "image\\animal\\animal" + animalPicArr[index] + "\\";
			initData();
			initImageIcon();
			System.out.println("更换为:" + animalPicArr[index]);
			initData();
		} else if (source == sportPic) {
			int[] sportArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
			Random r = new Random();
			int index = r.nextInt(sportArr.length);
			path = "image\\sport\\sport" + sportArr[index] + "\\";
			initData();
			initImageIcon();
			System.out.println("更换为:" + sportArr[index]);
		}

	}

}
