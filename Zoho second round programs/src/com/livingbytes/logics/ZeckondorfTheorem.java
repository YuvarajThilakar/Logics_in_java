package com.livingbytes.logics;

import java.time.LocalDateTime;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class ZeckondorfTheorem {

	public static void main(String[] args) {

		int inputNumber = Integer.parseInt(args[0]);

		Stack<Integer> fibanacci = new Stack<Integer>();
		Queue<Integer> zeckondorfNumbers = new ArrayDeque<Integer>();

		fibanacciSeries(inputNumber, fibanacci);

		System.out.println(fibanacci);
		System.out.println(LocalDateTime.now());
		zeckondorfNumbers(fibanacci, zeckondorfNumbers, inputNumber);
		System.out.println(LocalDateTime.now());
		System.out.println(zeckondorfNumbers);
		
		for (Integer value : zeckondorfNumbers) {
			System.out.println(value);
		}

	}

	private static void zeckondorfNumbers(Stack<Integer> fibanacci, Queue<Integer> zeckondorfNumbers, int inputNumber) {
		int total = 0;

		while (total < inputNumber) {
			if (fibanacci.peek() + total <= inputNumber) {
				zeckondorfNumbers.add(fibanacci.peek());
				
				total += fibanacci.pop();
				fibanacci.pop();
			}else {
				fibanacci.pop();
			}
		}

	}

	public static void fibanacciSeries(int inputNumber, Stack<Integer> fibanacci) {

		int firstNumber;
		int secondNumber;

		fibanacci.push(0);
		firstNumber = 0;
		if (inputNumber == 0)
			return;

		fibanacci.push(1);
		secondNumber = 1;
		if (inputNumber == 1)
			return;

		while ((firstNumber + secondNumber) <= inputNumber) {

			fibanacci.push(firstNumber + secondNumber);
			firstNumber = secondNumber;
			secondNumber = fibanacci.peek();

		}

	}

}
