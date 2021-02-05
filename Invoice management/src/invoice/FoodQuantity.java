package invoice;

import foods.Food;

public class FoodQuantity {

	private double quantity;
	private double totalPrice;
	private Food food;
	
	public FoodQuantity(double quantity, Food food) {
		super();
		this.quantity = quantity;
		this.food = food;
		this.calculatePrice();
	}
	
	public double calculatePrice() {
		this.totalPrice = this.quantity * food.getPrice();
		return this.totalPrice;
	}
	
	public void reduceQuantity(double quantity) {
		if(this.quantity >= quantity)
			this.quantity -= quantity;
		calculatePrice();
	}

	@Override
	public String toString() {
		return "ItemQuantity [food=" + food + ", quantity=" + quantity + ", totalPrice=" + totalPrice  + "]";
	}
	
	
}
