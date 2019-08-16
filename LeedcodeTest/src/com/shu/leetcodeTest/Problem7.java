package com.shu.leetcodeTest;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 
 * 示例 1:
 * 
 * 输入: 123 输出: 321
 * 
 * 示例 2:
 * 
 * 输入: -123 输出: -321
 * 
 * 示例 3:
 * 
 * 输入: 120 输出: 21
 * 
 * 注意:
 * 
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231, 231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 * 
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author 28194
 *
 */
public class Problem7 {
	public static void main(String[] args) {
		reverse(2147483647);
		reverse02(2147483647);
	}

	// 方法(推荐）
	public static int reverse02(int x) {
		int ret = 0;
		while (x != 0) {
			int pop = x % 10;
			x /= 10;

			if (ret > Integer.MAX_VALUE / 10 || (ret == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10))
				// System.out.println(0);
				return 0;
			if (ret < Integer.MIN_VALUE / 10 || (ret == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10))
				// System.out.println(0);
				return 0;
			ret = ret * 10 + pop;
		}
		// System.out.println(ret);
		return ret;
	}

	// 自己的思路,没有判断数字益处的问题,存在益处的问题
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
		System.out.println(s);
		int m = Integer.parseInt(s);
		if (m > Integer.MAX_VALUE || m < Integer.MIN_VALUE)
			return 0;
		// System.out.println(0);
		return m;

	}
}
