package com.panpan.walle.study.alg.zcy.basic.zdemo.class09;

import java.util.HashSet;

/**
 * 点灯问题
 * 街道：XX..X.XXX
 * 如何点最少的灯把街道全部点亮
 */
public class Code02_Light {

	public static int minLight1(String road) {
		if (road == null || road.length() == 0) {
			return 0;
		}
		return process(road.toCharArray(), 0, new HashSet<>());
	}

	public static int process(char[] str, int index, HashSet<Integer> lights) {
		if (index == str.length) {
			for (int i = 0; i < str.length; i++) {
				if (str[i] != 'X') {
					if (!lights.contains(i - 1) && !lights.contains(i) && !lights.contains(i + 1)) {
						return Integer.MAX_VALUE;
					}
				}
			}
			return lights.size();
		} else {
			int no = process(str, index + 1, lights);
			int yes = Integer.MAX_VALUE;
			if (str[index] == '.') {
				lights.add(index);
				yes = process(str, index + 1, lights);
				lights.remove(index);
			}
			return Math.min(no, yes);
		}
	}

	public static int minLight2(String road) {
		char[] str = road.toCharArray();
		int index = 0;
		int light = 0;
		while (index < str.length) {
			if (str[index] == 'X') {
				index++;
			} else {
				light++;
				if (index + 1 == str.length) { //.$的情况
					break;
				} else {
					if (str[index + 1] == 'X') { //.X的情况
						index = index + 2;
					} else { //..的情况
						index = index + 3;
					}
				}
			}
		}
		return light;
	}

	// for test
	public static String randomString(int len) {
		char[] res = new char[(int) (Math.random() * len) + 1];
		for (int i = 0; i < res.length; i++) {
			res[i] = Math.random() < 0.5 ? 'X' : '.';
		}
		return String.valueOf(res);
	}

	public static void main(String[] args) {
		int len = 20;
		int testTime = 100000;
		for (int i = 0; i < testTime; i++) {
			String test = randomString(len);
			int ans1 = minLight1(test);
			int ans2 = minLight2(test);
			if (ans1 != ans2) {
				System.out.println("oops!");
			}
		}
		System.out.println("finish!");
	}
}
