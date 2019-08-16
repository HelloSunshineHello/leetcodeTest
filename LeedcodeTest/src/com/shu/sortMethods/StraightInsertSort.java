package com.shu.sortMethods;

/**
 * 1、选择排序（直接选择排序，堆排序） 2、交换排序（冒泡排序，快速排序） 3、插入排序（直接插入排序，希尔排序） 4、归并排序 5、桶式排序 6、基数排序
 */
public class StraightInsertSort {
	public static void main(String[] args) {
		int[] a = { 1, 34, 5, 7, 4, 2, 3, 9, 12, 55, 13, 12, 45, 32, 23, 18, 67 };
		straightInsertSort(a);
	}

	// 直接插入排序
	public static void straightInsertSort(int[] a) {
		int len = a.length;
		for (int i = 1; i < len; i++) {
			if (a[i] < a[i - 1]) {
				int temp = a[i];
				int j = 0;
				for (j = i - 1; j >= 0 && a[j] > temp; j--) {
					a[j + 1] = a[j];
				}
				a[j + 1] = temp;
			}
		}
		for (int temp : a) {
			System.out.print(temp + ",");
		}
	}

}