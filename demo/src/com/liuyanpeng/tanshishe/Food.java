package com.liuyanpeng.tanshishe;

import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 食物类
 */
public class Food {
	//随机生成坐标
	int foodx=(int)(Math.random()*42)*20;
	int foody=(int)(Math.random()*24)*20;

	public Image food1 = new ImageIcon("image\\food1.png").getImage();
	public Image food2 = new ImageIcon("image\\food2.png").getImage();
	public Image food=food1;
	
		public void food(int score){
			if(score%10==0){//超级食物
				food=food2;
				foodx=(int)(Math.random()*41)*20;
				foody=(int)(Math.random()*23)*20;
			}else{
				food=food1;
				foodx=(int)(Math.random()*42)*20;
				foody=(int)(Math.random()*24)*20;
			}
		}
		public void foodReset(){
			foodx=(int)(Math.random()*42)*20;
			foody=(int)(Math.random()*24)*20;
			food=food1;
		}
}
