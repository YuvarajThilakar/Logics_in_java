package com.livingbytes;

public class Page {

	private int pageNumber;
	private Content content;
	
	public Page(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Page(int pageNumber, Content content) {
		this.pageNumber = pageNumber;
		this.content = content;
	}
	
	public void addHighlightedLine(int startingIndex, int endingIndex) {
		this.content.addHighlightedLine(startingIndex, endingIndex);
	}
	
	public void replaceContent(String text) {
		content.setContent(text);
	}
	
	public void addContent(String text) {
		content.addContent(text);
	}
	
	public void printContent() {
		System.out.println("************** " + this.pageNumber + " **************");
		System.out.println(content.getContent());
	}
	
	public void printHighlightedLines() {
		this.content.printHighlightedLines();
	}

	@Override
	public String toString() {
		return this.pageNumber + "/n" + this.content.getContent().substring(0, 15) + "...";
	}
	
	
	
}
