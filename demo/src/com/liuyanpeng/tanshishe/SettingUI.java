package com.liuyanpeng.tanshishe;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SettingUI extends JPanel {

	/**
	 * 设置卡片 设置页布局
	 */
	private static final long serialVersionUID = -7570886037087417049L;

	ImageIcon setting1 = new ImageIcon("image\\setting1.png");
	ImageIcon setting2 = new ImageIcon("image\\setting2.png");
	ImageIcon setting3 = new ImageIcon("image\\music.png");
	ImageIcon img1 = new ImageIcon("image\\back.png");
	// 音乐开关图片
	ImageIcon img2 = new ImageIcon("image\\musicButtion1.png");
	ImageIcon img3 = new ImageIcon("image\\musicButtion2.png");

	JButton bt1 = new JButton(img1);
	JButton bt2 = new JButton(img2);

	JLabel title = new JLabel(setting1);
	JLabel title1 = new JLabel(setting2);
	JLabel title2 = new JLabel(setting3);

	// 构造方法
	public SettingUI() {
		this.setLayout(null);
		bt1.setBounds(780, 430, 47, 34);
		this.add(bt1);
		bt2.setBounds(460, 180, 151, 53);
		this.add(bt2);
		title.setBounds(330, 20, 172, 99);
		this.add(title);
		title1.setBounds(170, 320, 546, 50);
		this.add(title1);
		title2.setBounds(250, 170, 122, 72);
		this.add(title2);
	}

}
