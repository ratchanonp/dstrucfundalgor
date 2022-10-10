package datastr;

public class BST {
    private BTNode root;

    public BST() {
        this.root = null;
    }

    /**
     * @return the root
     */
    private BTNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    private void setRoot(BTNode root) {
        this.root = root;
    }

    public void add(int newElement) {
        BTNode newNode = new BTNode(newElement, null, null);
        if (root == null) root = newNode;
        else {
            BTNode r = root, node = null;
            while (r != null) {
                if (newElement < r.getElement()) {
                    node = r;
                    r = r.getLeft();
                } else if (newElement > r.getElement()) {
                    node = r;
                    r = r.getRight();
                } else return;
            }

            if (newElement < node.getElement()) node.setLeft(newNode);
            else node.setRight(newNode);
        }
    }

    public void printTree() {
        BTNode r = getRoot();
        if (r == null) System.out.println("Tree is Empty");
        else inOrder(r);
    }

    public void inOrder(BTNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.element + ",");
            inOrder(node.getRight());
        }
    }


}
