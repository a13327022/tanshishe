package com.liuyanpeng.tanshishe;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChooseUI extends JPanel {
	/**
	 * 选择模式界面
	 */
	private static final long serialVersionUID = -6163797946558070638L;
	ImageIcon img1 = new ImageIcon("image\\Endless.png");
	ImageIcon img2 = new ImageIcon("image\\classic.png");
	ImageIcon img3 = new ImageIcon("image\\explore.png");
	ImageIcon img4 = new ImageIcon("image\\back.png");
	ImageIcon mode = new ImageIcon("image\\mode.png");
	ImageIcon mode1 = new ImageIcon("image\\mode1.png");
	JButton bt1 = new JButton(img1);
	JButton bt2 = new JButton(img2);
	JButton bt3 = new JButton(img3);
	JButton bt4 = new JButton(img4);
	JLabel title=new JLabel(mode);
	JLabel title1=new JLabel(mode1);
	public ChooseUI(){
	
		this.setLayout(null);
		bt1.setBounds(15, 190, 250, 137);
		bt2.setBounds(296, 190, 250, 137);
		bt3.setBounds(577, 190, 250, 137);
		bt4.setBounds(780, 430, 47, 34);
		title.setBounds(330, 20, 174, 99);
		title1.setBounds(0, 360, 801, 50);
		this.add(bt1);
		this.add(bt2);	
		this.add(bt3);
		this.add(bt4);
		this.add(title);
		this.add(title1);
	}

}
