package com.shu.sortMethods;

import java.util.Arrays;

public class RadixSort {
	public static void main(String[] args) {
		int[] arr = { 22, 34, 55, 1, 5, 7, 9, 12, 18, 21, 22, 23, 23, 24, 34, 34, 45, 55, 67, 91, 100, 666, 1000, 8888,
				10000 };
		// int[] arr = { 1, 2, 2, 5, 9, 7, 3, 6, 9 };
		radixSort(arr);
	}

	public static int[] radixSort(int[] arr) {
		int index = 10;
		int max = arr[0];
		int[] temp = new int[arr.length];
		int[] bucket = new int[index];
		for (int i : arr) {
			max = Math.max(max, i);
		}
		// 找出最大数字的位数，即循环的次数
		int maxdigit = 0;
		while (max > 0) {
			max /= 10;
			maxdigit++;
		}
		// 基数初始设为1
		int radix = 1;
		// 采用LSD(least significant digital),即从低位开始排序
		for (int k = 0; k < maxdigit; k++) {
			// 每一轮比较前将10个桶的初始值设为0；
			Arrays.fill(bucket, 0);
			System.arraycopy(arr, 0, temp, 0, arr.length);
			for (int i = 0; i < arr.length; i++) {
				bucket[temp[i] / radix % index]++;
			}
			// 计算bucket[i]桶的秩
			for (int i = 1; i < index; i++) {
				bucket[i] += bucket[i - 1];
			}
			for (int i = arr.length - 1; i >= 0; i--) {
				// temp[i]/radix%index是temp[i]在bucket数组的下标
				// bucket[temp[i]/radix%index]是temp[i]所在桶的秩
				arr[--bucket[temp[i] / radix % index]] = temp[i];
			}
			radix *= index;
		}
		for (int i : arr)
			System.out.print(i + " ");
		return arr;
	}
}
