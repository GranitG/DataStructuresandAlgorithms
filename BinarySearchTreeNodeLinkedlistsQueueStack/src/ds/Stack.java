package ds;

public class Stack {
    public int size;
    public int top;
    public int[] array;

    public Stack () {
        size = 0;
        top = -1;
        array = null;
    }

    public Stack (int _size) {
        size = _size;
        top = -1;
        array = new int[size];
    }

    /*
     * Implement the Stack-Empty(S) function
     */
    public boolean empty () {
        if (top==-1){ return true; }
        else{return false;}
    }

    /*
     * Implement the Push(S, x) function
     */
    public void push (int x) {
        if (top==size-1){System.err.println( "Sorry Stack is already full");}
        else {top++; array[top]=x; }
    }
    /*
     * Implement the Pop(S) function
     * Return -1 if the stack is empty
     */
    public int pop () {
        if (empty ()==true){
            throw new IndexOutOfBoundsException ("Error Underflow");
        }
        else top--;
        return array[top+1];
    }

    /*
     * Convert stack to string in the format of #size, [#elements]
     */
    public String toString () {
        String str;

        str = size + ", [";
        for (int i = 0; i <= top; i++)
            str += array[i] + ", ";

        str += "]";
        return str;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Stack s;

        s = new Stack(10);
        for (int i = 0; i < 5; i++)
            s.push(i);
        System.out.println(s.toString());

        for (int i = 0; i < 2; i++)
            s.pop();
        System.out.println(s.toString());
    }

}
