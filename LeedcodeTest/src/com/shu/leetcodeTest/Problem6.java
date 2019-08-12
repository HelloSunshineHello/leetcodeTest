package com.shu.leetcodeTest;

public class Problem6 {
	public static void main(String[] args) {
		convert("LEETCODEISHIRING", 3);
	}

	public static String convert(String s, int numRows) {
		int len = s.length();
		// numColnums= len/(2numRows-2)*(numRows-1)=len/2;
		int numColnums = (len + 1) / 2;
		char[][] a = new char[numRows][numColnums];
		System.out.println("numRows:" + numRows);
		System.out.println("numColnums:" + numColnums);
		int k = 0;
		while (k < len) {
			for (int i = 0; i < numColnums; i++) {
				for (int j = 0; j < numRows; j++) {
					System.out.println("i,j:" + i + "," + j);

					if (i % (numRows - 1) == 0) {
						a[i][j] = s.charAt(k);
						System.out.println("k:" + k);
						k++;

					} else if (i % (numRows - 1) == j) {
						a[i][j] = s.charAt(k);
						System.out.println("k:" + k);
						k++;
					}
					System.out.println("a[" + i + "][" + j + "]:" + a[i][j]);
					System.out.println("----------------");
				}

			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numColnums; j++) {
				sb.append(a[i][j]);
			}
		}
		System.out.println(sb.toString());
		return sb.toString();

	}
}
