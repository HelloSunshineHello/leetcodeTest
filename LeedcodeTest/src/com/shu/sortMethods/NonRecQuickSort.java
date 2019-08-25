package com.shu.sortMethods;

import java.util.Arrays;
import java.util.Stack;

/**
 * 快速排序的非递归的实现方法 ， 利用栈来模拟
 */
public class NonRecQuickSort {
	public static void main(String[] args) {
		int[] a = { 1, 34, 5, 7, 4, 2, 3, 9, 37, 23, 34, 21, 18, 67, 12, 57 };
		// quickSort(a, 0, a.length - 1);
		// quickSort01(a, 0, a.length - 1);
		nonRec_quickSort(a, 0, a.length - 1);
	}

	private static void nonRec_quickSort(int[] a, int start, int end) {
		// 用栈模拟
		Stack<Integer> stack = new Stack<>();
		if (start < end) {
			stack.push(end);
			stack.push(start);
			while (!stack.isEmpty()) {
				int l = stack.pop();
				int r = stack.pop();
				int index = partition(a, l, r);
				if (l < index - 1) {
					stack.push(index - 1);
					stack.push(l);
				}
				if (r > index + 1) {
					stack.push(r);
					stack.push(index + 1);
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

	public void nonRecrutSort(int[] a) {// 非递归快排，两个栈
		// 设置两个栈，一个用于保存
		if (a == null || a.length < 0)
			return;
		Stack<Integer> startStack = new Stack<Integer>();// 保存当前划分的最高位
		Stack<Integer> endStack = new Stack<Integer>();// 保存当前划分的最低位
		int start = 0;
		int end = a.length - 1;

		int pivotPos;

		startStack.push(start);
		endStack.push(end);

		while (!startStack.isEmpty()) {
			start = startStack.pop();
			end = endStack.pop();
			pivotPos = partition(a, start, end);
			if (start < pivotPos - 1) {
				startStack.push(start);
				endStack.push(pivotPos - 1);
			}
			if (end > pivotPos + 1) {
				startStack.push(pivotPos + 1);
				endStack.push(end);
			}
		}
	}

	public void nonRecrutQuickSort(int a[]) {
		if (a == null || a.length <= 0)
			return;
		Stack<Integer> index = new Stack<Integer>(); // 用一个栈存储分界点位置的
		int start = 0;
		int end = a.length - 1;

		int pivotPos;

		index.push(start);
		index.push(end);

		while (!index.isEmpty()) {
			end = index.pop();
			start = index.pop();

			pivotPos = partition(a, start, end);
			if (start < pivotPos - 1) {
				index.push(start);
				index.push(pivotPos - 1);
			}
			if (end > pivotPos + 1) {
				index.push(pivotPos + 1);
				index.push(end);
			}
		}
	}

	// 寻找枢轴的位置
	private static int partition(int[] a, int start, int end) {
		int pivot = a[start];
		while (start < end) {
			while (start < end && a[end] >= pivot)
				end--;
			a[start] = a[end];
			while (start < end && a[start] <= pivot)
				start++;
			a[end] = a[start];
		}
		a[start] = pivot;
		return start;
	}

}
