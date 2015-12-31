package io.github.lsr1991.algorithm4th.practice0103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class LinkedListBag<Item> implements Iterable<Item> {

	private Node first;
	private int N;
	
	private class Node {
		public Node next;
		public Item item;
	}

	public LinkedListBag() {
	}
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void add(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.next = oldFirst;
		first.item = item;
		N ++;
	}
	
	public Iterator<Item> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<Item> {
		private Node node = first;
		public boolean hasNext() {
			return node != null;
		}
		public Item next() {
			Item item = node.item;
			node = node.next;
			return item;
		}
		public void remove() {
			// nothing
		}
	}
	public static void main(String[] args) {
		LinkedListBag<String> s = new LinkedListBag<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				s.add(item);
			}
		}
		StdOut.println("(" + s.size() + " left on bag)");
		for (String item : s) {
			StdOut.println(item);
		}
	}

}
