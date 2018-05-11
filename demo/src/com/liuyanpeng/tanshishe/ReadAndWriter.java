package com.liuyanpeng.tanshishe;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * �ı�д�����ȡ�� ����bufferedWriter��bufferedR���� ������д���Լ�������
 */

public class ReadAndWriter {

	/*
	 * ����һ��BufferedWriter���������ļ���д����߷� ������try-catch�����쳣
	 */
	public void bufferedWriter(int score1, int score2, int score3) {
		// ����������ƴ��Ϊ�ַ������ã��ָ�
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
	 * ����һ��BufferedReader��������ȡ�ļ��е���߷֣�ͬ����try-catch�����쳣
	 */
	public String bufferedReader() {
		String maxString = null;
		File file = new File("max.txt");

		try {
			// ��ΪbuffereReader��ȡ�ļ�ʱ�����ļ������ڻᱨ��������ִ��ǰ���ж��ļ��Ƿ����
			if (!file.exists()) {
				file.createNewFile();// IOException �쳣
				// �����ļ�
				bufferedWriter(0, 0, 0);// ����֮��д��Ĭ��ֵ����д����̨һ�������лл����Ҳ��֪��Ϊʲô
			}

			BufferedReader br;
			br = new BufferedReader(new FileReader("max.txt"));// FileNotFoundException �쳣
			maxString = br.readLine();// IOException �쳣
			// �ļ�ֻ��һ�У����Բ���Ҫѭ��

			// ����ַ���Ϊ�գ�д��Ĭ�Ϸ���
			if (maxString == null) {
				bufferedWriter(0, 0, 0);
			}

			br.close();// IOException �쳣

			/*
			 * catch (IOException | FileNotFoundException e) ��д������
			 * ��ΪFileNotFoundException��IOException������ �����޸�Ϊֻ����IOException�쳣 �˴������β���
			 * try-catch�ڲ�����Ҫ�������٣��˴���Щ�Ѹ㣬 �ȴ������޸�
			 */
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// �������쳣�е��±ƣ�ֱ�Ӳ��������쳣
		// �ȴ������޸�
		// catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		return maxString;// try-catch ����дreturn�Ǵ���д��
	}

	/*
	 * ͬ�����Լ���������д
	 */
	// String maxString;
	// String fileName = "D:/max.txt";
	// File file = new File(fileName);
	//
	// // ����TXT�ļ�
	// public String readTxt() {
	// BufferedReader reader = null;
	// try {
	// if (!file.exists()) {
	// file.createNewFile();
	// bufferedWriter(0, 0, 0);
	// }
	// reader = new BufferedReader(new FileReader(file));
	// String tempString = null;
	// // һ�ζ���һ�У�ֱ������nullΪ�ļ�����N
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
	 * ʹ��BufferedWriter��д ��Ϊ��ǰ�Ĳ���
	 */

	// public void write(int score1,int score2,int score3){
	// String scoreString=score1+","+score2+","+score3;
	// try {
	// PrintStream ps = new PrintStream(new FileOutputStream(file));
	// ps.println("���ĵ�Ϊ̰ʳ����Ϸ���ɣ�����ɾ�������������ɣ����ڿ�����åһ������������");// ���ļ���д���ַ���
	// ps.append(scoreString);
	// ps.close();
	// } catch (FileNotFoundException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
}
