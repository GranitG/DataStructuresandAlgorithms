package graph;

import java.util.LinkedList;

public class Graph {
    public int n;	//number of vertice
    public int[][] A;	//the adjacency matrix
    private final int WHITE = 2;
    private final int GRAY = 3;
    private final int BLACK = 4;

    public Graph () {
        n = 0;
        A = null;
    }

    public Graph (int _n, int[][] _A) {
        this.n = _n;
        this.A = _A;
    }

    /*
     * Input: s denotes the index of the source node
     * Output: the array dist, where dist[i] is the distance between the i-th node to s
     */
    public int[] bfs (int s) {
        int[] Distance=new int[n];
        int[] Color=new int[n];
        for (int i=0; i<n;i++){
            Color[i]=WHITE;
            Distance[i]=Integer.MAX_VALUE;
            //Parent is not needed
        }

        int V=0;
        int U=0;
        LinkedList<Integer> Q=new LinkedList<Integer>();
        Q.add(s);
        Color[s]=GRAY;
        Distance[s]=0;
        // we ignore parent because we dont need it here.

        while (!(Q.isEmpty())){
            U=Q.remove();
            V=0;
            while (V < n){
                if (A[U][V]==1 &&A[V][U]==1 && Color[V]==WHITE){
                    Color[V]=GRAY;
                    Distance[V]=Distance[U]+1;
                    //Ignore parent
                    Q.add(V);
                }
                V++;
            }
            Color[U]=BLACK;

        }



        return Distance;

    }

    public void print_array (int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.println(i + ": " + array[i]);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 8;
        int[][] A ={
                        {0, 1, 0, 0, 1, 0, 0, 0},
                        {1, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 0, 1, 1, 0},
                        {0, 0, 1, 0, 0, 0, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 0, 0, 1, 0},
                        {0, 0, 1, 1, 0, 1, 0, 1},
                        {0, 0, 0, 1, 0, 0, 1, 0}
        };
        Graph g = new Graph(n, A);
        g.print_array(g.bfs(1));
    }

}
