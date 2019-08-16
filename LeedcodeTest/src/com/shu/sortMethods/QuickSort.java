package com.shu.sortMethods;

public class QuickSort {
	public static void quickSort(int[] a, int low, int high) {
		if (low < high) {
			int pivot = partition(a, low, high);// 将数组一分为二
			quickSort(a, low, pivot - 1);// 对低子序列进行排序
			quickSort(a, pivot + 1, high);// 对高子序列进行排序
		}
	}

	public static int partition(int[] a, int low, int high) {
		int key = a[low];
		while (low < high) {
			while (low < high && a[high] >= key)
				high--;
			swap(a, low, high);// 将比轴小的交换到低端

			while (low < high && a[low] <= key)
				low++;
			swap(a, low, high);// 将比轴大的交换到高端
		}
		return low; // 返回轴所在的位置
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 1, 34, 5, 7, 4, 2, 3, 9, 12, 55 };
		quickSort(a, 0, a.length - 1);
		for (int temp : a) {
			System.out.print(temp + ",");
		}
	}
}
