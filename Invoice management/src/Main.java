import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import customer.CustomerExceptions;
import customer.CustomerManager;
import foods.FoodManager;
import invoice.FoodQuantity;
import invoice.Invoice;

public class Main {

	public static void main(String[] args) throws CustomerExceptions {
		int invoiceId = 100;
		Scanner scanner = new Scanner(System.in);

		FoodManager foodManager = new FoodManager();
		initializeFoods(foodManager);

		CustomerManager customerManager = new CustomerManager();
		initializeCustomers(customerManager);

		while (true) {
			String inputOption = scanner.nextLine().toLowerCase();

			String inputOptionArray[] = inputOption.split(" ");

			switch (inputOptionArray[0]) {
			case "bf":
				foodManager.printAvaliableFoods();
				List<FoodQuantity> foodQuantities = new ArrayList<FoodQuantity>();

				for (int i = 1; i < inputOption.length(); i = i + 2) {
					foodQuantities.add(foodManager.buyItem(inputOptionArray[i], Double.parseDouble(inputOptionArray[i + 1])));
				}

				System.out.println("\nEnter your aadhar no: ");
				int aadharNo = scanner.nextInt();

				customerManager.addInvoice(aadharNo, new Invoice(invoiceId++, aadharNo));
				break;
			case "ca":
				

			default:
				break;
			}

		}

	}

	private static void initializeFoods(FoodManager foodManager) {

		foodManager.addFood("Tomato", 20);
		foodManager.addFood("Onion", 80);
		foodManager.addFood("Brinjal", 35.5);
		foodManager.addFood("Ladies finger", 40);
		foodManager.addFood("Chilly", 45.75);
		foodManager.addFood("Rice", 67);
		foodManager.addFood("Wheat", 45.75);
		foodManager.addFood("Carrot", 50);
		foodManager.addFood("Beans", 40);
		foodManager.addFood("Watermellon", 25);
		foodManager.addFood("Coconut", 45);

	}

	private static void initializeCustomers(CustomerManager customerManager) {

		try {
			customerManager.addCustomer(12345, "Yuvaraj");
			customerManager.addCustomer(67890, "Srinath");
			customerManager.addCustomer(13579, "Goki");
			customerManager.addCustomer(24680, "Krishna");

		} catch (CustomerExceptions e) {
			System.out.println(e.getMessage());
		}

	}

}
