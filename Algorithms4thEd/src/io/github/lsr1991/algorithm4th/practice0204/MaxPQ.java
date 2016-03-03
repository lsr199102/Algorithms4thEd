package io.github.lsr1991.algorithm4th.practice0204;

public class MaxPQ<Key extends Comparable<Key>>{

	private Key[] a;
	/**
	 * element number
	 */
	private int N = 0;
	
	public MaxPQ() {
		a = (Key[])new Comparable[16];
	}
	
	public MaxPQ(int max) {
		a = (Key[])new Comparable[max + 1];
	}
	
	/**
	 * use elements in a[] to create a priority queue 
	 * @param a
	 */
	public MaxPQ(Key[] a) {
		this.a = (Key[])new Comparable[a.length + 1];
	}
	
	public void insert(Key v) {
		if (N == a.length - 1) {
			resize();
		}
		a[++N] = v;
		swim();
	}
	
	private void resize() {
		Key[] b = (Key[]) new Comparable[a.length * 2 + 1];
		for (int i = 0; i < a.length; i ++) {
			b[i] = a[i];
		}
		a = b;
	}
	
	/**
	 * delete and return the max element
	 * @return
	 */
	public Key delMax() {
		if (isEmpty()) return null;
		Key max = a[1];
		a[1] = a[N];
		a[N] = null;
		N--;
		sink();
		return max;
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public int size() {
		return N;
	}
	
	private void swim() {
		int k = N;
		while (k > 1 && less(k/2, k)) {
			exch(k/2, k);
			k = k/2;
		}
	}
	
	private void sink() {
		int k = 1;
		while (2*k <= N) {
			int j = 2*k;
			// if a[j+1] doesn't exist, a[j] is the max one, 
			// or if a[j+1] > a[j], a[j+1] is the max one.
			// then if a[k] is larger than the max one, exch is not needed.
			if (j < N && less(j, j+1)) { // to keep the element to be compared is the max one.
				j++;
			}
			if (!less(k, j)) { // a[k] >= the max one, exch stops
				break;
			}
			// otherwise a[k] is smaller than the max one, exch is needed.
			exch(k, j);
			k = j;
		}
	}
	
	private boolean less(int i, int j) {
		return a[i].compareTo(a[j]) < 0;
	}
	
	private void exch(int i, int j) {
		Key tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
}
