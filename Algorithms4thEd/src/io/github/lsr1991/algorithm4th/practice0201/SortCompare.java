package io.github.lsr1991.algorithm4th.practice0201;

import io.github.lsr1991.algorithm4th.practice0202.Merge;
import io.github.lsr1991.algorithm4th.practice0202.MergeBU;
import io.github.lsr1991.algorithm4th.practice0203.InsertQuick;
import io.github.lsr1991.algorithm4th.practice0203.Quick;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {

	public static double time(String alg, Double[] a) {
		Stopwatch t = new Stopwatch();
		if (alg.equals("Insertion")) {
			Insertion.sort(a);
		} else if (alg.equals("Selection")) {
			Selection.sort(a);
		} else if (alg.equals("Shell")) {
			Shell.sort(a);
		} else if (alg.equals("MyShell")) {
			Shell.mySort(a);
		} else if (alg.equals("Merge")) {
			Merge.sort(a);
		} else if (alg.equals("MergeBU")) {
			MergeBU.sort(a);
		} else if (alg.equals("Quick")) {
			Quick.sort(a);
		} else if (alg.equals("InsertQuick")) {
			InsertQuick.sort(a);
		}
		return t.elapsedTime();
	}
	
	public static double timeRandomInput(String alg, int N, int T) {
		double total = 0.0;
		Double[] a = new Double[N];
		for (int t = 0; t < T; t ++) {
			for (int i = 0; i < N; i ++) {
				a[i] = StdRandom.uniform();
			}
			total += time(alg, a);
		}
		return total;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length < 4) {
			StdOut.println("Usage: <alg1> <alg2> <input scale> <repeated times>");
			System.exit(1);
		}
		String alg1 = args[0];
		String alg2 = args[1];
		int N = Integer.parseInt(args[2]);
		int T = Integer.parseInt(args[3]);
		double alg1Time = timeRandomInput(alg1, N, T);
		double alg2Time = timeRandomInput(alg2, N, T);
		StdOut.printf("For %d random Doubles\n %s is", N, alg1);
		StdOut.printf(" %.1f times faster than %s\n", alg2Time/alg1Time, alg2);
	}

}
