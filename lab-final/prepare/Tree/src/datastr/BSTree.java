package datastr;

public class BSTree extends BinaryTree{
    public BSTree() {}

    public void add(int element) {
        if (debug) System.out.println("Add : " + element);
        root = add(root, element);
    }

    Node add(Node r, int element) {
        if (r == null) {
            r = new Node(element, null, null);
        } else {
            if      (element < r.element)   r.left  = add(r.left, element);
            else if (element > r.element)   r.right = add(r.right, element);
        }
        return r;
    }

    public void remove(int element) {
        if (debug) System.out.println("Remove : " + element);
        root = remove(root, element);
    }

    Node remove(Node r, int element) {
        if (r == null) return r;
        if      (element < r.element) r.left  = remove(r.left, element);
        else if (element > r.element) r.right = remove(r.right, element);
        else {
            if (r.left == null || r.right == null) {
                r = (r.left == null ? r.right : r.left);
            } else {
                Node m = r.right;
                while (m.left != null) m = m.left;
                r.element = m.element;
                r.right = remove(r.right, m.element);
            }
        }

        return r;
    }

    Node rotateLeftChild(Node r) {
        Node newRoot = r.left;
        r.left = newRoot.right;
        newRoot.right = r;
        return newRoot;
    }

    Node rotateRightChild(Node r) {
        Node newRoot = r.right;
        r.right = newRoot.left;
        newRoot.left = r;
        return newRoot;
    }
}
