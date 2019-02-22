package graph;

import javafx.scene.Parent;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeSet;

public class Graph3 {
    int n;
    int[][] A;
    int[] d;	//shortest distance
    int[] parent;
    private final int WHITE = 2;
    private final int GRAY = 3;
    private final int BLACK = 4;
    /**
     */

    public Graph3 () {

    }

    public Graph3 (int _n, int[][] _A) {
        n = _n;
        A = _A;
        d = new int[n];
        parent=new int[n];
    }

    public void initialize_single_source(int s) {
        for (int i = 0; i < n; i++)
            d[i] = Integer.MAX_VALUE;
        d[s] = 0;
    }

    public void relax (int u, int v) {
        if (d[v] > (d[u] + A[u][v])) {
            d[v] = d[u] + A[u][v];
            parent[v]=u;
        }
    }

    public boolean bellman_ford (int s) {
        //fill in your program
       initialize_single_source(s);
       for (int i=0; i<n;++i) {
           for (int u = 0; u <n; u++) {
               for (int v=0; v<n;v++) {
                   if ((A[u][v] != 0)) {
                       relax(u, v);
                   }
               }
           }
       }
        for (int i=0; i<n;++i) {
            for (int u = 0; u <n; u++) {
                for (int v=0; v<n;v++) {
                    if ((A[u][v] != 0) && (d[v] > d[u] + A[u][v])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    public void dijkstra (int s) {
        //fill in your program
        initialize_single_source(s);
        PriorityQueue<Node> Q = new PriorityQueue<Node>();
        for (int i = 0; i < n; i++) {
            Node U;
            if (i > 0) { U = new Node(i, Integer.MAX_VALUE); }
            else { U = new Node(i, 0); }
            Q.add(U); }
        while (!Q.isEmpty()) {
            Node U2;
            U2 = Q.poll();
            PriorityQueue<Node> Q2 = new PriorityQueue<Node>();
            for(Node V : Q) {
                 if ((A[U2.ID][V.ID] > 0 ) && d[U2.ID]!=Integer.MAX_VALUE ) {
                     V.Key = A[U2.ID][V.ID];
                     relax(U2.ID, V.ID);
                 }
                Q2.add(V);
            }
            Q=Q2;
        }

    }
    public void display_distance () {
        for (int i = 0; i < n; i++)
            System.out.println(i + ": " + d[i]);


    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 5;
        int[][] A = {
                {0, 6, 0, 7, 0},
                {0, 0, 5, 8, -4},
                {0, -2, 0, 0, 0},
                {0, 0, -3, 0, 9},
                {2, 0, 7, 0, 0}
        };
        Graph3 g1 = new Graph3(n, A);
        g1.bellman_ford(0);
        g1.display_distance();

        System.out.println("-----------------------");

        int[][] B = {
                {0, 10, 0, 5, 0},
                {0, 0, 1, 2, 0},
                {0, 0, 0, 0, 4},
                {0, 3, 9, 0, 2},
                {7, 0, 6, 0, 0}
        };
        Graph3 g2 = new Graph3(n, B);
        g2.dijkstra(0);
        g2.display_distance();
    }

}
