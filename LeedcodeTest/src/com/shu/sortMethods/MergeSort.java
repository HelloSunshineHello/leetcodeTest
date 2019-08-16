package com.shu.sortMethods;

/**
 * 1、选择排序（直接选择排序，堆排序） 2、交换排序（冒泡排序，快速排序） 3、插入排序（直接插入排序，希尔排序） 4、归并排序 5、桶式排序 6、基数排序
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] a = { 1, 34, 5, 7, 4, 2, 3, 9, 12, 55, 13, 12, 45, 32, 23, 18, 67 };

		mergeSort(a, 0, a.length - 1);
		// for (int temp1 : a) {
		// System.out.print(temp1 + ",");
		// }
		// System.out.println();
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

}