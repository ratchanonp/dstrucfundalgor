public class AVLTree extends BSTree {

    Node add(Node r, Object e) {
        if (r == null) {
            r = new AVLNode(e, null, null);
            size++;
        } else {
            r = super.add(r, e);
            r = rebalance(r);
        }

        return r;
    }

    Node remove(Node r, Object e) {
        r = super.remove(r, e);
        r = rebalance(r);
        return r;
    }

    private Node rebalance(Node r) {
        if (r == null) return r;
        int balance = ((AVLNode) r).balanceValue();
        if (balance == -2) {
            if (((AVLNode) r.left).balanceValue() == 1)
                r.left = rotateRightChild(r.left);
            r = rotateLeftChild(r);
        } else if (balance == 2) {
            if (((AVLNode) r.right).balanceValue() == -1)
                r.right = rotateLeftChild(r.right);
            r = rotateRightChild(r);
        }

        ((AVLNode) r).setHeight();
        return r;
    }

    private Node rotateRightChild(Node r) {
        Node newRoot = r.left;
        r.left = newRoot.right;
        newRoot.right = r;

        ((AVLNode) newRoot.right).setHeight();
        ((AVLNode) newRoot).setHeight();

        return newRoot;
    }

    private Node rotateLeftChild(Node r) {
        Node newRoot = r.right;
        r.right = newRoot.left;
        newRoot.left = r;

        ((AVLNode) newRoot.left).setHeight();
        ((AVLNode) newRoot).setHeight();

        return newRoot;
    }


    private static class AVLNode extends Node {
        private int height;

        public AVLNode(Object element, Node left, Node right) {
            super(element, left, right);
            setHeight();
        }

        private void setHeight() {
            height = 1 + Math.max(height(left), height(right));
        }

        int height(Node n) {
            return (n == null ? -1 : ((AVLNode) n).height);
        }

        int balanceValue() {
            return height(left) - height(right);
        }
    }
}
