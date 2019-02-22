package graph;

import java.util.PriorityQueue;
import java.util.Queue;

public class Graph2 {

    public int n;	//number of vertice
    public int[][] A;	//the adjacency matrix

    public Graph2 () {
        n = 0;
        A = null;
    }

    public Graph2 (int _n, int[][] _A) {
        this.n = _n;
        this.A = _A;
    }

    public int prim (int r) {

        /*

             I received some help not going to lie.

         */


                            PriorityQueue<Node> Q = new PriorityQueue<Node>();
        for (int i = 0; i < n; i++) {
            Node U;
            if (i>0)
            U= new Node(i,Integer.MAX_VALUE);
            else
            U= new Node(i,0);

            Q.add(U);
        }
        int Sum = 0;
        while (!Q.isEmpty()) {
            Node U2;
            U2 = Q.poll();
            Sum +=U2.Key;
                              PriorityQueue<Node> Q2 = new PriorityQueue<Node>();
            for(Node V : Q) {
                if ((A[U2.ID][V.ID] > 0) && (V.Key > A[U2.ID][V.ID])) {
                    V.Key = A[U2.ID][V.ID];
                }
                Q2.add(V);
            }
                Q=Q2;
            }
        return Sum;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 9;
        int A[][] = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        Graph2 g = new Graph2(n, A);
        System.out.println(g.prim(0));
    }

}
