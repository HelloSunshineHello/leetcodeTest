package com.shu.sortMethods;

/**
 * 1、选择排序（直接选择排序，堆排序） 2、交换排序（冒泡排序，快速排序） 3、插入排序（直接插入排序，希尔排序） 4、归并排序 5、桶式排序 6、基数排序
 */
public class MegerSort01 {
	public static void main(String[] args) {
		int[] a = { 1, 34, 5, 7, 4, 2, 3, 9, 12, 55, 13, 12, 45, 32, 23, 18, 67 };

		mergeSort(a);
		for (int temp1 : a) {
			System.out.print(temp1 + ",");
		}
	}

	// 归并排序(二归并实现） 迭代实现
	public static void mergeSort(int[] a) {
		int len = a.length;
		int[] b = new int[a.length];// 用于存放归并结果
		int k = 1;// 起始，子序列长度为1
		while (k < len) {
			mergePass(a, b, k, len);// 将原先无序的数据两两归并入TR
			k *= 2;// 子序列长度加倍
			mergePass(b, a, k, len);// 将TR中已经两两归并的有序序列再归并回数组a
			k *= 2;// 子序列长度加倍
		}
	}

	// 迭代归并排序的工具函数 mergePass()
	// 将a[0，n]中相邻长度为s的子序列两两归并
	public static void mergePass(int[] a, int[] b, int s, int n) {
		int i = 0;
		while (i < n - 2 * s + 1) {
			merge(a, b, i, i + s - 1, i + 2 * s - 1);
			i += 2 * s;
		}
		if (i < n - s + 1) {// 归并最后两个数列
			merge(a, b, i, i + s - 1, n - 1);
		} else {// 只剩单个子序列
			for (int j = i; j < n; j++) {
				b[j] = a[j];
			}

		}
	}

	public static void merge(int[] a, int[] b, int left, int mid, int right) {
		// 也可以转为一个for循环来写，更加简洁明了
		int i = left;
		int j = mid + 1;
		int k = 0;

		// 先将小的排在前面
		while (i <= mid && j <= right) {
			if (a[i] < a[j])
				b[k++] = a[i++];
			else
				b[k++] = a[j++];
		}

		// 将s[left,mid-1]剩余部分复制到temp[]
		while (i <= mid) {
			b[k++] = a[i++];
		}
		/**
		 * 
		 * 这部分是不是可以优化掉，不用要呢？ 思考：如果左边的部分先排完，右边的部分可以不复制到临时数组中，直接将临时数组复制到原数组中。
		 * 将s[mid,right]剩余部分复制到temp[] 这样理解，这部分可以优化掉。但是去掉之后，输出全部为0；具体什么原因 ，后面再过来分析
		 */
		while (j <= right) {
			b[k++] = a[j++];
		}

		for (int temp1 : b) {
			System.out.print(temp1 + ",");
		}
		System.out.println();
	}
}