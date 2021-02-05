package com.livingbytes.logics;

public class Triplet {

	private int i;
	private int j;
	private int k;
	
	public Triplet(int i, int j, int k) {
		super();
		this.i = i;
		this.j = j;
		this.k = k;
	}
	
	public int getProduct() {
		return i*j*k;
	}
	
	@Override
	public String toString() {
		return "Triplet [i=" + i + ", j=" + j + ", k=" + k + "]";
	}
	
	
	
}
