package com.livingbytes.logics;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeSet;

public class OptimizedZeckondorfTheorem {

	public static void main(String[] args) {
		int inputNumber = Integer.parseInt(args[0]);
		
		TreeSet<Integer> fibanocci = new TreeSet<Integer>();
		
		fibanacciSeries(inputNumber, fibanocci);
		
		System.out.println(fibanocci);
		
		Queue<Integer> output = new ArrayDeque<Integer>();
		
		optimizedZecKondorfTheorem(fibanocci, output, inputNumber);

		System.out.println(output);
	}
	
	public static void optimizedZecKondorfTheorem(TreeSet<Integer> fibanocci, Queue<Integer> output, int inputNumber) {
		int currentNumber = inputNumber;
		int total = 0;

		while(total != inputNumber) {
			currentNumber = fibanocci.floor(inputNumber - total); 
			output.add(currentNumber);
			fibanocci.remove(fibanocci.floor(currentNumber-1)); 
			total += currentNumber; 
		}
	}

	public static void fibanacciSeries(int inputNumber, TreeSet<Integer> fibanocci) {
		int firstNumber;
		int secondNumber;

		fibanocci.add(0);
		firstNumber = 0;
		if (inputNumber == 0)
			return;

		fibanocci.add(1);
		secondNumber = 1;
		if (inputNumber == 1)
			return;

		while ((firstNumber + secondNumber) <= inputNumber) {
			fibanocci.add(firstNumber + secondNumber);
			firstNumber = secondNumber;
			secondNumber = fibanocci.last();
		}

	}
	
}
