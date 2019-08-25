package com.shu.stackAndqueue;

public class MyQueue {

	private int[] arr;
	private int Element;
	// 队首
	private int front;
	// 队尾
	private int end;

	// 构造方法
	public MyQueue() {
		arr = new int[20];
		front = 0;
		Element = 0;
		end = -1;
	}

	public MyQueue(int maxsize) {
		arr = new int[maxsize];
		Element = 0;
		front = 0;
		end = -1;
	}

	// 进入队列
	public void push(int value) {
		if (end == arr.length - 1) {
			end = -1;
		}
		arr[++end] = value;
		Element++;
	}

	// 出来队列
	public int pop() {
		int value = arr[front++];
		if (front == arr.length) {
			front = 0;
		}
		Element--;
		return value;
	}

	// 查看当前
	public int peek() {
		return arr[front];
	}

	// 判断是否为空
	public boolean isEmpty() {
		return Element == 0;
	}

	// 判断是否满了
	public boolean isFull() {
		return Element == arr.length;
	}
}
