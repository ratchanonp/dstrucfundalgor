package datastr;

public class AVLTree extends BSTree {

    Node add(Node r, int element) {
        if (r == null) {
            r = new AVLNode(element, null, null);
        } else {
            r = super.add(r, element);
            r = rebalance(r);
        }
        return r;
    }

    Node remove(Node r, int element) {
        r = super.remove(r, element);
        r = rebalance(r);

        return r;
    }

    Node rebalance(Node r) {
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

    @Override
    Node rotateLeftChild(Node r) {
        if (debug) System.out.println("Rotate Left Child");

        r = super.rotateLeftChild(r);
        ((AVLNode) r.right).setHeight();
        ((AVLNode) r).setHeight();

        return r;
    }

    @Override
    Node rotateRightChild(Node r) {
        if (debug) System.out.println("Rotate Right Child");

        r = super.rotateRightChild(r);
        ((AVLNode) r.left).setHeight();
        ((AVLNode) r).setHeight();

        return r;
    }

    private static class AVLNode extends Node {
        private int height;

        AVLNode(int element, Node left, Node right) {
            super(element, left, right);
            setHeight();
        }

        void setHeight() {
            height = 1 + Math.max(height(left), height(right));
        }

        int height(Node n) {
            return (n == null ? -1 : ((AVLNode) n).height);
        }

        int balanceValue() {
            return height(right) - height(left);
        }
    }
}
