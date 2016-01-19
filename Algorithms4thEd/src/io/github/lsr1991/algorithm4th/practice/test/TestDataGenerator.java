package io.github.lsr1991.algorithm4th.practice.test;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class TestDataGenerator {

	public static void generateRandom(int num) {
		for (int i = 0; i < num; i ++) {
			StdOut.println(StdRandom.uniform(10000000));
		}
	}
	
	public static void generateAscend(int num) {
		for (int i = 0; i < num; i ++) {
			StdOut.println(i);
		}
	}
	
	public static void generateDescend(int num) {
		for (int i = num - 1; i >= 0; i --) {
			StdOut.println(i);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateRandom(10000000);
	}

}
