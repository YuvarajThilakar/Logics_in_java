package com.livingbytes.flightbookingsystem;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.TreeMap;

import com.livingbytes.flightbookingsystem.exception.TicketFulledException;

public class Flight {

	private final int id;
	private final String name;
	private final int mealPrice;
	private final int economySeatPrice;
	private int economySurgePrice;
	private int economyCurrentSeatNo;
	private final int businessSeatPrice;
	private int businessSurgePrice;
	private int businessCurrentSeatNo;
	private TreeMap<Integer, Ticket> economyClassTickets;
	private TreeMap<Integer, Ticket> businessClassTickets;
	private Queue<Ticket> cancledEconomyTickets;
	private Queue<Ticket> cancledBusinessTickets;

	public Flight(int id, String name, int mealPrice, int economySeatPrice, int economyCurrentSeatNo,
			int businessSeatPrice, int businessCurrentSeatNo) {
		
		super();
		this.id = id;
		this.name = name;
		this.mealPrice = mealPrice;
		this.economySeatPrice = economySeatPrice;
		this.economyCurrentSeatNo = economyCurrentSeatNo;
		this.businessSeatPrice = businessSeatPrice;
		this.businessCurrentSeatNo = businessCurrentSeatNo;
		economyClassTickets = new TreeMap<Integer, Ticket>();
		businessClassTickets = new TreeMap<Integer, Ticket>();
		cancledEconomyTickets = new ArrayDeque<Ticket>();
		cancledBusinessTickets = new ArrayDeque<Ticket>();
		economySurgePrice = 0;
		businessSurgePrice = 0;
	}
	
	public void bookEconomyTicket(Passenger passenger) throws TicketFulledException {
		Ticket ticket = null;
		
		if(economyCurrentSeatNo > 0) {
			ticket = new Ticket(economyCurrentSeatNo, "ECONOMY", economySeatPrice + economySurgePrice, passenger, mealPrice);
			economyClassTickets.put(economyCurrentSeatNo, ticket);
			economyCurrentSeatNo--;
			economySurgePrice += 50;
			passenger.setTicket(ticket);
			return;
		}
		
		if(cancledEconomyTickets.size() > 0) {
			ticket = cancledEconomyTickets.poll();
			ticket.setCost(economySeatPrice + economySurgePrice);
			ticket.setPassenger(passenger);
			economyClassTickets.put(ticket.getSeatNumber(), ticket);
			passenger.setTicket(ticket);
			return;
		}
		
		throw new TicketFulledException("Economy class is House Full...!");	
	}
	
	public void bookBusinessTicket(Passenger passenger) throws TicketFulledException {
		Ticket ticket = null;
		
		if(businessCurrentSeatNo > 0) {
			ticket = new Ticket(businessCurrentSeatNo, "BUSINESS", businessSeatPrice + businessSurgePrice, passenger, mealPrice);
			businessClassTickets.put(businessCurrentSeatNo, ticket);
			businessCurrentSeatNo--;
			businessSurgePrice += 100;
			passenger.setTicket(ticket);
			return;
		}
		
		if(cancledBusinessTickets.size() > 0) {
			ticket = cancledBusinessTickets.poll();
			
			ticket.setCost(businessSeatPrice + businessSurgePrice);
			ticket.setPassenger(passenger);
			
			businessClassTickets.put(ticket.getSeatNumber(), ticket);
			passenger.setTicket(ticket);
			return;
		}
		
		throw new TicketFulledException("Business class is House Full...!");	
	}

	public int cancelTicket(Passenger passenger) {
		
		Ticket ticket = passenger.getTicket();
		
		int refund = ticket.getCost();
		refund += mealPrice;
		
		passenger.setTicket(null);
		ticket.setPassenger(null);
		
		if(ticket.getClassType().equals("ECONOMY")) {
			economyClassTickets.remove(ticket.getSeatNumber());
			cancledEconomyTickets.add(ticket);
		} else {
			businessClassTickets.remove(ticket.getSeatNumber());
			cancledBusinessTickets.add(ticket);
		}
		
		return refund;
	}
	
	public void printFlightSummary() {
		
		System.out.println("************ FLIGHT SUMMARY *************");
		
		System.out.println("Flight code : " + id);
		System.out.println("Flight name : " + name);
		
		System.out.println("Flight meal price : " + mealPrice);
		System.out.println("Flight Business seat price : " + businessSeatPrice);
		System.out.println("Flight Economy seat price : " + economySeatPrice);
		
		System.out.println("No of Business seats booked : "  + businessClassTickets.size());
		System.out.println("No of Economy seats booked : " + economyClassTickets.size());
		
		System.out.println("No of free Business seats : " + (businessCurrentSeatNo + cancledBusinessTickets.size()));
		System.out.println("No of free Economy seats : " + (economyCurrentSeatNo + cancledEconomyTickets.size()));
		
		System.out.println("Total no of Business seats : " + (businessCurrentSeatNo + businessClassTickets.size() + cancledBusinessTickets.size()));
		System.out.println("Total no of Economy seats : " + (economyCurrentSeatNo + economyClassTickets.size() + cancledEconomyTickets.size()));
		
		System.out.println("Business passengers : ");
		for(Integer passengerId: businessClassTickets.keySet()) {
			System.out.println(businessClassTickets.get(passengerId));
		}
		
		System.out.println("Economy passengers : ");
		for(Integer passengerId: economyClassTickets.keySet()) {
			System.out.println(economyClassTickets.get(passengerId));
		}
	}
	
	
}
