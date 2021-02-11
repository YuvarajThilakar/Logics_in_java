package com.livingbytes;

import java.util.ArrayList;
import java.util.List;

public class Book {

	private String name;
	private String authorName;
	private List<Page> pages;
	
	public Book(String name, String authorName) {
		this.name = name;
		this.authorName = authorName;
		this.pages = new ArrayList<Page>();
	}
	
	public void showPage(int pageNumber) {
		pages.get(pageNumber).printContent();
	}
	
	public void addHighlightedLine(int pageNumber, int startingIndex, int endingIndex) {
		pages.get(pageNumber).addHighlightedLine(startingIndex, endingIndex);
	}
	
	public void addContent(int pageNumber, String content) {
		pages.get(pageNumber).addContent(content);
	}
	
	public void replaceContent(int pageNumber, String content) {
		pages.get(pageNumber).replaceContent(content);
	}
	
	public void printHighlightedLines(int pageNumber) {
		pages.get(pageNumber).printHighlightedLines();
	}

	@Override
	public String toString() {
		return "Name : " + this.name + "\n" +
				"Author name : " + this.authorName + "\n" +
				"No of pages : " + this.pages.size();
	}
	
	
	
}
