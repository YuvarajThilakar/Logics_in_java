package Second.Round;

import java.util.Stack;

public class PrintingNumberToWords {

	public static void main(String[] args) {

		int inputNumber = Integer.parseInt(args[0]);
		Stack<Integer> stack = new Stack<Integer>();
		int position = 0;
		String numberInString = "";

		String[] ones = { "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine" };
		String[] tens = { "", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninty" };
		String[] teens = { "", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
				"Eighteen", "Ninteen" };
		String[] hundredAndThousand = { "Hundred", "Thousand" };

		if (inputNumber == 0)
			System.out.println("Zero");

		position = parseInputNumber(stack, inputNumber);

		while (stack.size() > 0) {
			int number = stack.pop();

			switch (position--) {
			case 4:
				if (number != 0) {
					numberInString += " " + ones[number];
					numberInString += " " + hundredAndThousand[1];
				}
				break;
			case 3:
				if (number != 0) {
					numberInString += " " + ones[number];
					numberInString += " " + hundredAndThousand[0];
				}
				break;
			case 2:
				if (numberInString.length() > 0 && number != 0) {
					numberInString += " and";
				}

				if (number == 1) {
					number = stack.pop();
					numberInString += " " + teens[number];
					break;
				}

				numberInString += " " + tens[number];
				break;
			case 1:
				numberInString += " " + ones[number];
				break;
			}

		}
		System.out.println(numberInString);

	}

	private static int parseInputNumber(Stack<Integer> stack, int inputNumber) {

		int position = 0;
		int number = 0;

		while (inputNumber > 0) {
			number = inputNumber % 10;
			stack.add(number);
			inputNumber = inputNumber / 10;
			position++;
		}

		return position;
	}

}
