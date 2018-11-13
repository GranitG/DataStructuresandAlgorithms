import java.util.*;


public class test {
    public static int countMatches(List<String> grid1, List<String> grid2) {
        // Write your code here
        int matches = 0;
        int n2 = grid1.size() ;
        int[] grid1colors = getColors(grid1);
        int[] grid2colors = getColors(grid2);
        for(int i = 0 ; i< n2; i++){
                if (grid1colors[i]!=0&& grid2colors[i]!=0 && grid1colors[i] == grid2colors[i]) {
                    matches++;
                }
        }
        return matches ;
    }
    public static int[] getColors(List<String> grid) {
        int n = grid.size();
        int[][] pair = new int[n][n];
        int[] test=new int[n];


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n ; ++l) {
                    int ti = i + grid.get(l).charAt(0);
                    int tj = j + grid.get(l).charAt(1);
                    if (ti < 0 || ti >= n || tj < 0 || tj >= n) {
                        continue;
                    }
                    test[j]= i+1;
                    // cell (ti, tj) is valid neighbor do something with it.
                }
            }
        }
    return test;
    }


        /*final int GRAY = 1;
        final int BLACK = 2;
        final int WHITE = 0;
        int n = grid.size();
        int test= grid.get(0).length() - 1;
        int[] color =new int[n];
        LinkedList<Integer> Q = new LinkedList<Integer>();
        int U=0, V=0;
        Q.add(0);
        int[][] pair = new int[n][n];
        while (!(Q.isEmpty())) {
            U = Q.remove();
            V = 0;
            while (V < n) {
                if (U < test + 1 &&   V < test +1  && grid.get(U).charAt(V) == '1') {
                    if (V < test && U < test  && grid.get(U).charAt(V+1) == '1' && color[V] == WHITE){
                        color[V] = GRAY;
                        Q.add(V);
                        pair[U][V+1]=V;
                    }
                    else if (U < test && grid.get(U+1).charAt(V) == '1' && color[V] == WHITE){
                        color[V] = GRAY;
                        if (U < test && grid.get(U+1).charAt(V) == '1' && color[V] == WHITE) {

                            pair[U + 1][V] = V;
                            Q.add(V);
                        }
                    }
                    else if (V !=0 && grid.get(U).charAt(V-1) == '1' && color[V] == WHITE) {
                        color[V] = GRAY;
                        pair[U][V-1]=V;
                        Q.add(V);

                    }
                    else if (U != 0 && grid.get(U-1).charAt(V) == '1' && color[V] == WHITE) {
                        color[V] = GRAY;
                        pair[U-1][V]=V;
                        Q.add(V);

                    }
                    else{
                        pair[U][V]=V;
                    }
                }
                V++;
            }
            color[U] = BLACK;
        }


        return pair;
    } */
    public static void main(String[] args) {
        List<String> grid1= new ArrayList<>();
        List<String> grid2= new ArrayList<>();
        grid1.add("001");
        grid1.add("011");
        grid1.add("100");

        grid2.add("001");
        grid2.add("011");
        grid2.add("101");
        System.out.print(countMatches(grid1,grid2));
    }

}

