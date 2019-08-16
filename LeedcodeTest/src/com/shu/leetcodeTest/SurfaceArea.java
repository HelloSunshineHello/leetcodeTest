package com.shu.leetcodeTest;

import java.util.Arrays;

/**
 * 求取不规则的表面积 ； 360在线笔试题一
 * 
 * @author 28194
 *
 */
public class SurfaceArea {
	public static void main(String[] args) {
		int[][] array = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 11, 12 } };
		surfaceArea(4, 3, array);
	}

	public static int surfaceArea(int N, int M, int[][] array) {
		int sum = 0;
		//
		// for (int i = 0; i < M; i++) {
		// // int[] a = new int[N];
		// for (int j = 0; j < N; j++) {
		// System.out.print(array[i][j] + "\t");
		// }
		// System.out.println();
		// }
		// System.out.println("-------------");
		for (int i = 0; i < N; i++) {
			int[] a = new int[M];
			for (int j = 0; j < M; j++) {
				a[j] = array[i][j];
			}
			Arrays.sort(a);
			System.out.println("a[M - 1]:" + a[M - 1]);
			sum += a[M - 1];
		}
		System.out.println(sum);

		// array = reverse(M, N, array);
		array = reverse02(array);
		// for (int i = 0; i < M; i++) {
		// // int[] a = new int[N];
		// for (int j = 0; j < N; j++) {
		// System.out.print(array[i][j] + "\t");
		// }
		// System.out.println();
		// }
		// System.out.println("***********");
		for (int i = 0; i < M; i++) {
			int[] a = new int[N];
			for (int j = 0; j < N; j++) {
				a[j] = array[i][j];
			}
			Arrays.sort(a, 0, N - 1);
			System.out.println("a[N - 1]:" + a[N - 1]);
			sum += a[N - 1];
		}
		// System.out.println(sum);
		sum = 2 * sum;
		// System.out.println(sum);
		sum += 2 * N * M;
		System.out.println(sum);
		return sum;

	}

	// m==n的二维数组，不具通用性
	public static void reverse01(int[][] temp) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = i; j < temp[i].length; j++) {
				int k = temp[i][j];
				temp[i][j] = temp[j][i];
				temp[j][i] = k;
			}
		}
	}

	// 将N*M二维数组转置M*N
	public static int[][] reverse(int M, int N, int[][] a) {
		// int a[][] = { { 1, 2, 3, 4 }, { 2, 3, 4, 5 }, { 3, 4, 5, 6 } };
		// int m= a.length;
		// int n= a[0].length;
		int b[][] = new int[N][M];
		for (int i = 0; i < b.length; i++) {
			for (int j = 0; j < b[i].length; j++) {
				b[i][j] = a[j][i];
			}
		}

		// 打印输出
		// for (int i = 0; i < b.length; i++) {
		// for (int j = 0; j < b[i].length; j++) {
		// System.out.print(b[i][j] + " ");
		// }
		// System.out.println();
		// }
		return b;
	}

	public static int[][] reverse02(int[][] A) {
		int m = A.length;
		int n = A[0].length;
		int[][] B = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				B[j][i] = A[i][j];
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.print(B[i][j] + "\t");
			}
			System.out.println();
		}
		return B;
	}
}
