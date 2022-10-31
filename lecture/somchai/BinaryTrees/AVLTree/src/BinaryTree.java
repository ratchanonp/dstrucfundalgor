public class BinaryTree {
    Node root;

    public BinaryTree() {
    }

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

    public Object[] toArray() {
        final Object[] a = new Object[numNode()];
        Visitor v = new Visitor() {
            int k = 0;

            @Override
            public void visit(Object e) {
                a[k++] = e;
            }
        };
        preOrder(root, v);
        return a;
    }

    public boolean contains(final Object o){
        Visitor v = new Visitor() {
            @Override
            public void visit(Object e) {
                if (e.equals(o)) done();
            }
        };
        preOrder(root, v);
        return v.isDone();
    }

    // การแวะผ่านด้วย Visitor
    public void preOrder(Visitor v) {preOrder(root, v);}
    public void inOrder(Visitor v) {inOrder(root, v);}
    public void postOrder(Visitor v) {postOrder(root, v);}

    private void preOrder(Node r, Visitor v) {
        if (r == null || v.isDone()) return;
        v.visit(r.element);
        preOrder(r.left, v);
        preOrder(r.right, v);
    }

    private void inOrder(Node r, Visitor v) {
        if (r == null || v.isDone()) return;
        inOrder(r.left, v);
        v.visit(r.element);
        inOrder(r.right, v);
    }

    private void postOrder(Node r, Visitor v) {
        if (r == null || v.isDone()) return;
        postOrder(r.left, v);
        postOrder(r.right, v);
        v.visit(r.element);
    }

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
}
