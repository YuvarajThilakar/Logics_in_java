package com.livingbytes.flightbookingsystem;

public class Passenger {

	private final int id;
	private final String name;
	private Ticket ticket;
	
	public Passenger(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", name=" + name + "]";
	}
	
}
