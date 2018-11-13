import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'closest' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER_ARRAY queries
     */

    public static List<Integer> closest(String s, List<Integer> queries) {
        // Write your code here
        List<Integer> ans= new ArrayList<>();
        HashMap<String,Integer> check= new HashMap<>();
        for(int i : queries){
            char a = s.charAt(i);
            check.put(s, i);
            check.containsValue(a);
        }

        return ans; }


}

