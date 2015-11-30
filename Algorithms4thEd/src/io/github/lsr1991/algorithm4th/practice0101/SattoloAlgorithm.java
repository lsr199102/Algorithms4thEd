package io.github.lsr1991.algorithm4th.practice0101;

import static edu.princeton.cs.algs4.StdOut.*;

import java.util.Arrays;
import java.util.Random;

import edu.princeton.cs.algs4.StdIn;

public class SattoloAlgorithm {
	
	public static void sattolo(Object[] set) {
		Random rand = new Random();
		int i = set.length;
		int j = 0;
		Object tmp = null;
		while (i > 1) {
			i --;
			j = rand.nextInt(i);
			tmp = set[j];
			set[j] = set[i];
			set[i] = tmp;
		}
	}
	
    /**
     * Rearranges an array of objects to be a uniformly random cycle
     * (under the assumption that <tt>Math.random()</tt> generates independent
     * and uniformly distributed numbers between 0 and 1).
     * @param a the array to be rearranged
     * @see StdRandom
     */
    public static void sattoloOfficial(Object[] a) {
        int N = a.length;
        for (int i = N; i > 1; i--) {
            // choose index uniformly in [0, i-1)
            int r = (int) (Math.random() * (i-1));
            Object swap = a[r];
            a[r] = a[i-1];
            a[i-1] = swap;
        }
    }
	
	public static void main(String[] args) {
//		String[] set = StdIn.readAllStrings();
		Integer[] set = {1, 5, 7, 9, 4, 3};
//		sattoloOfficial(set);
		sattolo(set);
		println(Arrays.toString(set));
		
	}
}
