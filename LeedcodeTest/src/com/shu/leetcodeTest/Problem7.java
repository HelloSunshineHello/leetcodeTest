package com.shu.leetcodeTest;

public class Problem7 {
	public static void main(String[] args) {
		reverse(120);

	}

	public static int reverse(int a) {
		StringBuilder sb = new StringBuilder();

		if (a < 0) {
			sb.append("-");
			a = -a;
		} else if (a == 0) {
			return 0;
		}
		while (a > 0) {
			if (a % 10 != 0) {
				sb.append(a % 10);
			}
			a /= 10;
		}
		String s = new String(sb);
		return Integer.parseInt(s);
	}
}
