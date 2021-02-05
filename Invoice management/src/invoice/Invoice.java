package invoice;

import java.time.LocalDateTime;
import java.util.List;

public class Invoice {

	private int invoiceId;
	private int customerAadharNo;
	private double totalPrice;
	private LocalDateTime purchasedDateTime;
	private List<FoodQuantity> purchasedFoods;
	
	public Invoice(int invoiceId, int customerId) {
		super();
		this.invoiceId = invoiceId;
		this.customerAadharNo = customerId;
		this.purchasedDateTime = LocalDateTime.now();
	}
	
	public void addItem(FoodQuantity item) {
		purchasedFoods.add(item);
		calculateTotalPrice();
	}
	
	public void removeItem(int index) {
		purchasedFoods.remove(index);
		calculateTotalPrice();
	}
	
	public void reduceQuantity(int index, double quantity) {
		purchasedFoods.get(index).reduceQuantity(quantity);
		calculateTotalPrice();
	}
	
	private void calculateTotalPrice() {
		for(FoodQuantity foodQuantity : purchasedFoods) {
			this.totalPrice += foodQuantity.calculatePrice();
		}
	}
	
	public void printSummary() {
		System.out.println("****** Invoice : " + this.invoiceId + " ******");
		System.out.println("Customer Id : " + this.customerAadharNo);
		System.out.println("Total price : " + this.totalPrice);
		System.out.println("Purchased date and time" + this.purchasedDateTime);
		
		System.out.println("Purchased Foods : ");
		for(FoodQuantity item : purchasedFoods) {
			System.out.println(item.toString());
		}
	}
	
}
