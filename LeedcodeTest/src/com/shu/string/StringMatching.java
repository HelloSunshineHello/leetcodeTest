package com.shu.string;

public class StringMatching {
	public static void main(String[] args) {
		simplePatternMatching("goodgoogle", "google", 0);
	}

	// s父串，t为字串，第pos个字符之后的位置
	public static int simplePatternMatching(String s, String t, int pos) {
		int n = s.length();
		int m = t.length();
		int j = 0;// t的起始位置
		int i = pos;
		while (i < n && j < m) {
			if (i >= n - m + 1)
				break;
			if (s.charAt(i) == t.charAt(j)) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
			System.out.println("i:" + i);
			System.out.println("j:" + j);

		}
		if (j == m) {
			System.out.println(i - j);
			return i - j;
		}
		System.out.println(-1);
		return -1;

	}
}
