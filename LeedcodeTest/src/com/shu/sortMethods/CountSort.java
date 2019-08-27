package com.shu.sortMethods;

public class CountSort {
	public static void main(String[] args) {
		int[] arr = { 22, 34, 55, 1, 24, 45, 23, 7, 9, 23, 12, 21, 34, 18, 91, 5, 67 };
		/// int[] arr = { 1, 2, 2, 5, 9, 7, 3, 6, 9 };
		countSort(arr);
	}

	public static int[] countSort(int[] arr) {
		int min = arr[0];
		int max = arr[0];
		for (int i : arr) {
			// max= Math.max(max, i);
			// min= Math.min(min, i);
			if (i > max)
				max = i;
			if (i < min)
				min = i;
		}
		int n = max - min + 1;
		int[] b = new int[n];
		// 放入桶里
		for (int i = 0; i < arr.length; i++) {
			b[arr[i] - min]++;
		}
		// 计算每个桶的秩
		for (int i = 1; i < b.length; i++) {
			b[i] = b[i] + b[i - 1];
		}
		int[] c = new int[arr.length];
		for (int i = arr.length - 1; i >= 0; i--) {
			// arr[i]-min是数组b的下标
			// b[arr[i]-min]是arr[i]对应的秩
			c[--b[arr[i] - min]] = arr[i];
		}
		for (int i : c) {
			System.out.print(i + " ");
		}
		return c;
	}
}
