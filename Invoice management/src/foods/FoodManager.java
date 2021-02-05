package foods;

import java.util.HashMap;
import java.util.Map;

import invoice.FoodQuantity;

public class FoodManager {

	private Map<String, Food> listOfFoods;

	public FoodManager() {
		this.listOfFoods = new HashMap<String, Food>();
	}

	public void printAvaliableFoods() {
		System.out.println();
		System.out.println("********** Welcome to busy market ***********");
		System.out.println("Avaliable foods");
		for (String value : listOfFoods.keySet()) {
			System.out.println(value + " : " + listOfFoods.get(value));
		}
	}

	public void addFood(String foodName, double price) {
		listOfFoods.put(foodName, new Food(foodName.toLowerCase(), price));
	}

	public void removeItem(String foodName) {
		listOfFoods.remove(foodName);
	}

	public FoodQuantity buyItem(String foodName, double quantity) {
		Food food = listOfFoods.get(foodName);
		System.out.println(food);
		return new FoodQuantity(quantity, food);
	}

}
