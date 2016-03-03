package io.github.lsr1991.algorithm4th.practice0204;

import io.github.lsr1991.algorithm4th.practice0103.LinkedListStack;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

public class TopM2 {

	public static void main(String[] args) {
		int M = Integer.parseInt(args[0]);
		MaxPQ<Transaction> pq = new MaxPQ<Transaction>(M+1);
		while(StdIn.hasNextLine()) {
			pq.insert(new Transaction(StdIn.readLine()));
			if (pq.size() > M) {
				pq.delMax();
			}
		}
		LinkedListStack<Transaction> stack = new LinkedListStack<Transaction>();
		while (!pq.isEmpty()) {
			stack.push(pq.delMax());
		}
		for (Transaction t : stack) {
			StdOut.println(t);
		}
	}

}
