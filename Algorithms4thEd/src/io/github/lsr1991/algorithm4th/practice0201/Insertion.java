package io.github.lsr1991.algorithm4th.practice0201;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Insertion {

	public static void sort(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i < hi + 1; i ++) {
			for (int j = i; j > 0; j --) {
				if (less(a[j], a[j-1])) {
					exch(a, j, j-1);
				} else {
					break;
				}
			}
		}
	}
	
	public static void sort(Comparable[] a) {
		sort(a, 0, a.length - 1);
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
