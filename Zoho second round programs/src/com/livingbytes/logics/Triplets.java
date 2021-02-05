package com.livingbytes.logics;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Triplets {

	public static void main(String[] args) {

		List<Integer> inputNumbers = new ArrayList<Integer>();
		Queue<Triplet> triplets = new ArrayDeque<Triplet>();
		int sum = 9;

		for (String value : args) {
			inputNumbers.add(Integer.parseInt(value));
		}

		findTriplets(inputNumbers, triplets, sum);

		for (Triplet triplet : triplets) {
			System.out.println(triplet);
		}
	}

	private static void findTriplets(List<Integer> inputNumbers, Queue<Triplet> triplets, int sum) {
		for (int i = 0; i < inputNumbers.size() - 2; i++) {
			Set<Integer> set = new HashSet<Integer>();
			int tempSum = sum - inputNumbers.get(i);
			
			for (int j = i + 1; j < inputNumbers.size(); j++) {
				if (set.contains(tempSum - inputNumbers.get(j))) {
					
					int product = inputNumbers.get(i) * inputNumbers.get(j) * (tempSum - inputNumbers.get(j));
					if (!isDuplicate(triplets, product)) {
						triplets.add(
								new Triplet(inputNumbers.get(i), inputNumbers.get(j), tempSum - inputNumbers.get(j)));
					}
				} else {
					set.add(inputNumbers.get(j));
				}
			}
		}
	}
	
	private static boolean isDuplicate(Queue<Triplet> triplets, int product) {
		for (Triplet triplet : triplets) {
			if (product == triplet.getProduct()) {
				return true;
			}
		}

		return false;
	}

}
