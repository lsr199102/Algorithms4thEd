package io.github.lsr1991.algorithm4th.practice0203;

import io.github.lsr1991.algorithm4th.practice0201.Insertion;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class InsertQuick {

	private static final int M = 12;
	
	public static void sort(Comparable[] a) {
//		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (lo + M >= hi) {
			Insertion.sort(a, lo, hi);
			return;
		}
		int k = partition(a, lo, hi);
		sort(a, lo, k - 1);
		sort(a, k + 1, hi);
	}
	
	private static int partition(Comparable[] a, int lo, int hi) {
		int tmp = StdRandom.uniform(lo, hi + 1);
		exch(a, tmp, lo);
		int i = lo;
		int j = hi + 1;
		while (true) {
			while (less(a[++i], a[lo])) {
				if (i == hi) {
					break;
				}
			}
			while (less(a[lo], a[--j])) {
			}
			if (i >= j) break;
			exch(a, i, j);
		}
		exch(a, lo, j);
		return j;
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
