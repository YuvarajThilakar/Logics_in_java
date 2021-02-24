import java.util.TreeSet;

public class Cab implements Comparable<Cab> {

	private final int taxiNo;
	private float totalEarnings;
	private int tmpDistance;
	private final TreeSet<Customer> allBookings;
	
	public Cab(int taxiNo) {
		this.taxiNo = taxiNo;
		this.totalEarnings = 0;
		this.tmpDistance = 0;
		this.allBookings = new TreeSet<Customer>();
	}
	
	public void setTmpDistance(int distance) {
		this.tmpDistance = distance;
	}
	
	public int getTaxiNo() {
		return this.taxiNo;
	}
	
	public float getTotalEarnings() {
		return this.totalEarnings;
	}
	
	private void addEarnings(float amount) {
		this.totalEarnings += amount;
	}
	
	public int getDistanceFromCustomer(Customer customer) {
		Customer previousBooking = allBookings.floor(customer);
		
		if(previousBooking == null)
			return Math.abs(customer.getPickUpPoint() - 'A');
		
		if(previousBooking.getDropTime() > customer.getCabStartTime())
			return -1;
		
		return Math.abs(previousBooking.getDropPoint() - customer.getPickUpPoint());
	}
	
	public boolean isAvaliable(Customer customer) {
		Customer nextBooking = allBookings.ceiling(customer);
		
		if(nextBooking != null && customer.getDropTime() > nextBooking.getCabStartTime())
			return false;
		
		return true;
	}
	
	
	public void addCustomer(Customer customer) {
		this.allBookings.add(customer);
		this.addEarnings(customer.getAmountPaid());
	}
	
	public void printAllBookings() {
		System.out.println("***************Taxi-" + this.taxiNo +" booking details*******************");
		
		if(allBookings.size() == 0) {
			System.out.println("---");
			return;
		}
		for(Customer customer : allBookings) {
			System.out.println(customer);
		}
	}

	@Override
	public int compareTo(Cab cab) {
		// TODO Auto-generated method stub
		if(this.tmpDistance > cab.tmpDistance)
			return 1;
		else if(this.tmpDistance < cab.tmpDistance)
			return -1;
		return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Taxi-" + this.taxiNo;
	}
	
	
	
//	public static void main(String[] args) {
//		Customer yuvaraj = new Customer("Yuvaraj", 'B', 1, 'C');
//		Customer riyaz = new Customer("Riyaz", 'E', 3, 'F');
//		Customer prakash = new Customer("Prakash", 'A', 5, 'D');
//		
//		Cab cab = new Cab(1);
//		
//		cab.addCustomer(yuvaraj);
//		cab.addCustomer(riyaz);
//		
//		System.out.println(cab.getTotalEarnings());
//	}
}
