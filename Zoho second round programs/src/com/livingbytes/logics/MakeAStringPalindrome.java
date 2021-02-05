package com.livingbytes.logics;

import java.util.ArrayDeque;
import java.util.Queue;

public class MakeAStringPalindrome {

	public static void main(String[] args) {

		Queue<Integer> removeIndexes = new ArrayDeque<Integer>();

		System.out.println("Input : " + args[0]);

		if (isPalindrome(args[0], removeIndexes)) {
			System.out.println("Indexes should be removed : " + removeIndexes);
		} else {
			System.out.println("Not a palindrome");
		}

	}

	public static boolean isPalindrome(String string, Queue<Integer> removeIndexes) {

		for (int i = 0, j = string.length() - 1; i <= j; i++, j--) {
			if (Character.compare(string.charAt(i), string.charAt(j)) != 0) {
				if (i <= (j - 1)) {
					if (string.charAt(i) == string.charAt(j - 1)) {
						removeIndexes.add(j);
						j--;
					} else if ((i + 1) <= j) {
						if (string.charAt(i + 1) == string.charAt(j)) {
							removeIndexes.add(i);
							i++;
						} else if ((i + 1) <= (j - 1)) {
							if (string.charAt(i + 1) == string.charAt(j - 1)) {
								removeIndexes.add(i);
								removeIndexes.add(j);
								i++;
								j--;
							} else {
								return false;
							}
						}
					}
				}
			}
		}

		return true;
	}
}
