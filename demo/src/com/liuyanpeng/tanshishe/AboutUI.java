package com.liuyanpeng.tanshishe;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutUI extends JPanel{

	/**
	 * 关于界面
	 */
	private static final long serialVersionUID = -6627368364446704294L;
	
	ImageIcon help1 = new ImageIcon("image\\about1.png");
	ImageIcon help2 = new ImageIcon("image\\about2.png");
	ImageIcon img1 = new ImageIcon("image\\back.png");
	
	JButton bt1 = new JButton(img1);
	JLabel title1=new JLabel(help1);
	JLabel title2=new JLabel(help2);
	
	public AboutUI(){
		this.setLayout(null);
		bt1.setBounds(780, 430, 47, 34);
		this.add(bt1);
		title1.setBounds(330, 20, 162, 99);
		this.add(title1);
		title2.setBounds(35, 190, 776, 143);
		this.add(title2);
	}
	
}
