public class SplayTree {

    boolean debug = true;

    static SplayNode header = new SplayNode();
    SplayNode root;

    public SplayTree() {
        this.root = null;
    }

    public void add(int value) {
        if (debug) System.out.println("Add: " + value);
        SplayNode newNode = new SplayNode(value);

        if (root == null) {
            root = newNode;
            return;
        }

        splay(value);

        if (value == root.data) {
            System.out.println("There is " + value + " in the Splay Tree. No Duplicate Add!");
            return;
        }

        if (value > root.data) {
            newNode.left = root.left;
            newNode.right = root;
            root.left = null;
        } else {
            newNode.left = root.right;
            newNode.right = root;
            root.right = null;
        }

        root = newNode;
    }

    void splay(int key) {
        SplayNode leftTree, rightTree, top, newRoot;

        leftTree = rightTree = header;
        top = root;

        header.left = null;
        header.right = null;

        for (; ; ) {
            if (key < top.data) {
                if (top.left == null) break;
                if (key < top.left.data) {
                    newRoot = top.left;
                    top.left = newRoot.right;
                    newRoot.right = top;

                    top = newRoot;

                    if (top.left == null) break;
                }

                rightTree.left = top;
                rightTree = top;
                top = top.left;
            } else if (key > top.data) {
                if (top.right == null) break;
                if (key > top.right.data) {
                    newRoot = top.right;
                    top.right = newRoot.left;
                    newRoot.left = top;

                    top = newRoot;

                    if (top.right == null) break;
                }

                leftTree.right = top;
                leftTree = top;
                top = top.right;
            } else {
                break;
            }
        }

        // Assemble Tree
        leftTree.right = top.left;
        rightTree.left = top.right;
        top.left = header.right;
        top.right = header.left;

        root = top;
    }
}
