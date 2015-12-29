package io.github.lsr1991.algorithm4th.practice0103;

import java.util.Iterator;

public class Stack<Item> {

	public Stack() {
		// TODO
	}

	public Item pop() {
		// TODO
		return null;
	}

	public void push(Item item) {
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
