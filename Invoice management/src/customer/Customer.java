package customer;

import java.util.List;

import invoice.Invoice;
import invoice.InvoiceException;

public class Customer {

	private int customerId;
	private String name;
	private List<Invoice> invoices;
	
	public Customer(int customerId, String name) {
		super();
		this.customerId = customerId;
		this.name = name;
	}

	public void addInvoice(Invoice invoice) {
		invoices.add(invoice);
	}
	
	private void isAvaliable(int index) throws InvoiceException {
		if(index >= 0 && index < invoices.size())
			return;
		throw new InvoiceException("No invoice found...!");
	}
	
	public Invoice removeInvoice(int index) throws InvoiceException {
		isAvaliable(index);
		return invoices.remove(index);
	}
	
	public void printSummary() {
		
		System.out.println("************** Customer Id : " + this.customerId + " **************");
		System.out.println("Customer name : " + name);
		System.out.println("Invoices");
		for(Invoice invoice: invoices) {
			invoice.printSummary();
		}
		
	}
	
}
