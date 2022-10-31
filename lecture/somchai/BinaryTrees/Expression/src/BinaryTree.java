public class BinaryTree {
    static class Node {
        Object element;
        Node left;
        Node right;

        public Node(Object element, Node left, Node right) {
            this.element = element;
            this.left = left;
            this.right = right;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }

    Node root;

    public int numNode() {
        return numNode(root);
    }

    public int height() {
        return height(root);
    }

    int numNode(Node node) {
        if (node == null) return 0;
        return 1 + numNode(node.left) + numNode(node.right);
    }

    int height(Node node) {
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    Node copy(Node r) {
        Node leftTree = copy(r.left);
        Node rightTree = copy(r.right);
        return new Node(r.element, leftTree, rightTree);
    }
}
