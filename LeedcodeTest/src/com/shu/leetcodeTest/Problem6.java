package com.shu.leetcodeTest;

import java.util.ArrayList;
import java.util.List;
/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。

比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

L   C   I   R
E T O E S I I G
E   D   H   N

之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

请你实现这个将字符串进行指定行数变换的函数：

string convert(string s, int numRows);

示例 1:

输入: s = "LEETCODEISHIRING", numRows = 3
输出: "LCIRETOESIIGEDHN"

示例 2:

输入: s = "LEETCODEISHIRING", numRows = 4
输出: "LDREOEIIECIHNTSG"
解释:

L     D     R
E   O E   I I
E C   I H   N
T     S     G

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zigzag-conversion
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author 28194
 *
 */
public class Problem6 {
	public static void main(String[] args) {
		// convert01("LEETCODEISHIRING", 1);
		convert03("LEETCODEISHIRING", 3);
		convert02("LEETCODEISHIRING", 3);
	}

	// 方法二：（推荐）
	public static String convert02(String s, int numRows) {
		if (numRows == 1) {
			System.out.println(s);
			return s;
		}

		int len = s.length();
		boolean goingDown = false;
		int curRow = 0;

		List<StringBuilder> list = new ArrayList<>();
		for (int i = 0; i < Math.min(len, numRows); i++) {
			list.add(new StringBuilder());
		}
		// 将每行排好
		for (char c : s.toCharArray()) {
			list.get(curRow).append(c);
			if (curRow == 0 || curRow == numRows - 1)
				goingDown = !goingDown;
			curRow += goingDown ? 1 : -1;
		}

		StringBuilder sb = new StringBuilder();
		for (StringBuilder strb : list) {
			sb.append(strb);
		}

		System.out.println(sb.toString());
		return sb.toString();
	}

	// 方法三：
	public static String convert03(String s, int numRows) {
		if (numRows == 1) {
			System.out.println(s);
			return s;
		}

		int cycleLen = 2 * numRows - 2;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < numRows; i++) {
			System.out.println("i=" + i);
			for (int j = 0; j + i < s.length(); j += cycleLen) {
				sb.append(s.charAt(j + i));
				System.out.println("1:" + s.charAt(j + i));
				if (i > 0 && i < numRows - 1 && (j - i + cycleLen) < s.length()) {
					sb.append(s.charAt(j + cycleLen - i));
					System.out.println("2:" + s.charAt(j + cycleLen - i));
				}
			}
			System.out.println("------------------------");
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

	// 方法一：自己的二维数组，笨办法
	/**
	 * 执行用时 :882 ms, 在所有 Java 提交中击败了5.05% 的用户 内存消耗 :164.1 MB, 在所有 Java
	 * 提交中击败了5.02%的用户 炫耀一下:
	 * 
	 * @param s
	 * @param numRows
	 * @return
	 */
	public static String convert01(String s, int numRows) {
		// 当行数为1时 ，直径输出。
		if (numRows == 1) {
			System.out.println(s.toString());
			return s;
		}
		int len = s.length();

		// numColnums= len/(2numRows-2)*(numRows-1)=len/2;
		int numColnums = (len + 1) / 2;
		char[][] a = new char[numColnums][numRows];
		System.out.println("numRows:" + numRows);
		System.out.println("numColnums:" + numColnums);
		int k = 0;

		for (int i = 0; i < numColnums; i++) {
			for (int j = 0; j < numRows; j++) {
				System.out.println("i,j:" + i + "," + j);

				if (i % (numRows - 1) == 0 && k < len) {
					a[i][j] = s.charAt(k);
					System.out.println("k:" + k);
					k++;

				} else if (i % (numRows - 1) + j + 1 == numRows && k < len) {
					a[i][j] = s.charAt(k);
					System.out.println("k:" + k);
					k++;
				} else {
					a[i][j] = ' ';
				}

				System.out.println("a[" + i + "][" + j + "]:" + a[i][j]);
				System.out.println("----------------");
			}

		}

		StringBuilder sb = new StringBuilder();
		for (int j = 0; j < numRows; j++) {
			for (int i = 0; i < numColnums; i++) {
				sb.append(a[i][j]);
			}
		}
		String s1 = sb.toString().replace(" ", "");
		System.out.println(s1);
		return s1.toString();

	}
}
