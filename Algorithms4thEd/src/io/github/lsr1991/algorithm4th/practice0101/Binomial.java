package io.github.lsr1991.algorithm4th.practice0101;

import static edu.princeton.cs.algs4.StdOut.*;

public class Binomial {

	private static long count = 0;

	private static double[][] calculated = null;

	public static double binomialImpl1(int N, int k, double p) {
		count++;
		if (N == 0 && k == 0)
			return 1.0;
		if (N < 0 || k < 0)
			return 0.0;
		// if (N < k) return 0.0;
		return (1 - p) * binomialImpl1(N - 1, k, p) + p
				* binomialImpl1(N - 1, k - 1, p);
	}

	private static double binomial(int N, int k, double p) {
		count++;
		if (N == 0 && k == 0)
			return 1.0;
		if (N < 0 || k < 0)
			return 0.0;
		if (N < k)
			return 0.0;
		if (calculated[N][k] != -1) {
			return calculated[N][k];
		}
		calculated[N][k] = (1 - p) * binomial(N - 1, k, p) + p
				* binomial(N - 1, k - 1, p);
		return calculated[N][k];
	}

	public static double binomialImpl2(int N, int k, double p) {
		calculated = new double[N + 1][k + 1];
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < k + 1; j++) {
				calculated[i][j] = -1;
			}
		}
		return binomial(N, k, p);
	}

	// transform recursive function call into recursive formula
	public static double binomialImplOfficial(int N, int k, double p) {
		double[][] b = new double[N + 1][k + 1];

		// base cases
		for (int i = 0; i <= N; i++)
			b[i][0] = Math.pow(1.0 - p, i);
		b[0][0] = 1.0;

		// recursive formula
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= k; j++) {
				b[i][j] = p * b[i - 1][j - 1] + (1.0 - p) * b[i - 1][j];
			}
		}
		return b[N][k];
	}
	
	public static double binomialImplOfficialMyImproved(int N, int k, double p) {
		double[][] b = new double[N + 1][k + 1];

		// base cases
		for (int i = 0; i <= N; i++)
			b[i][0] = Math.pow(1.0 - p, i);
		b[0][0] = 1.0;

		// recursive formula
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= (i > k ? k : i); j++) {
				b[i][j] = p * b[i - 1][j - 1] + (1.0 - p) * b[i - 1][j];
			}
		}
		return b[N][k];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 10000;
		int k = 5000;
		double p = 0.25;
		long begin, end = 0;
//		println("binomialImpl1: ");
//		long begin = System.currentTimeMillis();
//		println("result: " + binomialImpl1(N, k, p));
//		long end = System.currentTimeMillis();
//		println("recursive times: " + count);
//		println("running time: " + (end - begin) + "ms");
//		count = 0;
//		println("binomialImpl2: ");
//		begin = System.currentTimeMillis();
//		println("result: " + binomialImpl2(N, k, p));
//		end = System.currentTimeMillis();
//		println("recursive times: " + count);
//		println("running time: " + (end - begin) + "ms");
		count = 0;
		println("binomialImplOfficial: ");
		begin = System.currentTimeMillis();
		println("result: " + binomialImplOfficial(N, k, p));
		end = System.currentTimeMillis();
		println("recursive times: " + count);
		println("running time: " + (end - begin) + "ms");
		count = 0;
		println("binomialImplOfficialImproved: ");
		begin = System.currentTimeMillis();
		println("result: " + binomialImplOfficialMyImproved(N, k, p));
		end = System.currentTimeMillis();
		println("recursive times: " + count);
		println("running time: " + (end - begin) + "ms");
	}

}
