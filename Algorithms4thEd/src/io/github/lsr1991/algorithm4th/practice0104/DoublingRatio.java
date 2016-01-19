package io.github.lsr1991.algorithm4th.practice0104;

import io.github.lsr1991.algorithm4th.practice0201.Insertion;
import io.github.lsr1991.algorithm4th.practice0201.Selection;
import io.github.lsr1991.algorithm4th.practice0201.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class DoublingRatio {

	public static enum InputType {
		RANDOM,
		ASCEND,
		DESCEND
	};
	
	public static double timeTrial(int N, InputType type) {
		int MAX = 1000000;
//		int[] a = new int[N];
		Integer[] a = new Integer[N];
		for (int i = 0; i < N; i ++) {
			switch(type) {
			case RANDOM: a[i] = StdRandom.uniform(-MAX, MAX);break;
			case ASCEND: a[i] = i;break;
			case DESCEND: a[i] = N - i;break;
			default: a[i] = StdRandom.uniform(-MAX, MAX);
			}
		}
		Stopwatch timer = new Stopwatch();
		Shell.sort(a);
//		int cnt = ThreeSumFast.count(a);
		return timer.elapsedTime();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length < 1) {
			StdOut.println("Usage: <input max scale>");
			System.exit(1);
		}
		int maxScale = Integer.parseInt(args[0]); 
		for (InputType type: InputType.values()) {
			StdOut.println(type);
			double prev = timeTrial(125, type);
			for (int N = 250; N < maxScale; N += N) {
				double time = timeTrial(N, type);
				StdOut.printf("%6d %7.1f ", N, time);
				StdOut.printf("%5.1f\n", time/prev);
				prev = time;
			}
		}
	}

}
