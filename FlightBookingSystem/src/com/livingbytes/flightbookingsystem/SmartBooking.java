package com.livingbytes.flightbookingsystem;

import java.util.Map;
import java.util.TreeMap;

import com.livingbytes.flightbookingsystem.exception.FlightNotFoundException;
import com.livingbytes.flightbookingsystem.exception.PassengerAlreadyBookedException;
import com.livingbytes.flightbookingsystem.exception.PassengerNotFoundException;
import com.livingbytes.flightbookingsystem.exception.TicketFulledException;

public class SmartBooking {

	private int flightId;
	private int passengerId;
	private Map<Integer, Flight> flights;
	private Map<Integer, Passenger> passengers;

	public SmartBooking() {

		flightId = 101;
		passengerId = 1001;

		flights = new TreeMap<Integer, Flight>();
		passengers = new TreeMap<Integer, Passenger>();
	}

	public String addFlight(String name, int mealPrice, int economySeatPrice, int economyCurrentSeatNo,
			int businessSeatPrice, int businessCurrentSeatNo) {
		flights.put(flightId, new Flight(flightId, name, mealPrice, economySeatPrice, economyCurrentSeatNo,
				businessSeatPrice, businessCurrentSeatNo));

		return name + " : " + flightId++;
	}

	public String addPassenger(String name) {
		passengers.put(passengerId, new Passenger(passengerId, name));

		return name + " : " + passengerId++;
	}

	public Ticket bookTicket(int flightId, String classType, int passengerId)
			throws TicketFulledException, PassengerNotFoundException, FlightNotFoundException, ClassNotFoundException,
			PassengerAlreadyBookedException {

		Flight flight = isFlightAvaliable(flightId);
		Passenger passenger = isPassengerAvaliable(passengerId);

		if (passenger.getTicket() != null)
			throw new PassengerAlreadyBookedException(
					"Already booked ticket found with this account. Cancel ticket to book another...!");

		if (classType.toUpperCase().equals("BUSINESS"))
			flight.bookBusinessTicket(passenger);
		else if (classType.toUpperCase().equals("ECONOMY"))
			flight.bookEconomyTicket(passenger);
		else
			throw new ClassNotFoundException("Class type is not found exception...!");

		return passenger.getTicket();
	}

	public int cancelTicket(int passengerId, int flightId) throws PassengerNotFoundException, FlightNotFoundException {
		
		Flight flight = isFlightAvaliable(flightId);
		Passenger passenger = isPassengerAvaliable(passengerId);
		
		return flight.cancelTicket(passenger);
	}
	
	public void printFlightSummary(int flightId) throws FlightNotFoundException {
		
		Flight flight = isFlightAvaliable(flightId);
		flight.printFlightSummary();
	}

	public void printAllFlightSummary() throws FlightNotFoundException {
		
		for(Integer flightId: flights.keySet()) {
			printFlightSummary(flightId);
			System.out.println();
		}
		
	}
	
	private Passenger isPassengerAvaliable(int passengerId) throws PassengerNotFoundException {
		Passenger passenger = passengers.get(passengerId);
		if (passenger == null)
			throw new PassengerNotFoundException("User not found...!");
		return passenger;
	}

	private Flight isFlightAvaliable(int flightId) throws FlightNotFoundException {
		Flight flight = flights.get(flightId);
		if (flight == null)
			throw new FlightNotFoundException("Specified flight is not found...!");

		return flight;
	}
	
	public static void main(String[] args) {
		
		SmartBooking smartBooking = new SmartBooking();
		
		smartBooking.addFlight("Flying Bytes", 2000, 9500, 60, 13000, 60);
		smartBooking.addFlight("Fire bird", 300, 2000, 30, 5000, 24);
		smartBooking.addPassenger("Gokila surya");
		smartBooking.addPassenger("Yuvaraj");
		smartBooking.addPassenger("Srinath");
		smartBooking.addPassenger("Krishna");
		
		try {
			
			System.out.println(smartBooking.bookTicket(102, "business", 1001));
			System.out.println(smartBooking.bookTicket(101, "business", 1002));
			System.out.println(smartBooking.bookTicket(101, "business", 1003));
			
			System.out.println(smartBooking.bookTicket(101, "business", 1004));
			
			smartBooking.printAllFlightSummary();
			
			
		} catch (ClassNotFoundException | TicketFulledException | PassengerNotFoundException | FlightNotFoundException
				| PassengerAlreadyBookedException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
























