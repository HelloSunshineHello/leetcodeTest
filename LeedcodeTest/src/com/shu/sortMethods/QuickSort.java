package com.shu.sortMethods;

/**
 * 快速排序的递归实现方法及其一些优化
 * 
 * @author 28194
 *
 */
public class QuickSort {
	private final static int MAX_LENGTH_INSERT_SORT = 10;

	public static void quickSort(int[] a, int low, int high) {
		if (low < high) {
			// int pivot = partition(a, low, high);// 将数组一分为二
			// int pivot = partition01(a, low, high);// 将数组一分为二
			int pivot = partition02(a, low, high);// 将数组一分为二
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

	// *******************************快速排序的优化*******************************

	// 1、优化轴的选取，
	// 三数取中法(median-of-three):即取三个关键字先进行排序，将中间数作为枢轴，
	// 一般取左端，中间，右端三个数
	public static int partition01(int[] a, int low, int high) {
		int mid = low + (high - low) / 2;
		if (a[low] > a[high]) // 使左端小于右端
			swap(a, low, high);
		if (a[mid] > a[high])// 使中间小于右端
			swap(a, mid, high);
		if (a[mid] > a[low])
			swap(a, mid, low);// 使三个数的中间数移动到左端，变为a[low]
		int pivot = a[low];// 使中间数做枢轴；

		while (low < high) {
			while (low < high && a[high] >= pivot)
				high--;
			swap(a, low, high);
			while (low < high && a[low] <= pivot)
				low++;
			swap(a, low, high);

		}
		return low;
	}

	// 2、采用替换，优化了不必要的交换，
	public static int partition02(int[] a, int low, int high) {
		int mid = low + (high - low) / 2;
		if (a[low] > a[high])
			swap(a, low, high);
		if (a[mid] > a[high])
			swap(a, mid, high);
		if (a[mid] > a[low])
			swap(a, low, mid);
		int pivot = a[low];
		while (low < high) {
			while (low < high && a[high] >= pivot)
				high--;
			a[low] = a[high];// 直接采用替换
			while (low < high && a[low] < pivot)
				low++;
			a[high] = a[low];
		}
		a[low] = pivot;
		return low;
	}

	// 3、优化小数组的排序方案，当数组较小的时候，选择直接插入的方法
	public static void quickSort01(int[] a, int low, int high) {
		if (low < high && (high - low) > MAX_LENGTH_INSERT_SORT) {
			int pivot = partition02(a, low, high);
			quickSort01(a, low, pivot - 1);
			quickSort01(a, pivot + 1, high);
		} else {
			straightInsertSort(a);
		}
	}

	// 4、优化递归操作
	public static void quickSort02(int[] a, int low, int high) {
		if (low < high && (high - low) > MAX_LENGTH_INSERT_SORT) {
			int pivot = partition02(a, low, high);
			quickSort02(a, low, pivot - 1);
			low = pivot + 1;
		} else {
			straightInsertSort(a);
		}
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

	}

	// 交换的工具函数
	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		int[] a = { 1, 34, 5, 7, 4, 2, 3, 9, 37, 23, 34, 21, 18, 67, 12, 57 };
		// quickSort(a, 0, a.length - 1);
		// quickSort01(a, 0, a.length - 1);
		quickSort02(a, 0, a.length - 1);
		for (int temp : a) {
			System.out.print(temp + ",");
		}
	}
}
