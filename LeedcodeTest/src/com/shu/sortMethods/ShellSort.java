package com.shu.sortMethods;

/**
 * 1、选择排序（直接选择排序，堆排序） 2、交换排序（冒泡排序，快速排序） 3、插入排序（直接插入排序，希尔排序） 4、归并排序 5、桶式排序 6、基数排序
 */
public class ShellSort {
	public static void main(String[] args) {
		int[] a = { 1, 34, 5, 7, 4, 2, 3, 9, 12, 55, 13, 12, 45, 32, 23, 18, 67 };

		shellSort(a);

	}

	// 希尔排序
	public static void shellSort(int[] a) {
		int len = a.length;
		int increase = len;
		// 使长度为1的数组也执行一次,或者对 长度进行判断，当长度大于1，才执行。
		do {
			increase = increase / 3 + 1;
			for (int i = increase; i < len; i++) {
				if (a[i] < a[i - increase]) {
					int temp = a[i];
					int j = 0;
					for (j = i - increase; j > 0 && a[j] > temp; j -= increase) {
						a[j + increase] = a[j];
					}
					a[j + increase] = temp;
				}
			}
		} while (increase > 1);
		for (int temp : a) {
			System.out.print(temp + ",");
		}
	}

}