package datastr;

public class BinaryTree {

    boolean debug = true;
    Node root;

    public int numNode() {
        return numNode(root);
    }

    public int height() {
        return height(root);
    }

    private int numNode(Node r) {
        if (r == null) return 0;
        return 1 + numNode(r.left) + numNode(r.right);
    }

    private int height(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public void printTree() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node r) {
        if (r == null) return;

        inOrder(r.left);
        System.out.print(r.element + " ");
        inOrder(r.right);
    }

    static class Node {
        int element;
        Node left;
        Node right;

        public Node(int element, Node left, Node right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }
}
