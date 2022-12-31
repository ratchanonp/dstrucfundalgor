package datastr;

public class SplayNode {
    public int data;
    public SplayNode left;
    public SplayNode right;

    public SplayNode() {
        left = right = null;
    }

    public SplayNode(int data) {
        this.data = data;
        left = right = null;
    }
}
