package com.liuyanpeng.tanshishe;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * ��Ϸ����
 */
public class Game extends JPanel implements Runnable, KeyListener {

	private static final long serialVersionUID = 3982837981892208868L;

	Sound sd = new Sound();
	Map map = new Map();
	Score se = new Score();
	Food fd = new Food();
	ReadAndWriter mt = new ReadAndWriter();

	int snakex = 160;
	int snakey = 220;
	int snakeNumber = 3;
	int movex = 0;
	int movey = 0;
	int fail_y = 520;
	int score = 0;
	int pause_y = 550;
	int timeRow1 = 0;
	int timeRow2 = 0;
	int velocity = 200;
	int mode;
	int back_y = 60;
	int foodNumber = 0;
	int barrierMap = 1;
	String strMap = "����ģʽ1";
	boolean time = false;
	boolean start = false;

	private Image greenstar, greenstar1, greenstar2, greenstar3, greenstar4;
	private Image score1;
	private Image redstar;
	private Image game_over;
	private Image pause;
	private Image grid1;
	private Image snakebg;
	private Image timeRow;
	private Image wall;
	private Image back;
	private ImageIcon img1;
	JButton bt1;
	private LinkedList<Point> body = new LinkedList<>();
	private LinkedList<Point> body1 = new LinkedList<>();// Ϊ�˽��̰ʳ��ײ���������ֵ�bug

	// ���췽��
	public Game() {
		this.setLayout(null);
		greenstar1 = new ImageIcon("image\\greenstar1.png").getImage();
		greenstar2 = new ImageIcon("image\\greenstar2.png").getImage();
		greenstar3 = new ImageIcon("image\\greenstar3.png").getImage();
		greenstar4 = new ImageIcon("image\\greenstar4.png").getImage();
		redstar = new ImageIcon("image\\redstar.png").getImage();
		game_over = new ImageIcon("image\\game_over.png").getImage();
		pause = new ImageIcon("image\\pause.png").getImage();
		grid1 = new ImageIcon("image\\grid1.png").getImage();
		snakebg = new ImageIcon("image\\snakebg.png").getImage();
		score1 = new ImageIcon("image\\score1.png").getImage();
		timeRow = new ImageIcon("image\\timerow0.png").getImage();
		wall = new ImageIcon("image\\wall.png").getImage();
		back = new ImageIcon("image\\back.png").getImage();
		img1 = new ImageIcon("image\\back.png");
		greenstar = greenstar4;
		for (int a = 1; a < 4; a++) {
			body.add(new Point(snakex - a * 20, snakey));
			body1.add(new Point(snakex - a * 20, snakey));
		}
		bt1 = new JButton(img1);
		this.add(bt1);
	}

	public void paint(Graphics g) {

		super.paint(g);
		// ����
		g.drawImage(snakebg, 0, 0, this);
		g.drawImage(grid1, 0, 0, this);// ����
		// ����
		g.drawImage(score1, 4, 450, this);
		g.drawImage(se.score2, 35 + 25 * se.score_x, 450, this);
		g.drawImage(se.score3, 60 + 25 * se.score_x, 450, this);
		g.drawImage(se.score4, 85 + 25 * se.score_x, 450, this);
		g.drawImage(se.score5, 110 + 25 * se.score_x, 450, this);
		// ������
		g.drawImage(timeRow, 610, 448, this);
		// ʳ��
		g.drawImage(fd.food, fd.foodx + 1, fd.foody, this);
		// ��ͷ
		g.drawImage(greenstar, snakex, snakey, this);
		// ����
		for (Point p : body) {
			g.drawImage(redstar, p.x, p.y, this);
		}
		// ��ͼ
		for (Point p : map.map) {
			g.drawImage(wall, p.x, p.y, this);
		}
		// ��Ϸʧ��
		g.drawImage(game_over, 200, fail_y, this);
		// ��Ϸ��ͣ
		g.drawImage(pause, 240, pause_y, this);
		// ���ذ�ť
		g.drawImage(back, 780, 430 + back_y, this);
	}

	// ʧ�ܷ���
	public void fail() {

		start = false;
		snakex = 1000;// ��ײ�������ʣ����ͷ
		snakey = 1000;
		if (body.size() > 0 && null != body)
			body.remove(0);
		if (fail_y == 520) {
			sd.sound("fail");
			back_y = 0;
			bt1.setBounds(780, 430 + back_y, 47, 34);
		}
		if (fail_y <= 200) {

		} else {
			fail_y -= 5;
		}
		maxScore();
	}

	// ��߷��ж���д��
	public void maxScore() {
		String str = mt.bufferedReader();
		// ����ַ�������ȡԪ�أ�Ϊ�˱Ƚϣ�ת��ΪInteger����
		String[] newstr = str.split(",");
		int a = Integer.parseInt(newstr[0]);
		int b = Integer.parseInt(newstr[1]);
		int c = Integer.parseInt(newstr[2]);

		switch (mode) {
		case 0:
			if (score > a)
				a = score;
			break;
		case 1:
			if (score > b)
				b = score;
			break;
		case 2:
			if (score > c)
				c = score;
			break;
		}
		mt.bufferedWriter(a, b, c);
	}

	// ��ͣ����
	public void pause() {
		if (pause_y == 550) {
			pause_y = 170;
			back_y = 0;
			bt1.setBounds(780, 430 + back_y, 47, 34);
			start = false;
		} else {
			pause_y = 550;
			back_y = 60;
			bt1.setBounds(780, 430 + back_y, 47, 34);
			start = true;
		}
	}

	// ����������
	public void timeRow() {
		if (timeRow1 == 0) {
			sd.sound("reward");
		}

		timeRow1 += 5;

		if (timeRow1 % 10 == 0 && start) {

			timeRow2++;
			timeRow = new ImageIcon("image\\timerow" + timeRow2 + ".png").getImage();
		}
		// ���������꣬��������ʳ��
		if (timeRow2 == 16) {
			time = false;
			fd.food = fd.food1;
			fd.foodx = (int) (Math.random() * 42) * 20;
			fd.foody = (int) (Math.random() * 24) * 20;
			timeRow1 = 0;
			timeRow2 = 1;
			timeRow = new ImageIcon("image\\timerow0.png").getImage();
			sd.sound("closeReward");

		}
	}

	// �ٶȷ���
	public void velocity() {
		if (foodNumber % 5 == 0)
			velocity -= 20;
		if (mode == 2 && foodNumber % 10 == 0)
			changeMap();// ð��ģʽ�£�������ͼ
	}

	// ������ͼ������̰ʳ������
	public void changeMap() {
		if (barrierMap == 4) {
			barrierMap = 1;
		} else {
			barrierMap++;
		}
		strMap = "����ģʽ" + barrierMap;
		map.map(strMap);
		body.clear();
		body1.clear();
		snakex = 160;
		snakey = 220;
		movex = 20;
		movey = 0;
		greenstar = greenstar4;
	}

	// ������Ϸ����Ϊ��������ťʵ�ֵ�����̶�����
	public void resetGame() {
		fd.foodReset();
		snakex = 160;
		snakey = 220;
		snakeNumber = 3;
		movex = 0;
		movey = 0;
		start = false;
		fail_y = 520;
		score = 0;
		pause_y = 550;
		timeRow1 = 0;
		timeRow2 = 1;
		time = false;
		velocity = 200;
		back_y = 60;
		foodNumber = 0;
		barrierMap = 1;
		strMap = "����ģʽ1";
		bt1.setBounds(780, 430 + back_y, 47, 34);
		se.reset();
		greenstar = greenstar4;
		timeRow = new ImageIcon("image\\timerow0.png").getImage();
		body.clear();
		body1.clear();
		sd.sound("bg");
		for (int a = 1; a < 4; a++) {
			body.add(new Point(snakex - a * 20, snakey));
			body1.add(new Point(snakex - a * 20, snakey));
		}
	}

	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while (true) {
			// ��Ϸ��ʼ
			if (start) {
				// λ��
				snakex += movex;
				snakey += movey;

				if (movex == -20) {
					if (snakex < 0) {
						snakex = 820;
						body.addFirst(new Point(0, snakey));
						body1.addFirst(new Point(0, snakey));
					} else {
						body.addFirst(new Point((snakex + 20), snakey));
						body1.addFirst(new Point((snakex + 20), snakey));
					}
				}
				if (movex == 20) {
					if (snakex > 820 && snakex != 1000) {
						snakex = 0;
						body.addFirst(new Point(820, snakey));
						body1.addFirst(new Point(820, snakey));
					} else {
						body.addFirst(new Point((snakex - 20), snakey));
						body1.addFirst(new Point((snakex - 20), snakey));
					}

				}
				if (movey == -20) {
					if (snakey < 0) {
						snakey = 460;
						body.addFirst(new Point(snakex, 0));
						body1.addFirst(new Point(snakex, 0));
					} else {
						body.addFirst(new Point(snakex, (snakey + 20)));
						body1.addFirst(new Point(snakex, (snakey + 20)));
					}

				}
				if (movey == 20) {
					if (snakey > 460 && snakex != 1000) {
						snakey = 0;
						body.addFirst(new Point(snakex, 460));
						body1.addFirst(new Point(snakex, 460));
					} else {
						body.addFirst(new Point(snakex, (snakey - 20)));
						body1.addFirst(new Point(snakex, (snakey - 20)));
					}
				}
				if (body.size() > snakeNumber) {
					body.removeLast();
					body1.removeLast();
				}

			}
			// �Ե�ʳ��
			if ((fd.foodx - snakex) * (fd.foodx - snakex) + (fd.foody - snakey) * (fd.foody - snakey) < 400
					&& fd.food == fd.food1) {
				sd.sound("eat");
				snakeNumber++;
				score++;
				foodNumber++;
				velocity();
				fd.food(score);
				se.score(score);
			}
			// ��������������������
			if (fd.food == fd.food2) {
				time = true;
			}
			// ���ý�����
			if (time) {
				timeRow();
				if ((fd.foodx + 10 - snakex) * (fd.foodx + 10 - snakex)
						+ (fd.foody + 10 - snakey) * (fd.foody + 10 - snakey) < 900) {
					sd.sound("eat");
					snakeNumber++;
					score += 5;
					fd.food(score);
					se.score(score);
					time = false;
					timeRow1 = 0;
					timeRow2 = 1;
					timeRow = new ImageIcon("image\\timerow0.png").getImage();

					sd.sound("closeReward");
				}
			}

			for (Point p : body1) {
				// ײ������
				if (snakex == p.x && snakey == p.y) {
					fail();
				}
			}

			for (Point p : map.map) {
				// ײǽ
				if (snakex == p.x && snakey == p.y) {
					fail();
				}
				// ʳ����ǽ��
				if (fd.foodx == p.x && fd.foody == p.y) {
					if (score % 10 == 0) {// ������������������õ�ʳ�����������ǽ�غϣ������½��뽱��ģʽ
						fd.foodx = (int) (Math.random() * 41) * 20;
						fd.foody = (int) (Math.random() * 23) * 20;
					} else {
						fd.food(score);
					}
				}
			}
			// ��Ϊ�ı���ͷ���꣬fail�������ᱻ�ظ�����
			if (snakex == 1000 && snakey == 1000)
				fail();
			// �ػ�
			repaint();
			// ͨ���߳����߸ı��ٶ�
			try {
				Thread.sleep(velocity);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO �Զ����ɵķ������
		// ��Ϸʧ�ܣ��������н�
		if (fail_y == 520) {
			// ��Ϸ��ͣʱ���������н�
			if (pause_y == 550) {
				// ��Ϸδ��ʼʱ��y������ͬ�����������н�
				if (movex == 0 && movey == 0) {
					if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
						greenstar = greenstar4;
						start = true;
						movex = 20;
						movey = 0;
					}
				}
				// �ߵ�һ����ڶ�������꣬��ͬ���������н�����ͬ���������н�
				if (body1.get(0).x == snakex) {

					if (arg0.getKeyCode() == KeyEvent.VK_LEFT) {
						greenstar = greenstar3;
						start = true;
						movex = -20;
						movey = 0;
					}

					if (arg0.getKeyCode() == KeyEvent.VK_RIGHT) {
						greenstar = greenstar4;
						start = true;
						movex = 20;
						movey = 0;
					}
				} else {
					if (arg0.getKeyCode() == KeyEvent.VK_UP) {
						greenstar = greenstar1;
						start = true;
						movex = 0;
						movey = -20;
					}

					if (arg0.getKeyCode() == KeyEvent.VK_DOWN) {
						greenstar = greenstar2;
						start = true;
						movex = 0;
						movey = 20;
					}
				}
			}
			// �ո����ͣ
			if (arg0.getKeyCode() == KeyEvent.VK_SPACE) {
				pause();
			}
		} else if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {// ���س�����������Ϸ����
			resetGame();
			if (mode == 2)
				map.map("����ģʽ1");
		}
	}

	public void keyReleased(KeyEvent arg0) {
		// TODO �Զ����ɵķ������
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO �Զ����ɵķ������
	}
}
