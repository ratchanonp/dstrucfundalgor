package datastr;

import java.util.NoSuchElementException;

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

        if (root.data == value) {
            System.out.println("There is " + value + " in the Splay Tree. No Duplicate Add!");
            return;
        }

        if (value < root.data) {
            newNode.left = root.left;
            newNode.right = root;
            root.left = null;
        } else {
            newNode.right = root.right;
            newNode.left = root;
            root.right = null;
        }

        root = newNode;
    }

    public void remove(int value) {
        if (debug) System.out.println("Remove: " + value);

        SplayNode x;
        splay(value);

        if (value != root.data) {
            System.out.println("No " + value + " to remove!");
            return;
        }

        if (root.left == null) {
            root = root.right;
        } else {
            x = root.right;
            root = root.left;
            splay(value);
            root.right = x;
        }

    }

    public int find(int key) {
        if (debug) System.out.println("Find: " + key);

        if (root == null) throw new NoSuchElementException("Empty Tree");
        splay(key);
        if (root.data != key) {
            System.out.println(key + " not found");
            return -1;
        }
        return root.data;
    }
    public int findMax() {
        if (root == null) throw new NoSuchElementException("Tree is Empty");

        SplayNode r = root;
        while (r.right != null) {r = r.right;}
        splay(r.data);

        return root.data;
    }
    public int findMin() {
        if (root == null) throw new NoSuchElementException("Tree is Empty");

        SplayNode r = root;
        while (r.left != null) {r = r.left;}
        splay(r.data);

        return root.data;
    }

    public void printTree() {
        System.out.println("Preorder");
        preOrder(root);
        System.out.println("\n");
    }

    void splay(int key) {
        if (debug) System.out.println("Splay : " + key);
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

    public void preOrder(SplayNode r) {
        if (r == null) return;

        System.out.print(r.data + " ");
        preOrder(r.left);
        preOrder(r.right);
    }
}
