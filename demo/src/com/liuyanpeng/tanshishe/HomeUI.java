package com.liuyanpeng.tanshishe;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HomeUI extends JPanel {
	/**
	 * 主页界面
	 */
	private static final long serialVersionUID = -6163797946558070638L;
	//加载图片
	ImageIcon img1 = new ImageIcon("image\\start.png");
	ImageIcon img2 = new ImageIcon("image\\setting.png");
	ImageIcon img3 = new ImageIcon("image\\help.png");
	ImageIcon img4 = new ImageIcon("image\\max.png");
	ImageIcon snake = new ImageIcon("image\\snake.png");
	//图片放入按钮
	JButton bt1 = new JButton(img1);
	JButton bt2 = new JButton(img2);
	JButton bt3 = new JButton(img3);
	JButton bt4 = new JButton(img4);
	//图片放入标签
	JLabel title=new JLabel(snake);
	
	public HomeUI(){
	
		this.setLayout(null);
		bt1.setBounds(650, 150,174,72);
		bt2.setBounds(650, 230, 174, 72);
		bt3.setBounds(650, 310, 174, 72);
		bt4.setBounds(650, 390, 174, 72);
		title.setBounds(170, 35, 333, 390);
		
		this.add(bt1);
		this.add(bt2);	
		this.add(bt3);
		this.add(bt4);
		this.add(title);
	}

}
