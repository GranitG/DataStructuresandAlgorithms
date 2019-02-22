import com.sun.scenario.effect.Merge;

import java.util.*;

public class Sort {


    public static int[] insertion_sort (int[] array) {
        //solution done
        int key,i,j;
        for (j=1; j<array.length;j++) {
            key = array[j];
            i=j-1;
            while (i >=0 && array[i]>key){
                array[i+1]=array[i];
                i=i-1;
            }
            array[i+1]=key;
        }
return array;
    }

    public static int[] merge_sort (int[] array, int p, int r) {
		/*
		 * fill in your program
		 */
		//solution done.
        int q;
		if (p<r){
		    q=((p+r)/2);
		    Sort.merge_sort ( array, p, q );
            Sort.merge_sort ( array, q+1, r );
            Sort.merge ( array,p,q,r );
        }
        return array;
    }

    public static int[] merge (int[] array, int p, int q, int r) {
		/*
		 * fill in your program
		 */

        //solution done

        double inf = Double.POSITIVE_INFINITY;
        int num1=q-p+1;
        int num2=r-q;
        int L[] = new int[num1+1];
        int R[] = new int[num2+1];
        for (int i=0; i<num1;i++)
            L[i]=array[p+i];
        for (int j=0; j<num2;j++)
            R[j]=array[q+j+1];
        L[num1]= (int) inf;
        R[num2]= (int) inf;
        int j=0;
        int i=0;
        for (int k=p;k<=r;k++) {
            if (L[i] < R[j]){
                array[k] = L[i];
                i++;
            }
            else {
                array[k] = R[j];
                j++;
            }
        }
        return array;
    }

    /*
     * n: the size of the output array
     * k: the maximum value in the array
     */
    public static int[] generate_random_array (int n, int k) {
        List<Integer> list;
        int[] array;
        Random rnd;

        rnd = new Random(System.currentTimeMillis());

        list = new ArrayList<Integer> ();
        for (int i = 1; i <= n; i++)
            list.add(new Integer(rnd.nextInt(k+1)));

        Collections.shuffle(list, rnd);

        array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = list.get(i).intValue();

        return array;
    }

    /*
     * n: the size of the output array
     */
    public static int[] generate_random_array (int n) {
        List<Integer> list;
        int[] array;

        list = new ArrayList<Integer> ();
        for (int i = 1; i <= n; i++)
            list.add(new Integer(i));

        Collections.shuffle(list, new Random(System.currentTimeMillis()));

        array = new int[n];
        for (int i = 0; i < n; i++)
            array[i] = list.get(i).intValue();

        return array;
    }

    /*
     * Input: an integer array
     * Output: true if the array is acsendingly sorted, otherwise return false
     */
    public static boolean check_sorted (int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i-1] > array[i])
                return false;
        }
        return true;
    }

    public static void print_array (int[] array) {
        for (int i = 0; i < array.length; i++)
            System.out.print(array[i] + ", ");
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println("Insertion sort starts ------------------");
        for (int n = 100000; n <= 1000000; n=n+100000) {
            int[] array = Sort.generate_random_array(n);
            long t1 = System.currentTimeMillis();
            array = Sort.insertion_sort(array);
            long t2 = System.currentTimeMillis();
            long t = t2 - t1;
            boolean flag = Sort.check_sorted(array);
            System.out.println(n + "," + t + "," + flag);
        }
        System.out.println("Insertion sort ends ------------------");


        System.out.println("Merge sort starts ------------------");
        for (int n = 100000; n <= 1000000; n=n+100000) {
            int[] array = Sort.generate_random_array(n);
            //Sort.print_array(array);
            long t1 = System.currentTimeMillis();
            array = Sort.merge_sort(array, 0, n-1);
            long t2 = System.currentTimeMillis();
            long t = t2 - t1;
            //Sort.print_array(array);
            boolean flag = Sort.check_sorted(array);
            System.out.println(n + "," + t + "," + flag);
        }
        System.out.println("Merge sort ends ------------------");
    }

}
