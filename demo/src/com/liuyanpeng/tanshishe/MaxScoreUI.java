package com.liuyanpeng.tanshishe;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MaxScoreUI extends JPanel {

	/**
	 * ��߷ֽ���
	 * Ϊ���������������������ʽ��ʾ��������ͼƬ��ʽ��ʾ
	 */
	// IDE���ɣ�������棬��֪��ʲô��
	private static final long serialVersionUID = 1924073290093893394L;

	// ����ͼƬ ��Ҳ����д�ⳤ������
	// ԭ���ܳ�����������
	ImageIcon img1 = new ImageIcon("image\\back.png");// ����ͼƬ
	ImageIcon max1 = new ImageIcon("image\\max1.png");// ��߷�ͼƬ
	ImageIcon max2 = new ImageIcon("image\\max2.png");// �������֪����ʲôͼƬ��...

	// ���ذ�ť
	JButton bt1 = new JButton(img1);
	// ͼƬ��ǩ
	JLabel title = new JLabel(max1);
	JLabel title1 = new JLabel(max2);
	// ���ֱ�ǩ ������ʾ��߷�
	JLabel title2 = new JLabel("0");
	JLabel title3 = new JLabel("0");
	JLabel title4 = new JLabel("0");

	// ���췽��
	public MaxScoreUI() {

		this.setLayout(null);
		bt1.setBounds(780, 430, 47, 34);// ����λ��
		this.add(bt1);
		title.setBounds(290, 20, 256, 99);
		this.add(title);
		title1.setBounds(190, 170, 472, 226);
		this.add(title1);
		title2.setBounds(487, 160, 300, 100);
		title2.setFont(new java.awt.Font("Dialog", 0, 60));// �������壬��С
		title2.setForeground(Color.red);// ������ɫ
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
