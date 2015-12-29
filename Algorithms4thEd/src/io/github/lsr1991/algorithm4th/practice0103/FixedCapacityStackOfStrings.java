package io.github.lsr1991.algorithm4th.practice0103;

public class FixedCapacityStackOfStrings {

	private String[] a;
	private int N;
	
	public FixedCapacityStackOfStrings(int cap) {
		a = new String[cap];
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void push(String item) {
		a[N ++] = item;
	}
	
	public String pop() {
		return a[--N];
	}
	
	public static void main(String[] args) {
		
	}

}
