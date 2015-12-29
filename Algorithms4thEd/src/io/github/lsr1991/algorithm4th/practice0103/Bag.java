package io.github.lsr1991.algorithm4th.practice0103;

import java.util.Iterator;

public class Bag<Item> implements Iterable<Item>{
	
	public Bag() {
		//TODO
	}
	
	public void add() {
		//TODO
	}
	
	public boolean isEmpty() {
		//TODO
		return true;
	}
	
	public int size() {
		//TODO
		return 0;
	}
	
	public Iterator<Item> iterator() {
		return new MyIterator<Item>();
	}
	
	private class MyIterator<Item> implements Iterator<Item>{
		
		public boolean hasNext() {
			//TODO
			return true;
		}
		
		public Item next() {
			//TODO
			return null; 
		}
		
		public void remove() {
			//TODO
		}
	}
}
