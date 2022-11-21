package datastr;

import java.util.Stack;

public class AVLTree {

    private AVLNode root;

    public AVLNode getRoot() {
        return root;
    }

    public AVLTree() {
        this.root = null;
    }

    public void updateHeight(AVLNode node) {
        AVLNode left = node.getLeft();
        AVLNode right = node.getRight();

        // Update Left Height
        if (left != null) node.setLH(1 + Math.max(left.getLH(), left.getRH()));
        else node.setLH(0);

        // Update Right Height
        if (right != null) node.setRH(1 + Math.max(right.getLH(), right.getRH()));
        else node.setRH(0);

        node.setWeight(node.getLH() - node.getRH());
    }

    // rebalance AVLTree
    public AVLNode rebalance(AVLNode start, AVLNode p, Stack<AVLNode> s) {
        updateHeight(start);

        if (Math.abs(start.getWeight()) > 1) {
            if (start.getWeight() > 0) {
                if (p.getWeight() >= 0) start = singleRightRotate(start, p);
                else                    start = doubleRightRotate(start, p);
            } else {
                if (p.getWeight() <= 0) start = singleLeftRotate(start, p);
                else                    start = doubleLeftRotate(start, p);
            }

            updatePreNode(s, start);
        }
        return start;
    }


    public void updatePreNode(Stack<AVLNode> s, AVLNode start) {
        AVLNode previous;

        if (!s.isEmpty()) {
            previous = s.peek();
            if (start.getElement() < previous.getElement()) previous.setLeft(start);
            else previous.setRight(start);
        }
        else root = start;
    }

    // Start Rotate Section
    public AVLNode singleRightRotate(AVLNode root, AVLNode newRoot) {
        root.setLeft(newRoot.getRight());
        newRoot.setRight(root);

        updateHeight(root);
        updateHeight(newRoot);

        root = newRoot;

        return root;
    }

    public AVLNode singleLeftRotate(AVLNode root, AVLNode newRoot) {
        root.setRight(newRoot.getLeft());
        newRoot.setLeft(root);

        updateHeight(root);
        updateHeight(newRoot);

        root = newRoot;

        return root;
    }

    public AVLNode doubleRightRotate(AVLNode root, AVLNode left) {
        AVLNode newRoot = left.getRight();

        left.setRight(newRoot.getLeft());
        root.setLeft(newRoot.getRight());

        newRoot.setRight(root);
        newRoot.setLeft(left);

        updateHeight(root);
        updateHeight(left);
        updateHeight(newRoot);

        root = newRoot;

        return root;
    }

    public AVLNode doubleLeftRotate(AVLNode root, AVLNode right) {
        AVLNode newRoot = right.getLeft();

        right.setLeft(newRoot.getRight());
        root.setRight(newRoot.getLeft());

        newRoot.setLeft(root);
        newRoot.setRight(right);

        updateHeight(root);
        updateHeight(right);
        updateHeight(newRoot);

        root = newRoot;

        return root;
    }
    // End Rotate Section
    public void add(int newElement) {
        AVLNode start, p;
        AVLNode newNode = new AVLNode(newElement, null, null, 0, 0, 0);
        Stack<AVLNode> s = new Stack<>();

        if (root == null)
            root = newNode;
        else {
            start = root;

            while (start != null) {
                s.push(start);

                if (newNode.getElement() < start.getElement()) start = start.getLeft();
                else start = start.getRight();
            }

            start = s.pop();

            if      (newNode.getElement() < start.getElement()) start.setLeft(newNode);
            else if (newNode.getElement() > start.getElement()) start.setRight(newNode);
            else return;

            updateHeight(start);

            p = start;
            while (!s.isEmpty()) {
                start = s.pop();
                start = rebalance(start, p, s);
                p = start;
            }
        }
    }

    /*
        removeSecondMax() ที่จะลบ Node ที่มีคามากสุดเปนอันดับสองออกจาก AVLTree แลวยังเปน AVLTree อยู (6 คะแนน)
     */
    public void removeSecondMax() {
        AVLNode start, parent, current;
        Stack<AVLNode> s = new Stack<>();

        start = root;
        parent = start;

        // Traverse
        while (start.getRight().getRight() != null) {
            s.push(start);
            parent = start;
            start = start.getRight();
        }

        // Remove
        if (!s.isEmpty()) s.pop();
        if (start == null) return;

        // Remove Case 1
        if ((start.getLeft() == null) && (start.getRight() == null)) {
            if      (start == root)             root = null;
            else if (parent.getLeft() == start) parent.setLeft(null);
            else                                parent.setRight(null);
        }
        // Remove case 2
        else if ((start.getLeft() != null) && (start.getRight() != null)) {
            parent = start;
            current = start.getLeft();

            s.push(current);

            while (current.getRight() != null) {
                parent = current;
                s.push(current);
                current = current.getRight();
            }

            start.setElement(current.getElement());

            if (parent == start) parent.setLeft(current.getLeft());
            else parent.setRight(current.getRight());
        }
        else if (start.getLeft() != null) {
            if      (start == root)             root = start.getLeft();
            else if (parent.getLeft() == start) parent.setLeft(start.getLeft());
            else                                parent.setRight(start.getLeft());
        }
        else if (start == root) {
            root = start.getRight();
        }
        else if (parent.getRight() == start) {
            parent.setRight(start.getRight());
        }
        else {
            parent.setLeft(start.getRight());
        }

        if (!s.isEmpty()) s.pop();

        // Pop to rebalance
        AVLNode node;
        while (!s.isEmpty()) {
            start = s.pop();
            updateHeight(start);

            if (Math.abs(start.getWeight()) > 1) {
                if (start.getLH() < start.getRH()) node = start.getRight();
                else node = start.getLeft();

                rebalance(start, node, s);
            }
        }
    }

    public void printTree() {
        AVLNode r = getRoot();
        if (r == null) System.out.println("Tree is Empty");
        else inOrder(r);
        System.out.println();
    }

    private void inOrder(AVLNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getElement() + ",");
            inOrder(node.getRight());
        }
    }
}
