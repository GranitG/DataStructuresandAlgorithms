package ds;

import java.util.NoSuchElementException;

public class Queue {

    public int size;
    public int[] array;
    public int head;
    public int tail;

    public Queue () {
        size = 0;
        array = null;
        head = -1;
        tail = 0;
    }

    public Queue (int _size) {
        size = _size;
        array = new int[size];
        head = 0;
        tail = 0;
    }

    /*
     * Implement the ENQUEUE(Q, x) function
     */
    public void enqueue (int x) {
        array[tail]=x;
        if (tail==size-1){System.err.println ( "Sorry Queue is already full." );}
        else if (tail==array.length-1){tail=1;}
        else{tail++;}
    }

    /*
     * Implement the DEQUEUE(Q) function
     */
    public int dequeue () {
        int x =array[head];
        if (head==tail){System.err.println ( "Error The Queue is empty" );}
        else if (head==array.length-1){head=0;}
        else{head++;}
        return x;
    }

    /*
     * Convert queue to string in the format of #size, head, tail, [#elements]
     */
    public String toString () {
        String str;

        str = size + ", " + head + ", " + tail + ", [";
        for (int i = head; i%size < tail; i++)
            str += array[i] + ",";

        str += "]";
        return str;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Queue q;

        q = new Queue(10);
        for (int i = 0; i < 5; i++)
            q.enqueue(i);
        System.out.println(q.toString());
        for (int i = 0; i < 3; i++)
            q.dequeue();
        System.out.println(q.toString());
    }

}
