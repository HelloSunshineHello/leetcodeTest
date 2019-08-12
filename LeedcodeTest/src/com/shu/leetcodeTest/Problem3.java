package com.shu.leetcodeTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 
 * 示例 1:
 * 
 * 输入: "abcabcbb" 输出: 3 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 
 * 示例 2:
 * 
 * 输入: "bbbbb" 输出: 1 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 
 * 示例 3:
 * 
 * 输入: "pwwkew" 输出: 3
 * 
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 * @author 28194
 *
 */
public class Problem3 {
	public static void main(String[] args) {
		lengthOfLongestSubstring01("abccba");
		lengthOfLongestSubstring02("abccba");
		lengthOfLongestSubstring03("abccba");

	}

	// 解法三
	public static int lengthOfLongestSubstring03(String s) {
		int len = s.length();
		int ans = 0;
		Map<Character, Integer> map = new HashMap<>();
		for (int j = 0, i = 0; j < len; j++) {
			if (map.containsKey(s.charAt(j))) {
				// System.out.println("origin i："+i);
				i = Math.max(map.get(s.charAt(j)), i);
				// System.out.println("fisrt i："+i);
			}
			// System.out.println(s.charAt(j));
			map.put(s.charAt(j), j + 1);
			// System.out.println(map);
			ans = Math.max(ans, j - i + 1);
			// System.out.println("ans:"+ans);
			// System.out.println("-------------------");
			// 优化
			if (ans > len - i) {
				System.out.println(ans);
				return ans;
			}
		}
		System.out.println(ans);
		return ans;

	}

	// 解法二
	public static int lengthOfLongestSubstring02(String s) {
		int len = s.length();
		int ans = 0;
		int i = 0;
		int j = 0;
		Set<Character> set = new HashSet<>();
		while (j < len) {
			// Character ch = s.charAt(j);
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j - i);
			} else {
				set.remove(s.charAt(i++));
			}
		}
		System.out.println(ans);
		return ans;
	}

	// 解法一 暴力查找：时间复杂度为O(n^3)
	public static int lengthOfLongestSubstring01(String s) {
		int len = s.length();
		int ans = 0;
		for (int i = 0; i < len; i++) {
			for (int j = i + 1; j <= len; j++) {
				if (allUnique(s, i, j)) {
					ans = Math.max(ans, j - i);
				}
			}
		}
		System.out.println(ans);
		return ans;
	}

	public static boolean allUnique(String s, int start, int end) {
		Set<Character> set = new HashSet<>();
		// [i,j)
		for (int i = start; i < end; i++) {
			Character ch = s.charAt(i);
			if (set.contains(ch)) {
				return false;
			}
			set.add(ch);
		}

		return true;
	}
}
