package io.github.lsr1991.algorithm4th.practice0101;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;

public class Wget {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // read in data from URL
        String url = args[0];
        In in = new In(url);
        String data = in.readAll();

        // write data to a file
        String filename = url.substring(url.lastIndexOf('/') + 1);
        Out out = new Out("test-output/0101/" + filename);
        out.println(data);
        out.close();
	}

}
