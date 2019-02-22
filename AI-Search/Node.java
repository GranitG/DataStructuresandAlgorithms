public class Node implements Comparable<Node> {
    public int Key;
    public int ID;

    public Node(int ID, int Key) {
        this.Key = Key;
        this.ID = ID;
    }
    public int compareTo(Node g) {
        if (Key > g.Key) {
            return 1;
        } else if (Key < g.Key) {
            return -1;
        } else
            return 0;
    }

}