
public class Customer implements Comparable<Customer> {
	private final String name;
	private final char pickUpPoint;
	private final int pickUpTime;
	private final char dropPoint;
	private final int dropTime;
	private int cabStartTime;
	private final float amountPaid;

	public Customer(String name, char pickUpPoint, int pickUpTime, char dropPoint) {
		this.name = name;
		this.pickUpPoint = pickUpPoint;
		this.pickUpTime = pickUpTime;
		this.dropPoint = dropPoint;
		this.cabStartTime = pickUpTime;
		
		int distance = Math.abs(this.pickUpPoint - this.dropPoint) * 15;
		
		this.amountPaid = 100 + (distance-5) * 10;
		this.dropTime = pickUpTime + distance/15;
		
	}

	public String getName() {
		return name;
	}

	public char getPickUpPoint() {
		return pickUpPoint;
	}

	public int getPickUpTime() {
		return pickUpTime;
	}

	public char getDropPoint() {
		return dropPoint;
	}

	public int getDropTime() {
		return dropTime;
	}

	public float getAmountPaid() {
		return amountPaid;
	}
	
	public void setCabStartTime(int cabStartTime) {
		this.cabStartTime = this.pickUpTime - cabStartTime;
	}
	
	public int getCabStartTime() {
		return this.cabStartTime;
	}

	@Override
	public int compareTo(Customer customer) {
		if(this.cabStartTime > customer.cabStartTime)
			return 1;
		else if(this.cabStartTime < customer.cabStartTime) 
			return -1;
		else 
			return 0;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(name);
		stringBuffer.append("   ");
		stringBuffer.append(pickUpPoint);
		stringBuffer.append("   ");
		stringBuffer.append(pickUpTime);
		stringBuffer.append("   ");
		stringBuffer.append(dropPoint);
		stringBuffer.append("   ");
		stringBuffer.append(dropTime);
		stringBuffer.append("   ");
		stringBuffer.append(amountPaid);
		
		return stringBuffer.toString();
	}
	
	
	public static void main(String[] args) {
		Customer customer = new Customer("Yuvaraj", 'B', 2, 'D');
		System.out.println(customer);
	}
	
}
