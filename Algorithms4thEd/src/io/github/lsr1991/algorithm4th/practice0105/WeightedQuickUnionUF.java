package io.github.lsr1991.algorithm4th.practice0105;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class WeightedQuickUnionUF {

	/**
	 * record the set of each element
	 * e.g. id[k] = l 
	 * means the set of element k is l.
	 */
	private int[] id;
	/**
	 * the number of elements in each set
	 */
	private int[] size;
	/**
	 * record the number of sets
	 */
	private int count;
	/**
	 * array access times in each operation 
	 */
	private int cost;
	/**
	 * total array access times
	 */
	private int total = 0;
	
	public WeightedQuickUnionUF(int N) {
		id = new int[N];
		for (int i = 0; i < id.length; i ++) {
			id[i] = i;
		}
		count = N;
		size = new int[N];
		for (int i = 0; i < size.length; i ++) {
			size[i] = 1;
		}
		StdDraw.setXscale(0, 900);
		StdDraw.setYscale(0, 1300);
		StdDraw.setPenRadius(.01);
	}
	
	/**
	 * if q and p is connected, then return true, otherwise return false.
	 * @param q
	 * @param p
	 * @return
	 */
	public boolean connected(int q, int p) {
		cost = 0;
		int qSet = find(q);
		int pSet = find(p);
		total += cost;
		return qSet == pSet;
	}
	
	/**
	 * union the set of q and the set of p
	 * @param q
	 * @param p
	 */
	public void union(int q, int p) {
		cost = 0;
		int qSet = find(q);
		int pSet = find(p);
		if (pSet == qSet) {
			total += cost;
			return;
		}
		if (size[qSet] > size[pSet]) {
			id[pSet] = qSet;
			size[qSet] += size[pSet];
		} else {
			id[qSet] = pSet;
			size[pSet] += size[qSet];
		}
		cost += 3;
		total += cost;
		count --;
	}
	
	/**
	 * get the number of sets
	 * @return
	 */
	public int count() {
		return count;
	}
	
	/**
	 * find the set that q belongs to
	 * @param q
	 * @return
	 */
	public int find(int q) {
		while (q != id[q]) {
			q = id[q];
			cost += 2;
		}
		cost += 1;
		return q;
	}
	
	public int getCost() {
		return cost;
	}
	
	public void draw(int link) {
		StdDraw.setPenColor(StdDraw.GRAY);
		StdDraw.point(link, cost);
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.point(link, total/link);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length < 1) {
			StdOut.println("Usage: <output image path>");
			System.exit(1);
		}
		int i = 0; // link number
		int N = StdIn.readInt();
		WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);
		while (!StdIn.isEmpty()) {
			int p = StdIn.readInt();
			int q = StdIn.readInt();
			i ++;
			if (uf.connected(q, p)) {
				uf.draw(i);
				continue;
			}
			uf.union(p, q);
			uf.draw(i);
			StdOut.println(p + " " + q);
		}
		StdOut.println(uf.count() + " components");
		StdDraw.save(args[0]);
	}

}
