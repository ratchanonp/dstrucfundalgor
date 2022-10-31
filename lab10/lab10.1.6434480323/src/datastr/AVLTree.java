package datastr;

public class AVLTree extends BST {

    public void add(int newElement) {
        setRoot(add(getRoot(), newElement));
    }

    BTNode add(BTNode r, int newElement) {
        if (r == null) {
            r = new AVLNode(newElement, null, null);
        } else {
            r = super.add(r ,newElement);
            r = rebalance(r);
        }
        return r;
    }

    public void remove(int element) {
        setRoot(remove(getRoot(), element));
    }

    BTNode remove(BTNode r, int element) {
        r = super.remove(r, element);
        r = rebalance(r);
        return r;
    }

    private BTNode rebalance(BTNode r) {
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

    BTNode rotateLeftChild(BTNode r) {
        BTNode newRoot = r.left;

        r.left = newRoot.right;
        newRoot.right = r;

        ((AVLNode) newRoot.right).setHeight();
        ((AVLNode) newRoot).setHeight();

        return newRoot;
    }

    BTNode rotateRightChild(BTNode r) {
        BTNode newRoot = r.right;

        r.right = newRoot.left;
        newRoot.left = r;

        ((AVLNode) newRoot.left).setHeight();
        ((AVLNode) newRoot).setHeight();

        return newRoot;
    }


    /*
        ตรวจว่า AVLTree มีข้อมูลแต่ละ Node เป็นยังไง
     */

    public void printDetail() {
        traversal(getRoot());
    }

    public void traversal(BTNode r) {
        if (r == null) return;
        traversal(r.left);
        System.out.printf("Element: %d \t Height: %d\n", r.element, ((AVLNode) r).height(r));
        traversal(r.right);
    }

}
