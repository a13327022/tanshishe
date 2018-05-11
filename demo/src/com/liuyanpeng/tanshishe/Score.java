package com.liuyanpeng.tanshishe;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 游戏内分数展示
 *将分数以图片的形式显示
 */
public class Score {
	int score_x = 0;// 分数
	int thousand;// 分数的千位
	int hundreds;// 分数的百位
	int tens;// 分数的十位
	int ones;// 分数的个位

	public Image score2;// 创建图片，用来显示千位
	public Image score3;// 创建图片，用来显示百位
	public Image score4;// 创建图片，用来显示个位
	public Image score5 = new ImageIcon("image\\n0.png").getImage();// 默认显示图片0

	public void score(int score) {
		// 获取分数的位数，将分数翻译为图片显示
		score_x = String.valueOf(score).length() - 1;
		switch (String.valueOf(score).length()) {// 因为没写break，将从获取的位数依次执行到各位
		case 4:
			thousand = score / 1000;/// 获取千位
			score2 = new ImageIcon("image\\n" + thousand + ".png").getImage();// 将显示的图片与获取到的千位数字对应
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
	 * 重置方法 0.peg为透明图片
	 */
	public void reset() {
		score_x = 0;
		score2 = new ImageIcon("image\\0.png").getImage();
		score3 = new ImageIcon("image\\0.png").getImage();
		score4 = new ImageIcon("image\\0.png").getImage();
		score5 = new ImageIcon("image\\n0.png").getImage();

	}
}
