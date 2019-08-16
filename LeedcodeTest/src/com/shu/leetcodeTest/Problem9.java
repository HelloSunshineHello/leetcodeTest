package com.shu.leetcodeTest;

/**
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 
 * 示例 1:
 * 
 * 输入: 121 输出: true
 * 
 * 示例 2:
 * 
 * 输入: -121 输出: false 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * 
 * 示例 3:
 * 
 * 输入: 10 输出: false 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author 28194
 *
 */
public class Problem9 {

	// 方法一 :将数字转换为字符串
	public boolean isPalindrome(int x) {
		String reverse = new StringBuilder(x + "").reverse().toString();
		String origin = new String(x + "");
		return origin.equals(reverse);
	}

	// 方法二：逐位比较
	public boolean isPalindrome02(int x) {
		if (x < 0)
			return false;
		int div = 1;
		while (x / div >= 10)
			div *= 10;
		while (x > 0) {
			int j = x % 10;
			int i = x / div;
			if (j != i)
				return false;
			x = x % div / 10;
			div /= 100;
		}
		return true;
	}

	// 方法三：取后半段数字翻转
	public boolean isPalindrome03(int x) {
		if (x < 0 || (x % 10 == 0 && x != 0))
			return false;
		int a = 0;
		while (x > a) {
			a = a * 10 + x % 10;
			x /= 10;
		}
		return x == a || x == (a / 10);
	}

}
