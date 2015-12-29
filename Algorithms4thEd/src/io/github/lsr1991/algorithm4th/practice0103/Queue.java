package io.github.lsr1991.algorithm4th.practice0103;

import java.util.Iterator;

public class Queue<Item> {

	public Queue() {
		// TODO
	}

	public Item dequeue() {
		// TODO
		return null;
	}

	public void enqueue(Item item) {
		// TODO
	}

	public boolean isEmpty() {
		// TODO
		return true;
	}

	public int size() {
		// TODO
		return 0;
	}

	public Iterator<Item> iterator() {
		return new MyIterator();
	}

	private class MyIterator implements Iterator<Item> {

		public boolean hasNext() {
			// TODO
			return true;
		}

		public Item next() {
			// TODO
			return null;
		}

		public void remove() {
			// TODO
		}
	}
}
