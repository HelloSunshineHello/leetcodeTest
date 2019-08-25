package com.shu.sortMethods;

/**
 * 4、归并排序 非递归而是迭代的归并排序很直观，就是从前往后从最小的序列开始归并，直到完成即可。 但是这里边界条件不太好想，要注意不要出错。
 */
public class MegerSort01 {
	public static void main(String[] args) {
		int[] a = { 1, 34, 5, 7, 4, 2, 3, 9, 12, 23, 34, 56, 3, 5, 8, 9, 23, 45, 43, 78 };
		mergeSort2(a);
		for (int temp : a) {
			System.out.print(temp + ",");
		}
		System.out.println();
		mergeSort(a);
		for (int temp : a) {
			System.out.print(temp + ",");
		}
	}

	// 归并排序(二归并实现） 迭代实现

	public static void mergeSort2(int[] arr) {
		// 使用非递归的方式来实现归并排序
		int len = arr.length;
		int k = 1;

		while (k < len) {
			MergePass(arr, k, len);
			k *= 2;
		}
	}

	private static void MergePass(int[] arr, int k, int n) {
		int i = 0;
		int j;

		// 从前往后,将2个长度为k的子序列合并为1个
		while (i < n - 2 * k + 1) {
			merge(arr, i, i + k - 1, i + 2 * k - 1);
			i += 2 * k;
		}

		// 这段代码保证了，将那些“落单的”长度不足两两merge的部分和前面merge起来。
		if (i < n - k) {
			merge(arr, i, i + k - 1, n - 1);
		}

	}

	public static void merge(int[] a, int left, int mid, int right) {
		int[] temp = new int[right - left + 1];
		int i = left;
		int j = mid + 1;
		int k = 0;
		while (i <= mid && j <= right) { // 先将小的排在前面
			if (a[i] < a[j])
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}
		while (i <= mid) // 将s[left,mid-1]剩余部分复制到temp[]
			temp[k++] = a[i++];

		while (j <= right)
			temp[k++] = a[j++];

		for (int l = 0; l < temp.length; l++) // 将排好序的数组再复制到原数组中
			a[left + l] = temp[l];
	}

	/*************************************************************************************/
	// 方法二

	public static void mergeSort(int[] a) {
		int len = a.length;
		// System.out.println(len);
		int[] b = new int[len];// 用于存放归并结果
		int k = 1;// 起始，子序列长度为1
		while (k < len) {
			// System.out.println("k1:" + k);
			mergePass(a, b, k, len);// 将原先无序的数据两两归并入TR
			k *= 2;// 子序列长度加倍
			// System.out.println("k2:" + k);
			// mergePass(b, a, k, len);// 将TR中已经两两归并的有序序列再归并回数组a
			// k *= 2;// 子序列长度加倍
			// System.out.println("k3:" + k);
		}
	}

	// 迭代归并排序的工具函数 mergePass()
	// 将a[0，n]中相邻长度为s的子序列两两归并
	public static void mergePass(int[] a, int[] b, int s, int n) {
		int i = 0;
		while (i < n - 2 * s + 1) {
			merge(a, b, i, i + s - 1, i + 2 * s - 1);
			i = i + 2 * s;
		}
		if (i < n - s) // 归并最后两个数列
			merge(a, b, i, i + s - 1, n - 1);
		// else {// 只剩单个子序列
		// for (int j = i; j < n; j++)
		// b[j] = a[j];
		// }

		// int count = 0;
		// for (int temp1 : a) {
		// System.out.print(temp1 + ",");
		// }
		// System.out.println();
		// System.out.println("count:" + count++);
	}

	public static void merge(int[] a, int[] b, int left, int mid, int right) {
		int i = left; // 也可以转为一个for循环来写，更加简洁明了
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= right) { // 先将小的排在前面
			if (a[i] < a[j])
				b[k++] = a[i++];
			else
				b[k++] = a[j++];
		}

		while (i <= mid) // 将s[left,mid-1]剩余部分复制到temp[]
			b[k++] = a[i++];

		while (j <= right)
			b[k++] = a[j++];
	}

}