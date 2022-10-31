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

        boolean isLeaf(){
            return left == null && right == null;
        }
    }

    Node root;
}
