package dp;

public class LCS {

    public static int lcs_length (String X, String Y) {
        /*
         * fill in your code here
         * Note: return the length of LCS, instead of c and b
         */


        /*

        Very easy if you actually draw it out.

         */


        int m=X.length () +1;
        int n=Y.length () +1;
        int[][] c=new int[m][n];
        int count=0;
        for(int i=1; i<m;i++){ c[i][0]=0; }
        for(int j=0; j<n;j++){ c[0][j]=0; }
        for(int i=1; i<m;i++){
            for(int j=1; j<n;j++){
                if (X.charAt(i-1)== Y.charAt(j-1)){ c[i][j]=c[i-1][j-1]+1; }
                else if (c[i-1][j]>=c[i][j-1]){ c[i][j]=c[i-1][j]; }
                else { c[i][j]=c[i][j-1]; }
            }
        }
    return c[m-1][n-1];
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(LCS.lcs_length("ABCBDAB", "BDCABA"));
        System.out.println(LCS.lcs_length("ACCGGTCGAGTGCGCGGAAGCCGGCCGAA", "GTCGTTCGGAATGCCGTTGCTCTGTAAA"));
    }

}
