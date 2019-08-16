package com.shu.sortMethods;

/**
 * 1、选择排序（直接选择排序，堆排序） 2、交换排序（冒泡排序，快速排序） 3、插入排序（直接插入排序，希尔排序） 4、归并排序 5、桶式排序 6、基数排序
 */
public class SimpleSelectSort {
	public static void main(String[] args) {
		int[] a = { 1, 34, 5, 7, 4, 2, 3, 9, 12, 55, 13, 12, 45, 32, 23, 18, 67 };
		simpleSelectSort(a);

	}

	// 简单选择排序
	public static void simpleSelectSort(int[] a) {
		int len = a.length;
		for (int i = 0; i < len; i++) {
			int min = i;
			for (int j = i + 1; j < len; j++) {
				if (a[min] > a[j])
					min = j;
			}
			if (min != i) {
				int temp = a[i];
				a[i] = a[min];
				a[min] = temp;
			}
		}
		for (int temp : a) {
			System.out.print(temp + ",");
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
		for (int temp : a) {
			System.out.print(temp + ",");
		}
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
		// return a;
	}

	// 归并排序(二归并实现） 递归实现
	// 将a[s,t]归并排序为b[s,t]
	public static void mergeSort(int[] a, int i, int j) {
		if (i < j) {
			int mid = (i + j) / 2;// 放在if条件里外结果没有区别，最好放在里面
			mergeSort(a, i, mid);// 左边归并排序，使得左子序列有序
			mergeSort(a, mid + 1, j);// 右边归并排序，使得右子序列有序
			merge(a, i, mid, j);// 合并两个子序列
		}
	}

	// 工具类函数Merge().
	// 将有序的a[i,m]和a[m,n-1]归并为 b[i,n]
	public static void merge(int[] a, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;

		// 先将小的排在前面
		while (i <= mid && j <= right) {
			if (a[i] < a[j]) {
				temp[k++] = a[i++];
			} else {
				temp[k++] = a[j++];
			}
		}

		// 将s[left,mid-1]剩余部分复制到temp[]
		while (i <= mid) {
			temp[k++] = a[i++];
		}
		// ******************************************//
		// 这部分是不是可以优化掉，不用要呢？
		// 思考：如何左边的部分先排完，右边的部分可以不复制到临时数组中，直接将临时数组复制到原数组中。
		// 将s[mid,right]剩余部分复制到temp[]
		// 这样理解，这部分可以优化掉。但是去掉之后，输出全部为0；具体什么原因 ，后面再过来分析
		while (j <= right) {
			temp[k++] = a[j++];
		}

		// 将排好序的数组再复制到原数组中
		for (int l = 0; l < temp.length; l++) {
			a[left + l] = temp[l];
		}
		for (int temp1 : a) {
			System.out.print(temp1 + ",");
		}
		System.out.println();
	}

	// 归并排序(二归并实现） 迭代实现
	public static void mergeSort01(int[] a) {
		int len = a.length;
		int[] b = new int[a.length];
		int k = 1;
		while (k < len) {
			mergePass(a, b, k, len - 1);
			k *= 2;
			mergePass(b, a, k, len - 1);
			k *= 2;
		}
	}

	public static void merge01(int[] a, int[] b, int left, int mid, int right) {
		int i = left;
		int j = mid + 1;
		int k = 0;

		// 先将小的排在前面
		while (i <= mid && j <= right) {
			if (a[i] < a[j]) {
				b[k++] = a[i++];
			} else {
				b[k++] = a[j++];
			}
		}

		// 将s[left,mid-1]剩余部分复制到temp[]
		while (i <= mid) {
			b[k++] = a[i++];
		}
		// ******************************************//
		// 这部分是不是可以优化掉，不用要呢？
		// 思考：如何左边的部分先排完，右边的部分可以不复制到临时数组中，直接将临时数组复制到原数组中。
		// 将s[mid,right]剩余部分复制到temp[]
		// 这样理解，这部分可以优化掉。但是去掉之后，输出全部为0；具体什么原因 ，后面再过来分析
		while (j < right) {
			b[k++] = a[j++];
		}

		// 将排好序的数组再复制到原数组中
		for (int l = 0; l < b.length; l++) {
			a[left + l] = b[l];
		}
		for (int temp1 : a) {
			System.out.print(temp1 + ",");
		}
		System.out.println();
	}

	// 迭代归并排序的工具函数 mergePass()
	// 将a[0，n]中相邻长度为s的子序列两两归并
	public static void mergePass(int[] a, int[] b, int s, int n) {
		int i = 0;
		while (i < n - 2 * s + 1) {
			merge01(a, b, i, i + s, i + 2 * s);
			i += 2 * s;
		}
		if (i < n - s + 1) {// 归并最后两个数列
			merge01(a, b, i, i + s, n);
		} else {// 只剩单个子序列
			for (int j = i; j <= n; j++) {
				b[j] = a[j];
			}

		}
	}

	// 快速排序{递归实现）
}