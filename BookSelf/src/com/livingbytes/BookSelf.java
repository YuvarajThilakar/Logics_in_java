package com.livingbytes;

import java.util.HashMap;
import java.util.Map;

public class BookSelf {

	private String selfName;
	private Map<String, Book> books;
	
	public BookSelf(String name) {
		this.selfName = name;
		this.books = new HashMap<String, Book>();
	}
	
	public void showPage(String name, int pageNumber) {
		books.get(name).showPage(pageNumber);
	}
	
	public void addHighlightedLine(String name, int pageNumber, int startingIndex, int endingIndex) {
		books.get(name).addHighlightedLine(pageNumber, startingIndex, endingIndex);
	}
	
	public void addContent(String name, int pageNumber, String content) {
		books.get(name).addContent(pageNumber, content);
	}
	
	public void replaceContent(String name, int pageNumber, String content) {
		books.get(name).replaceContent(pageNumber, content);
	}
	
	public void printHighlightedLines(String name, int pageNumber) {
		books.get(name).printHighlightedLines(pageNumber);
	}

	@Override
	public String toString() {
		return "BookSelf [Name=" + selfName + "]" + "\n" + 
				"No Of Books: " + this.books.size();
	}
	
	
	
}
