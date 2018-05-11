package com.liuyanpeng.tanshishe;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MaxScoreUI extends JPanel {

	/**
	 * 最高分界面
	 * 为方面起见，分数以文字形式显示，不在以图片形式显示
	 */
	// IDE生成，解决警告，不知道什么用
	private static final long serialVersionUID = 1924073290093893394L;

	// 创建图片 我也不想写这长。。。
	// 原来很长。。。。。
	ImageIcon img1 = new ImageIcon("image\\back.png");// 返回图片
	ImageIcon max1 = new ImageIcon("image\\max1.png");// 最高分图片
	ImageIcon max2 = new ImageIcon("image\\max2.png");// 看看你就知道是什么图片了...

	// 返回按钮
	JButton bt1 = new JButton(img1);
	// 图片标签
	JLabel title = new JLabel(max1);
	JLabel title1 = new JLabel(max2);
	// 文字标签 用于显示最高分
	JLabel title2 = new JLabel("0");
	JLabel title3 = new JLabel("0");
	JLabel title4 = new JLabel("0");

	// 构造方法
	public MaxScoreUI() {

		this.setLayout(null);
		bt1.setBounds(780, 430, 47, 34);// 定义位置
		this.add(bt1);
		title.setBounds(290, 20, 256, 99);
		this.add(title);
		title1.setBounds(190, 170, 472, 226);
		this.add(title1);
		title2.setBounds(487, 160, 300, 100);
		title2.setFont(new java.awt.Font("Dialog", 0, 60));// 定义字体，大小
		title2.setForeground(Color.red);// 定义颜色
		this.add(title2);
		title3.setBounds(487, 232, 300, 100);
		title3.setFont(new java.awt.Font("Dialog", 0, 60));
		title3.setForeground(Color.red);
		this.add(title3);
		title4.setBounds(487, 305, 300, 100);
		title4.setFont(new java.awt.Font("Dialog", 0, 60));
		title4.setForeground(Color.red);
		this.add(title4);
	}

}
