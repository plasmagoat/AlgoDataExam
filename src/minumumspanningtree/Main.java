package minumumspanningtree;

import misc.In;
import misc.StdOut;
import undirectedgraphs.Edge;
import undirectedgraphs.EdgeWeightedGraph;

public class Main {
    public static void main(String[] args) {

        In in = new In("tinyEWG.txt");
        //In in = new In("mediumEWG.txt");
        EdgeWeightedGraph G = new EdgeWeightedGraph(in);

        System.out.println("Minimum Spanning Tree");
        System.out.println("Lazy Prim's Algorithm Implementation");
        LazyPrimMST mst = new LazyPrimMST(G);
        for (Edge e : mst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", mst.weight());
        System.out.println();
        System.out.println("Kruskal's Algorithm Implementation");
        KruskalMST kmst = new KruskalMST(G);
        for (Edge e : kmst.edges()) {
            StdOut.println(e);
        }
        StdOut.printf("%.5f\n", kmst.weight());
    }
}
