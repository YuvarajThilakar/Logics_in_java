package customer;

import java.util.HashMap;
import java.util.Map;

import invoice.Invoice;
import invoice.InvoiceException;

public class CustomerManager {

	private Map<Integer, Customer> listOfCustomers;

	public CustomerManager() {
		listOfCustomers = new HashMap<Integer, Customer>();
	}
	
	private Customer getCustomer(int aadharNo) throws CustomerExceptions {
		Customer customer = listOfCustomers.get(aadharNo);
		if(customer == null)
			throw new CustomerExceptions("Customer doesn't exist...!");
		
		return customer;
	}
	
	public void addCustomer(int aadharNo, String name) throws CustomerExceptions {
		if (listOfCustomers.containsKey(aadharNo)) {
			throw new CustomerExceptions("This aadhar no is already present");
		}
		this.listOfCustomers.put(aadharNo, new Customer(aadharNo, name));	
	}

	public void addInvoice(int aadharNo, Invoice invoice) throws CustomerExceptions {
		Customer customer = getCustomer(aadharNo);
		customer.addInvoice(invoice);
	}
	
	public void removeInvoice(int aadharNo, int index) throws CustomerExceptions, InvoiceException {
		Customer customer = getCustomer(aadharNo);
		customer.removeInvoice(index);
	}
	
	public void printCustomerSummary(int aadharNo) throws CustomerExceptions {
		Customer customer = getCustomer(aadharNo);
		customer.printSummary();
	}
	
	public void printAllCustomerSummary() throws CustomerExceptions {
		for(int aadharNo : listOfCustomers.keySet()) {
			printCustomerSummary(aadharNo);
		}
	}
	
}





















