package com.livingbytes.flightbookingsystem;

public class Ticket{

	private final int seatNumber;
	private final String classType;
	private boolean isBooked;
	private int cost;
	private final int mealPrice;
	private Passenger passenger;
	
	public Ticket(int seatNumber, String classType, int cost, Passenger passenger, int mealPrice) {
		super();
		this.seatNumber = seatNumber;
		this.classType = classType;
		this.cost = cost;
		this.passenger = passenger;
		this.mealPrice = mealPrice;
		this.isBooked = true;
	}

	public boolean isBooked() {
		return isBooked;
	}

	public void setBooked(boolean isBooked) {
		this.isBooked = isBooked;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getMealPrice() {
		return mealPrice;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public int getSeatNumber() {
		return seatNumber;
	}

	public String getClassType() {
		return classType;
	}

	@Override
	public String toString() {
		return "Ticket [seatNumber=" + seatNumber + ", classType=" + classType + ", isBooked=" + isBooked + ", cost="
				+ cost + ", mealPrice=" + mealPrice + ", passenger=" + passenger + "]";
	}

	
	
}
