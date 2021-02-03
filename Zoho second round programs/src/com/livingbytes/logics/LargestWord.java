package com.livingbytes.logics;

public class LargestWord {

	public static void main(String[] args) {

		int maxLength = Integer.MIN_VALUE;
		int maxIndex = 0;
		int[] charPosition = new int[256];
		int strLength = 0;

		// k => k * 2n
		for (int i = 0; i < args.length; i++) {

			strLength = 0;
			// n
			for (int j = 0; j < args[i].length(); j++) charPosition[args[i].charAt(j)]++;
			
			// n
			for(int j=0; j< args[i].length(); j++) {
				if(charPosition[args[i].charAt(j)] != 0) {
					strLength++;
					charPosition[args[i].charAt(j)] = 0;
				}
			}
			
			System.out.println(args[i] + " : " + strLength);
			
			if(strLength > maxLength) {
				maxLength = strLength;
				maxIndex = i;
			}
		}
		
		System.out.println(args[maxIndex]);

	}

}
