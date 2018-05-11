package com.liuyanpeng.tanshishe;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;

/**
 * ������
 *
 * java.applet�ѷ���
 * ���������Java Web Start��javapackager��JavaFX/WebView��
 * �����á���������
 */
public class Sound {
	File file1;
	File file2;
	File file3;
	File file4;
	boolean buttion = true;
	AudioClip sound1, sound2, sound3, sound4, sound5;

	// ���췽��
	public Sound() {
		try {
			sound1 = Applet.newAudioClip(getClass().getResource("bg_1.wav"));
			sound2 = Applet.newAudioClip(getClass().getResource("eat.wav"));
			sound3 = Applet.newAudioClip(getClass().getResource("fail.wav"));
			sound4 = Applet.newAudioClip(getClass().getResource("reward.wav"));
			sound5 = Applet.newAudioClip(getClass().getResource("buttion.wav"));
		} catch (OutOfMemoryError | Exception e) {
			System.out.println("�ڴ����");
			e.printStackTrace();
		}
	}

	public void sound(String name) {
		if (buttion) {
			switch (name) {
			case "bg":
				sound3.stop();
				sound1.loop();
				break;
			case "eat":
				sound2.play();
				break;
			case "reward":
				sound1.stop();
				sound4.loop();
				break;
			case "closeReward":
				sound4.stop();
				sound1.loop();
				break;
			case "fail":
				sound4.stop();
				sound1.stop();
				sound3.play();
				break;
			case "buttion":
				sound5.play();
				break;
			}
		}
	}

	public void closeSound() {
		sound1.stop();
		buttion = false;
	}

	public void openSound() {
		sound1.loop();
		buttion = true;
	}
}
