package graph;


public class DFS {
    public int n;	//number of vertice
    public int[][] A;	//the adjacency matrix
    private final int WHITE = 2;
    private final int GRAY = 3;
    private final int BLACK = 4;
    private int Time=0;
    private int[] Color=new int[8];
    private int[] Distance=new int[8];
    private  int[] Finish=new int[8];
    private int U=0;


    public DFS (int _n, int[][] _A) {
        this.n = _n;
        this.A = _A;
    }

    /*
     * Input: s denotes the index of the source node
     * Output: the array dist, where dist[i] is the distance between the i-th node to s
     */
    public int[] DFS_Visit (int s) {
        Time=Time+1;
        Distance[s]=Time;
        Color[s]=GRAY;
        int V=0;

        while (V < n){
            if (A[s][V]==1 &&A[V][s]==1 && Color[V]==WHITE){
                DFS_Visit(V);
            }
            V++;
        }
        Color[s]=BLACK;
        Time=Time+1;
        Finish[s]=Time;


        return Finish;

    }
    public int[] DFS(int s){

        for (int i=0; i<n;i++){
            Color[i]=WHITE;
            //ignore parent
        }
        for (int i=0; i<n;i++){
            if (Color[i]==WHITE){
                DFS_Visit(i);
            }
        }
        return Finish;
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
        int[][] A =
                {
                        {0, 1, 0, 0, 1, 0, 0, 0},
                        {1, 0, 0, 0, 0, 1, 0, 0},
                        {0, 0, 0, 1, 0, 1, 1, 0},
                        {0, 0, 1, 0, 0, 0, 1, 1},
                        {1, 0, 0, 0, 0, 0, 0, 0},
                        {0, 1, 1, 0, 0, 0, 1, 0},
                        {0, 0, 1, 1, 0, 1, 0, 1},
                        {0, 0, 0, 1, 0, 0, 1, 0}
                };
        DFS g = new DFS(n, A);
        g.print_array(g.DFS(0));
    }

}
