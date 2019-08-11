package com.shu.leetcodeTest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
