package com.livingbytes;

import java.util.ArrayList;
import java.util.List;

public class Content {

	private String content;
	private List<HighlightedLine> highlightedLines;

	public Content(String content) {
		this.content = content;
		highlightedLines = new ArrayList<Content.HighlightedLine>();
	}

	public void addHighlightedLine(int startingIndex, int endingIndex) {
		highlightedLines.add(new HighlightedLine(startingIndex, endingIndex));
	}

	public void printHighlightedLines() {
		
		for(HighlightedLine highlightedLine: highlightedLines) {
			System.out.println(content.substring(highlightedLine.getStartingIndex(), (highlightedLine.getEndingIndex()+1)));
		}
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void addContent(String content) {
		this.content += content;
	}

	public String getContent() {
		return this.content;
	}

	// Private helper class
	private class HighlightedLine {

		private int startingIndex;
		private int endingIndex;

		public HighlightedLine(int startingIndex, int endingIndex) {
			this.startingIndex = startingIndex;
			this.endingIndex = endingIndex;
		}

		public int getStartingIndex() {
			return startingIndex;
		}

		public int getEndingIndex() {
			return endingIndex;
		}
	}

}
