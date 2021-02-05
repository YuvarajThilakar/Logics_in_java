package com.livingbytes.logics;

public class SnakePattern {

	public static void main(String[] args) {

		int totalLength = Integer.parseInt(args[0]);
		int rows = Integer.parseInt(args[1]);
		int tmp = 1;
		int columns = calculateColumn(totalLength, rows);

		int[][] patternArray = new int[rows][columns];

		for (int i = 0, j = 0; tmp <= totalLength; j++) {

			if (j % 2 == 0) {
				for (; i < rows && tmp <= totalLength; i++) {
					patternArray[i][j] = tmp++;
				}
				i--;
			} else {
				for (; i >= 0 && tmp <= totalLength; i--) {
					patternArray[i][j] = tmp++;
				}
				i++;
			}

		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (patternArray[i][j] != 0)
					System.out.print(patternArray[i][j] + " ");
			}
			System.out.println();
		}

	}

	private static int calculateColumn(int totalLength, int rows) {

		return (int) Math.ceil((double) totalLength / rows);

	}

}
