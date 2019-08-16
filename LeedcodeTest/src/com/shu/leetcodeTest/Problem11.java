package com.shu.leetcodeTest;

public class Problem11 {
	public static void main(String[] args) {
		int[] height = { 10, 12, 8, 6, 2, 5, 4, 8, 34, 12, 10, 12, 8, 6, 2, 5, 4, 8, 34, 12, 10, 12, 8, 6, 2, 5, 4, 8,
				34, 12, 10, 12, 8, 6, 2, 5, 4, 8, 34, 12, 10, 12, 8, 6, 2, 5, 4, 8, 34, 12, 10, 12, 8, 6, 2, 5, 4, 8,
				34, 12, 10, 12, 8, 6, 2, 5, 4, 8, 34, 12, 10, 12, 8, 6, 2, 5, 4, 8, 34, 12, 10, 12, 8, 6, 2, 5, 4, 8,
				34, 12, 4, 8, 34, 12, 10, 12, 8, 6, 2, 5, 4, 8, 34, 12, 10, 12, 8, 6, 2, 5, 4, 8, 34, 12, 10, 12, 8, 6,
				2, 5, 4, 8, 34, 12 };
		maxArea(height);
		maxArea01(height);
		maxArea02(height);
	}

	// 暴力解法
	public static int maxArea(int[] height) {
		long start = System.currentTimeMillis();
		int maxA = 0;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				maxA = Math.max(maxA, Math.min(height[i], height[j]) * (j - i));
			}
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
		return maxA;
	}

	// 双指针
	public static int maxArea01(int[] height) {
		long start = System.currentTimeMillis();
		int maxA = 0;
		int l = 0;
		int r = height.length - 1;
		while (l < r) {
			maxA = Math.max(maxA, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r]) {
				l++;
			} else {
				r--;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("双指针1：" + (end - start));
		return maxA;
	}

	// 自己觉得可以优化的双指针,结果存在超时，尴尬，有空再看问题在何处
	public static int maxArea02(int[] height) {
		long start = System.currentTimeMillis();
		int maxA = 0;
		int l = 0;
		int r = height.length - 1;
		while (l < r) {
			maxA = Math.max(maxA, Math.min(height[l], height[r]) * (r - l));
			if (height[l] < height[r]) {
				while (height[l] > height[l + 1] && l < r)
					l++;
				if (height[l] > height[r])
					l--;
			} else {
				while (height[r] > height[r - 1] && l < r)
					r--;
				if (height[r] > height[l])
					r++;
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("双指针2：" + (end - start));
		return maxA;
	}
}
