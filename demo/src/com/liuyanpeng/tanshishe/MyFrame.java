package com.liuyanpeng.tanshishe;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * 贪食蛇1.0 可以勉强称作游戏的初级版本 该游戏创作时间是2016/2/14，有特殊纪念意义 此处的纪念意义是，人家过情人节，过无聊写代码
 *
 * 发现bug食物会生成在蛇身体上，未解决
 *
 * 关于图片创建，原位置在src下，实现方法如下，打包为jar后可能会找不到 new
 * ImageIcon(getClass().getResource("timerow0.png")).getImage();
 * 括号里面的意思，以及图片位置很不好，所以做了修改
 */

public class MyFrame extends JFrame implements ActionListener {
	/**
	 * 窗口类
	 */
	private static final long serialVersionUID = -4196906480972855864L;
	// 实例化所需类
	CardLayout card = new CardLayout();
	HomeUI mp = new HomeUI();
	Game mp1 = new Game();
	SettingUI mp2 = new SettingUI();
	HelpUI mp3 = new HelpUI();
	MaxScoreUI mp4 = new MaxScoreUI();
	ChooseUI mp5 = new ChooseUI();
	AboutUI mp6 = new AboutUI();
	JPanel pane = new JPanel();
	Sound sd = new Sound();
	ReadAndWriter mt = new ReadAndWriter();

	public MyFrame() {
		// TODO 自动生成的方法存根
		super("贪食蛇");
		try {
			// 将LookAndFeel设置成Windows样式
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// 设置卡片布局并添加画布
		pane.setLayout(card);
		pane.add(mp, "p");
		pane.add(mp1, "p1");
		pane.add(mp2, "p2");
		pane.add(mp3, "p3");
		pane.add(mp4, "p4");
		pane.add(mp5, "p5");
		pane.add(mp6, "p6");
		// 按钮监听
		mp.bt1.addActionListener(this);
		mp.bt2.addActionListener(this);
		mp.bt3.addActionListener(this);
		mp.bt4.addActionListener(this);
		mp1.bt1.addActionListener(this);
		mp2.bt1.addActionListener(this);
		mp2.bt2.addActionListener(this);
		mp3.bt1.addActionListener(this);
		mp3.bt2.addActionListener(this);
		mp4.bt1.addActionListener(this);
		mp5.bt1.addActionListener(this);
		mp5.bt2.addActionListener(this);
		mp5.bt3.addActionListener(this);
		mp5.bt4.addActionListener(this);
		mp6.bt1.addActionListener(this);
		// 启动线程
		new Thread(mp1).start();
		// 键盘监听
		addKeyListener(mp1);
		// 播放背景音乐
		mp1.sd.sound("bg");
		// 设置窗口属性
		add(pane);
		setSize(847, 516);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		if (e.getSource() == mp.bt1) {// 开始
			mp1.sd.sound("buttion");
			card.show(pane, "p5");
		}
		if (e.getSource() == mp.bt2) {// 设置
			mp1.sd.sound("buttion");
			card.show(pane, "p2");
		}
		if (e.getSource() == mp.bt3) {// 帮助
			mp1.sd.sound("buttion");
			card.show(pane, "p3");
		}
		if (e.getSource() == mp.bt4) {// 最高分
			mp1.sd.sound("buttion");
			card.show(pane, "p4");
			score(mt.bufferedReader());
		}
		if (e.getSource() == mp1.bt1) {// 返回模式
			mp1.sd.sound("buttion");
			mp1.resetGame();// 自认为这招相当漂亮
			card.show(pane, "p5");
		}
		if (e.getSource() == mp2.bt2) {// 音乐开关
			if (mp1.sd.buttion) {
				mp2.bt2.setIcon(mp2.img3);
				mp1.sd.closeSound();
			} else {
				mp2.bt2.setIcon(mp2.img2);
				mp1.sd.openSound();
				mp1.sd.sound("buttion");
			}
		}
		if (e.getSource() == mp3.bt2) {// 关于
			mp1.sd.sound("buttion");
			card.show(pane, "p6");
		}
		if (e.getSource() == mp5.bt1) {// 无尽模式
			mp1.sd.sound("buttion");
			mp1.map.map("无尽模式");
			mp1.mode = 0;
			card.show(pane, "p1");
			requestFocus();
		}
		if (e.getSource() == mp5.bt2) {// 经典模式
			mp1.sd.sound("buttion");
			mp1.map.map("经典模式");
			mp1.mode = 1;
			card.show(pane, "p1");
			requestFocus();
		}
		if (e.getSource() == mp5.bt3) {// 历险模式
			mp1.sd.sound("buttion");
			mp1.map.map("历险模式1");
			mp1.mode = 2;
			card.show(pane, "p1");
			requestFocus();
		}
		if (e.getSource() == mp6.bt1) {// 返回帮助
			mp1.sd.sound("buttion");
			card.show(pane, "p3");
		}
		if (e.getSource() == mp2.bt1 || e.getSource() == mp3.bt1 || e.getSource() == mp4.bt1
				|| e.getSource() == mp5.bt4) {// 返回主页
			mp1.sd.sound("buttion");
			card.show(pane, "p");
		}
	}

	// 获取分数分配
	public void score(String str) {
		String[] newstr = str.split(",");
		mp4.title2.setText(newstr[0]);
		mp4.title3.setText(newstr[1]);
		mp4.title4.setText(newstr[2]);
	}
	//main方法混成这个样子也是够了，以新建类
	// public static void main(String[] args) {
	// new MyFrame();
	// }
}
