package com.shu.stackAndqueue;

public class MyStack {
	private int[] arr;
	// 栈点

	private int top;

	// 构造方法
	public MyStack() {
		arr = new int[20];
		top = -1;
	}

	public MyStack(int maxsize) {
		arr = new int[maxsize];
		top = -1;

	}

	// 压栈
	public void push(int value) {
		arr[++top] = value;

	}

	// 弹栈
	public int pop() {
		return arr[top--];

	}

	// 查看当前
	public int peek() {
		return arr[top];

	}

	// 判断是否为空
	public boolean isEmpty() {
		return top == -1;

	}

	// 判断是否满了
	public boolean isFull() {
		return top == arr.length - 1;
	}

}
