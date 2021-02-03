package com.livingbytes.logics;

import java.util.Arrays;

public class RemoveDuplicateInInplace {

	// 2n + n * log n
	public static void main(String[] args) {

		int[] inputArray = { 2, 2, 4, 7, 4, 5, 19, 13, 22, 22, 5 };
		int firstEntry = 0;
		
		//Quick sort -> n * log n
		Arrays.sort(inputArray);

		for (int i = 0; i < inputArray.length -1; i++) {
			if(inputArray[i] == inputArray[i+1]) {
				inputArray[i] = inputArray[firstEntry];
				firstEntry++;
			}
		}
		
		for(int i= firstEntry; i<inputArray.length; i++) {
			System.out.print(inputArray[i] + " ");
		}

	}

}
