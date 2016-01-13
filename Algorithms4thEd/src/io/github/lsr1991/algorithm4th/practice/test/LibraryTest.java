package io.github.lsr1991.algorithm4th.practice.test;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdDraw;

public class LibraryTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 100;
//		StdDraw.setXscale(0, 3);
//		StdDraw.setYscale(0, 3);
		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, N*N);
		StdDraw.setPenRadius(.01);
		for (int i = 1; i <= N; i ++) {
			StdDraw.point(i, i);
			StdDraw.point(i, i*i);
			StdDraw.point(i, i*Math.log(i));
		}
//		Point2D p = new Point2D(1.0, 2.0);
//		p.draw();
	}

}
