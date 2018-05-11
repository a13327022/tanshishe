package com.liuyanpeng.tanshishe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文本写入与读取类 包括bufferedWriter和bufferedR方法 考虑重写，自己看不懂
 */

public class ReadAndWriter {

	/*
	 * 创建一个BufferedWriter方法，在文件中写入最高分 ，并用try-catch处理异常
	 */
	public void bufferedWriter(int score1, int score2, int score3) {
		// 将三个数字拼接为字符串，用，分隔
		String scoreString = score1 + "," + score2 + "," + score3;

		try {

			BufferedWriter bw = new BufferedWriter(new FileWriter("max.txt"));
			bw.write(scoreString);
			bw.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 创建一个BufferedReader方法，读取文件中的最高分，同样用try-catch处理异常
	 */
	public String bufferedReader() {
		String maxString = null;
		File file = new File("max.txt");

		try {
			// 因为buffereReader读取文件时，该文件不存在会报错，所以在执行前先判断文件是否存在
			if (!file.exists()) {
				file.createNewFile();// IOException 异常
				// 创建文件
				bufferedWriter(0, 0, 0);// 创建之后写入默认值，不写控制台一顿输出，谢谢！我也想知道为什么
			}

			BufferedReader br;
			br = new BufferedReader(new FileReader("max.txt"));// FileNotFoundException 异常
			maxString = br.readLine();// IOException 异常
			// 文件只有一行，所以不需要循环

			// 如果字符串为空，写入默认分数
			if (maxString == null) {
				bufferedWriter(0, 0, 0);
			}

			br.close();// IOException 异常

			/*
			 * catch (IOException | FileNotFoundException e) 此写法错误
			 * 因为FileNotFoundException是IOException的子类 可以修改为只捕获IOException异常 此处分两次捕获
			 * try-catch内部代码要尽可能少，此处有些难搞， 等待后期修改
			 */
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 捕获多个异常有点懵逼，直接捕获所有异常
		// 等待后期修改
		// catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		return maxString;// try-catch 里面写return是错误写法
	}

	/*
	 * 同样，自己不懂，重写
	 */
	// String maxString;
	// String fileName = "D:/max.txt";
	// File file = new File(fileName);
	//
	// // 读入TXT文件
	// public String readTxt() {
	// BufferedReader reader = null;
	// try {
	// if (!file.exists()) {
	// file.createNewFile();
	// bufferedWriter(0, 0, 0);
	// }
	// reader = new BufferedReader(new FileReader(file));
	// String tempString = null;
	// // 一次读入一行，直到读入null为文件结束N
	// while ((tempString = reader.readLine()) != null) {
	// maxString = tempString;
	// }
	// reader.close();
	// } catch (IOException e) {
	// e.printStackTrace();
	// } finally {
	// if (reader != null) {
	// try {
	// reader.close();
	// } catch (IOException e1) {
	//
	// }
	// }
	// }
	// return maxString;
	// }

	/*
	 * 使用BufferedWriter重写 因为以前的不懂
	 */

	// public void write(int score1,int score2,int score3){
	// String scoreString=score1+","+score2+","+score3;
	// try {
	// PrintStream ps = new PrintStream(new FileOutputStream(file));
	// ps.println("此文档为贪食蛇游戏生成，可以删除，但还会生成，终于可以流氓一次啦，哈哈！");// 往文件里写入字符串
	// ps.append(scoreString);
	// ps.close();
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
}
