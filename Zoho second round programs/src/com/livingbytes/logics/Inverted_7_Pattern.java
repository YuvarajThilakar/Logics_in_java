package com.livingbytes.logics;

public class Inverted_7_Pattern {

	public static void main(String[] args) {

		int inputNumber = Integer.parseInt(args[0]);
		int[][] pattern = new int[inputNumber][inputNumber];

		for (int i = 0, j = 0; i < inputNumber && j < inputNumber; i++, j++) {
			
			for (int x = i; x < inputNumber; x++)
				pattern[x][j] = inputNumber - i;

			for (int y = j; y < inputNumber; y++)
				pattern[i][y] = inputNumber - j;

		}

		for (int i = 0; i < inputNumber; i++) {
			for (int j = 0; j < inputNumber; j++) {
				System.out.print(pattern[i][j] + " ");
			}
			System.out.println();
		}

	}

}
