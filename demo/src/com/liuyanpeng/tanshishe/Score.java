package com.liuyanpeng.tanshishe;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * ��Ϸ�ڷ���չʾ
 *��������ͼƬ����ʽ��ʾ
 */
public class Score {
	int score_x = 0;// ����
	int thousand;// ������ǧλ
	int hundreds;// �����İ�λ
	int tens;// ������ʮλ
	int ones;// �����ĸ�λ

	public Image score2;// ����ͼƬ��������ʾǧλ
	public Image score3;// ����ͼƬ��������ʾ��λ
	public Image score4;// ����ͼƬ��������ʾ��λ
	public Image score5 = new ImageIcon("image\\n0.png").getImage();// Ĭ����ʾͼƬ0

	public void score(int score) {
		// ��ȡ������λ��������������ΪͼƬ��ʾ
		score_x = String.valueOf(score).length() - 1;
		switch (String.valueOf(score).length()) {// ��Ϊûдbreak�����ӻ�ȡ��λ������ִ�е���λ
		case 4:
			thousand = score / 1000;/// ��ȡǧλ
			score2 = new ImageIcon("image\\n" + thousand + ".png").getImage();// ����ʾ��ͼƬ���ȡ����ǧλ���ֶ�Ӧ
		case 3:
			hundreds = (score % 1000) / 100;
			score3 = new ImageIcon("image\\n" + hundreds + ".png").getImage();
		case 2:
			tens = (score % 100) / 10;
			score4 = new ImageIcon("image\\n" + tens + ".png").getImage();
		case 1:
			ones = score % 10;
			score5 = new ImageIcon("image\\n" + ones + ".png").getImage();
		}
	}

	/*
	 * ���÷��� 0.pegΪ͸��ͼƬ
	 */
	public void reset() {
		score_x = 0;
		score2 = new ImageIcon("image\\0.png").getImage();
		score3 = new ImageIcon("image\\0.png").getImage();
		score4 = new ImageIcon("image\\0.png").getImage();
		score5 = new ImageIcon("image\\n0.png").getImage();

	}
}
