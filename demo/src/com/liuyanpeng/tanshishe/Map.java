package com.liuyanpeng.tanshishe;

import java.awt.Point;
import java.util.LinkedList;

/**
 * 地图类 
 * 根据参数创建不同地图
 */
public class Map {
	// 创建集合，保存方块坐标
	public LinkedList<Point> map = new LinkedList<>();

	public void map(String name) {
		switch (name) {
		case "无尽模式":
			map.clear();//清空地图
			break;
		case "经典模式":
			map.clear();
			for (int x = 0; x < 830; x += 20) {
				map.add(new Point(x, 0));//添加坐标
				map.add(new Point(x, 460));
			}
			for (int y = 20; y < 450; y += 20) {
				map.add(new Point(0, y));
				map.add(new Point(820, y));
			}
			break;
		case "历险模式1":
			map.clear();
			for (int x = 120; x < 710; x += 20) {
				if (x > 280 && x < 540)
					continue;
				map.add(new Point(x, 80));
				map.add(new Point(x, 380));
			}
			for (int y = 100; y < 380; y += 20) {
				if (y > 160 && y < 300)
					continue;
				map.add(new Point(120, y));
				map.add(new Point(700, y));
			}
			break;
		case "历险模式2":
			map.clear();
			for (int x = 120; x < 710; x += 20) {
				if (x > 200 && x < 620)
					map.add(new Point(x, 240));
				if (x > 280 && x < 540)
					continue;
				map.add(new Point(x, 80));
				map.add(new Point(x, 380));
			}
			break;
		case "历险模式3":
			map.clear();
			for (int x = 0; x < 830; x += 20) {
				if (x >= 0 && x < 540)
					map.add(new Point(x, 80));
				if (x > 280 && x < 830)
					map.add(new Point(x, 380));
			}
			for (int y = 0; y < 470; y += 20) {
				if (y >= 0 && y < 300)
					map.add(new Point(700, y));
				if (y > 160 && y < 470)
					map.add(new Point(120, y));
			}
			break;
		case "历险模式4":
			map.clear();
			for (int x = 0; x < 830; x += 20) {
				map.add(new Point(x, 240));
			}
			for (int y = 0; y < 470; y += 20) {
				if (y == 240)
					continue;
				map.add(new Point(420, y));
			}
			break;
		}

	}
}
