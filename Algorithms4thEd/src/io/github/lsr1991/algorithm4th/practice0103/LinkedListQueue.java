package io.github.lsr1991.algorithm4th.practice0103;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Iterator;

public class LinkedListQueue<Item> implements Iterable<Item> {

	private Node first;
	private Node last;
	private int N;

	private class Node {
		public Node next;
		public Item item;
	}

	public LinkedListQueue() {
	}

	public int size() {
		return N;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void enqueue(Item item) {
		Node oldLast = last;
		last = new Node();
		if (oldLast != null) {
			oldLast.next = last;
		} else {
			first = last;
		}
		last.item = item;
		N++;
	}

	public Item dequeue() {
		Node oldFirst = first;
		first = first.next;
		if (first == null) {
			last = null;
		}
		N--;
		return oldFirst.item;
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
		LinkedListQueue<String> s = new LinkedListQueue<String>();
		while (!StdIn.isEmpty()) {
			String item = StdIn.readString();
			if (!item.equals("-")) {
				s.enqueue(item);
			} else if (!s.isEmpty()) {
				StdOut.print(s.dequeue() + " ");
			}
		}
		StdOut.println("(" + s.size() + " left on queue)");
		for (String item : s) {
			StdOut.println(item);
		}
	}

}
