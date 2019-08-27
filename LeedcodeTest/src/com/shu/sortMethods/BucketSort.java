package com.shu.sortMethods;

public class BucketSort {
	public static void main(String[] args) {
		int[] arr = { 22, 34, 55, 1, 24, 45, 23, 7, 9, 23, 12, 21, 34, 18, 91, 5, 67 };
		// int[] arr = { 1, 2, 2, 5, 9, 7, 3, 6, 9 };
		bucketSort(arr);

	}

	public static int[] bucketSort(int[] arr) {
		int min = arr[0];
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > max)
				max = arr[i];
			if (arr[i] < min)
				min = arr[i];
			// 或者
			// max = Math.max(max, arr[i]);
			// min = Math.min(min, arr[i]);
		}

		int n = max - min + 1;
		int[] b = new int[n];
		// 将数组放入桶里
		for (int i = 0; i < arr.length; i++) {
			b[arr[i] - min]++;
		}

		// 将数组取出
		int[] c = new int[arr.length];
		int j = 0;
		for (int i = 0; i < b.length; i++) {
			while (b[i] != 0) {
				c[j++] = i + min;
				b[i]--;
			}
		}
		for (int i : c) {
			System.out.print(i + " ");
		}
		return c;
	}
}
