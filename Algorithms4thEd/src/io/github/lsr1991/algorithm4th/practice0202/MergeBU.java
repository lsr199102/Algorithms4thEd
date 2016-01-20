package io.github.lsr1991.algorithm4th.practice0202;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class MergeBU {

	private static Comparable[] aux;
	
	private static void sort(Comparable[] a) {
		int N = a.length;
		aux = new Comparable[N];
		for (int size = 1; size < N; size += size) {
			for (int lo = 0; lo < N - size; lo += size + size) {
				merge(a, lo, lo + size - 1, Math.min(lo + size + size - 1, N - 1));
			}
		}
	}
	
	private static void merge(Comparable[] a, int lo, int mid, int hi) {
		for (int k = lo; k <= hi; k ++) {
			aux[k] = a[k];
		}
		int i = lo;
		int j = mid + 1;
		for (int k = lo; k <= hi; k ++) {
			if (i > mid) {
				a[k] = aux[j++];
			} else if (j > hi) {
				a[k] = aux[i++];
			} else if (less(aux[i], aux[j])) {
				a[k] = aux[i++];
			} else {
				a[k] = aux[j++];
			}
		}
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void exch(Comparable[] a, int i, int j) {
		Comparable tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}
	
	private static void show(Comparable[] a) {
		for (int i = 0; i < a.length; i ++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i ++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);
	}

}
