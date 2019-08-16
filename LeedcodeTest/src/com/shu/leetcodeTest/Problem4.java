package com.shu.leetcodeTest;

public class Problem4 {
	public static void main(String[] args) {
		int[] nums1 = { 1, 3 };
		int[] nums2 = { 2, 4, 4 };
		findMedianSortedArrays01(nums1, nums2);
		findMedianSortedArrays02(nums1, nums2);
		findMedianSortedArrays03(nums1, nums2);
	}

	// 方法一 ：二分查找法
	public static double findMedianSortedArrays01(int[] nums1, int[] nums2) {
		int m = nums1.length;
		int n = nums2.length;
		if (m > n) { // 保证 m<=n
			int[] a = nums1;
			nums1 = nums2;
			nums2 = a;

			int temp = m;
			m = n;
			n = temp;
		}

		int low = 0;
		int high = m;
		int half = (m + n + 1) / 2;

		while (low <= high) {
			int i = (low + high) / 2;
			int j = half - i;
			if (i < high && nums1[i] < nums2[j - 1]) {
				low = i + 1; // i 太小
			} else if (i > low && nums1[i - 1] > nums2[j]) {
				high = i - 1; // i太大
			} else {
				int leftMax = 0;
				if (i == 0)
					leftMax = nums2[j - 1];
				else if (j == 0)
					leftMax = nums1[i - 1];
				else
					leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
				if ((m + n) % 2 == 1) {
					System.out.println(leftMax);
					return leftMax;
				}

				int rightMin = 0;
				if (i == m)
					rightMin = nums2[j];
				else if (j == n)
					rightMin = nums1[i];
				else
					rightMin = Math.min(nums1[i], nums2[j]);
				System.out.println((leftMax + rightMin) / 2.0);
				return (leftMax + rightMin) / 2.0;
			}
		}
		System.out.println(0.0);
		return 0.0;
	}

	// 方法二：归并法,完全排好了，再选择中位数
	public static double findMedianSortedArrays02(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int[] C = new int[m + n];

		int i = 0;
		int j = 0;
		int k = 0;
		while (i < m && j < n) {
			if (A[i] < B[j]) {
				C[k++] = A[i++];
			} else {
				C[k++] = B[j++];
			}
		}
		if (i == m) {
			while (j < n)
				C[k++] = B[j++];
		}
		if (j == n) {
			while (i < m)
				C[k++] = A[i++];
		}
		// System.out.println(k);
		// System.out.println(k % 2 == 1 ? C[k / 2] : (C[k / 2 - 1] + C[k / 2]) / 2.0);
		return k % 2 == 1 ? C[k / 2] : (C[k / 2 - 1] + C[k / 2]) / 2.0;
	}

	// 方法三：类似方法二，只排好到中位数的位置，即找到中位数就不再管了
	public static double findMedianSortedArrays03(int[] A, int[] B) {
		int m = A.length;
		int n = B.length;
		int len = (m + n) / 2 + 1;
		int[] C = new int[len];

		int i = 0;
		int j = 0;
		int k = 0;
		while (i < m && j < n && k < len) {
			if (A[i] < B[j]) {
				C[k++] = A[i++];
			} else {
				C[k++] = B[j++];
			}

		}
		if (i == m) {
			while (j < n && k < len)
				C[k++] = B[j++];
		}
		if (j == n) {
			while (i < m && k < len)
				C[k++] = A[i++];
		} // k==len;
		System.out.println(k);
		System.out.println((m + n) % 2 == 1 ? C[k - 1] : (C[k - 1] + C[k - 2]) / 2.0);
		return (m + n) % 2 == 1 ? C[k - 1] : (C[k - 1] + C[k - 2]) / 2.0;
	}

}
