package io.github.lsr1991.algorithm4th.practice.test;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;

public class Drawer {

	private static double factorial(long n) {
		double result = 1;
		for (int i = 2; i <= n; i ++) {
			result *= i;
		}
		return result;
	}
	
	private static final double LOG10_2 = Math.log10(2); 
	
	public static void main(String[] args) {
		int N = 100;
//		StdDraw.setXscale(0, 3);
//		StdDraw.setYscale(0, 3);
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, 7* N);
		StdDraw.setPenRadius(.01);
		for (int i = 1; i <= N; i ++) {
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.point(i, i * Math.log10(i) / LOG10_2 / 2);
//			double factorial = factorial(i);
//			StdOut.println(factorial);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.point(i, Math.log10(factorial(i)) / LOG10_2);
			StdDraw.setPenColor(StdDraw.YELLOW);
			StdDraw.point(i, i * Math.log10(i) / LOG10_2);
			StdDraw.setPenColor(StdDraw.GREEN);
			StdDraw.point(i, i);
		}
//		Point2D p = new Point2D(1.0, 2.0);
//		p.draw();
	}

}
