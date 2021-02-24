import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Maintainer {

	public static void main(String[] args) {

		int noOfCabs = 1;

		ArrayList<Cab> listOfCabs = new ArrayList<Cab>();
		PriorityQueue<Cab> tmpPriorityCabs = null;

		try (Scanner scanner = new Scanner(System.in)) {

			for (int i = 0; i < noOfCabs; ++i) {
				listOfCabs.add(new Cab(i));
			}

			while (true) {

				int option;

				System.out.println("1-Book taxi");
				System.out.println("2-Print booking details for particular taxi");
				System.out.println("3-Print booking details for all taxi");
				System.out.println("4-Exit");
				System.out.print("Choose any one of above options : ");
				option = scanner.nextInt();

				switch (option) {
				case 1:
					char pickUpPoint;
					char dropPoint;
					int pickUpTime;
					String name;
					Customer customer;
					tmpPriorityCabs = new PriorityQueue<Cab>(listOfCabs.size());

					System.out.println("********* Book your taxi ***********");
					System.out.println("Kindly enter below values to book taxi.");
					System.out.printf("Name : ");
					name = scanner.next();
					System.out.printf("\nPickup stop : ");
					pickUpPoint = scanner.next().toUpperCase().charAt(0);
					System.out.printf("\nPickup time : ");
					pickUpTime = scanner.nextInt();
					System.out.printf("\nDrop stop : ");
					dropPoint = scanner.next().toUpperCase().charAt(0);

					customer = new Customer(name, pickUpPoint, pickUpTime, dropPoint);

					for (Cab cab : listOfCabs) {
						int distance = cab.getDistanceFromCustomer(customer);
						if (distance >= 0) {
							customer.setCabStartTime(distance/15);
							cab.setTmpDistance(distance);
							tmpPriorityCabs.add(cab);
						}

					}

					if (tmpPriorityCabs.size() == 0) {
						System.out.println("Now there is no cab avaliable now. Please try after some times.");
					} else {
						while (tmpPriorityCabs.peek() != null) {

							Cab cab = tmpPriorityCabs.poll();
							if (cab.isAvaliable(customer)) {
								cab.addCustomer(customer);
								System.out.println("Taxi booked for you...!");
								System.out.println("Taxi " + cab.getTaxiNo() + " is booked for you.");
								break;
							}
							if (tmpPriorityCabs.size() == 0) {
								System.out.println("Now there is no cab avaliable now. Please try after some times.");
							}
						}	
					}

					break;

				case 2:
					int taxiNo;
					System.out.print("Enter taxi number to view details: ");
					taxiNo = scanner.nextInt();
					listOfCabs.get(taxiNo).printAllBookings();
					break;

				case 3:
					for (Cab cab : listOfCabs) {
						cab.printAllBookings();
					}
					break;
				case 4:
					return;
				default:
					System.out.println("Enter valid option");
					break;
				}
				System.out.println();
			}
		}

	}

}
