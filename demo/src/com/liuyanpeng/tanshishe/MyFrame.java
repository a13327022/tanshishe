package com.liuyanpeng.tanshishe;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

/**
 * ̰ʳ��1.0 ������ǿ������Ϸ�ĳ����汾 ����Ϸ����ʱ����2016/2/14��������������� �˴��ļ��������ǣ��˼ҹ����˽ڣ�������д����
 *
 * ����bugʳ����������������ϣ�δ���
 *
 * ����ͼƬ������ԭλ����src�£�ʵ�ַ������£����Ϊjar����ܻ��Ҳ��� new
 * ImageIcon(getClass().getResource("timerow0.png")).getImage();
 * �����������˼���Լ�ͼƬλ�úܲ��ã����������޸�
 */

public class MyFrame extends JFrame implements ActionListener {
	/**
	 * ������
	 */
	private static final long serialVersionUID = -4196906480972855864L;
	// ʵ����������
	CardLayout card = new CardLayout();
	HomeUI mp = new HomeUI();
	Game mp1 = new Game();
	SettingUI mp2 = new SettingUI();
	HelpUI mp3 = new HelpUI();
	MaxScoreUI mp4 = new MaxScoreUI();
	ChooseUI mp5 = new ChooseUI();
	AboutUI mp6 = new AboutUI();
	JPanel pane = new JPanel();
	Sound sd = new Sound();
	ReadAndWriter mt = new ReadAndWriter();

	public MyFrame() {
		// TODO �Զ����ɵķ������
		super("̰ʳ��");
		try {
			// ��LookAndFeel���ó�Windows��ʽ
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		// ���ÿ�Ƭ���ֲ���ӻ���
		pane.setLayout(card);
		pane.add(mp, "p");
		pane.add(mp1, "p1");
		pane.add(mp2, "p2");
		pane.add(mp3, "p3");
		pane.add(mp4, "p4");
		pane.add(mp5, "p5");
		pane.add(mp6, "p6");
		// ��ť����
		mp.bt1.addActionListener(this);
		mp.bt2.addActionListener(this);
		mp.bt3.addActionListener(this);
		mp.bt4.addActionListener(this);
		mp1.bt1.addActionListener(this);
		mp2.bt1.addActionListener(this);
		mp2.bt2.addActionListener(this);
		mp3.bt1.addActionListener(this);
		mp3.bt2.addActionListener(this);
		mp4.bt1.addActionListener(this);
		mp5.bt1.addActionListener(this);
		mp5.bt2.addActionListener(this);
		mp5.bt3.addActionListener(this);
		mp5.bt4.addActionListener(this);
		mp6.bt1.addActionListener(this);
		// �����߳�
		new Thread(mp1).start();
		// ���̼���
		addKeyListener(mp1);
		// ���ű�������
		mp1.sd.sound("bg");
		// ���ô�������
		add(pane);
		setSize(847, 516);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		if (e.getSource() == mp.bt1) {// ��ʼ
			mp1.sd.sound("buttion");
			card.show(pane, "p5");
		}
		if (e.getSource() == mp.bt2) {// ����
			mp1.sd.sound("buttion");
			card.show(pane, "p2");
		}
		if (e.getSource() == mp.bt3) {// ����
			mp1.sd.sound("buttion");
			card.show(pane, "p3");
		}
		if (e.getSource() == mp.bt4) {// ��߷�
			mp1.sd.sound("buttion");
			card.show(pane, "p4");
			score(mt.bufferedReader());
		}
		if (e.getSource() == mp1.bt1) {// ����ģʽ
			mp1.sd.sound("buttion");
			mp1.resetGame();// ����Ϊ�����൱Ư��
			card.show(pane, "p5");
		}
		if (e.getSource() == mp2.bt2) {// ���ֿ���
			if (mp1.sd.buttion) {
				mp2.bt2.setIcon(mp2.img3);
				mp1.sd.closeSound();
			} else {
				mp2.bt2.setIcon(mp2.img2);
				mp1.sd.openSound();
				mp1.sd.sound("buttion");
			}
		}
		if (e.getSource() == mp3.bt2) {// ����
			mp1.sd.sound("buttion");
			card.show(pane, "p6");
		}
		if (e.getSource() == mp5.bt1) {// �޾�ģʽ
			mp1.sd.sound("buttion");
			mp1.map.map("�޾�ģʽ");
			mp1.mode = 0;
			card.show(pane, "p1");
			requestFocus();
		}
		if (e.getSource() == mp5.bt2) {// ����ģʽ
			mp1.sd.sound("buttion");
			mp1.map.map("����ģʽ");
			mp1.mode = 1;
			card.show(pane, "p1");
			requestFocus();
		}
		if (e.getSource() == mp5.bt3) {// ����ģʽ
			mp1.sd.sound("buttion");
			mp1.map.map("����ģʽ1");
			mp1.mode = 2;
			card.show(pane, "p1");
			requestFocus();
		}
		if (e.getSource() == mp6.bt1) {// ���ذ���
			mp1.sd.sound("buttion");
			card.show(pane, "p3");
		}
		if (e.getSource() == mp2.bt1 || e.getSource() == mp3.bt1 || e.getSource() == mp4.bt1
				|| e.getSource() == mp5.bt4) {// ������ҳ
			mp1.sd.sound("buttion");
			card.show(pane, "p");
		}
	}

	// ��ȡ��������
	public void score(String str) {
		String[] newstr = str.split(",");
		mp4.title2.setText(newstr[0]);
		mp4.title3.setText(newstr[1]);
		mp4.title4.setText(newstr[2]);
	}
	//main��������������Ҳ�ǹ��ˣ����½���
	// public static void main(String[] args) {
	// new MyFrame();
	// }
}
