package com.liuyanpeng.tanshishe;



import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HelpUI  extends JPanel{

	/**
	 * 帮助界面
	 * 
	 */
	private static final long serialVersionUID = -6627368364446704294L;
	
	ImageIcon help1 = new ImageIcon("image\\help1.png");
	ImageIcon help2 = new ImageIcon("image\\help2.png");
	ImageIcon img1 = new ImageIcon("image\\back.png");
	ImageIcon img2 = new ImageIcon("image\\about.png");
	
	JButton bt1 = new JButton(img1);
	JButton bt2 = new JButton(img2);
	
	JLabel title1=new JLabel(help1);
	JLabel title2=new JLabel(help2);
	//构造方法
	public HelpUI(){
		this.setLayout(null);
		bt1.setBounds(780, 430, 47, 34);
		this.add(bt1);
		bt2.setBounds(20, 430, 35, 36);
		this.add(bt2);
		title1.setBounds(340, 20, 166, 99);
		this.add(title1);
		title2.setBounds(170, 150, 479, 269);
		this.add(title2);
	}
	
}
