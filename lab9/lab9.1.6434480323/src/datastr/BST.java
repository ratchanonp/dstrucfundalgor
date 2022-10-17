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
        if (getRoot() == null) setRoot(newNode);
        else {
            BTNode node = getRoot(), parent = null;
            while (node != null) {
                if (newElement < node.getElement()) {
                    parent = node;
                    node = node.getLeft();
                } else if (newElement > node.getElement()) {
                    parent = node;
                    node = node.getRight();
                } else return;
            }

            if (newElement < parent.getElement()) parent.setLeft(newNode);
            else parent.setRight(newNode);
        }
    }

    public int getMax() {
        BTNode node = root;
        while (node.getRight() != null) node = node.getRight();
        return node.getElement();
    }

    /**
     *
     * @param element
     */
    public void remove(int element) {

        /* Step 1 : find s and parent of that s */
        BTNode s = root, parent = null;
        while (s != null && s.getElement() != element) {
            parent = s;

            if (element < s.getElement()) s = s.getLeft();
            else s = s.getRight();
        }

        if (s == null) {
//            System.out.println("Node not founded");
            return;
        }

        // 0 Child
        if (s.getLeft() == null && s.getRight() == null) {
            if (s == root) root = null;
            else if (parent.getLeft() == s) parent.setLeft(null);
            else parent.setRight(null);
        }

        // 2 Child
        else if (s.getLeft() != null && s.getRight() != null) {

            // Find replace s and it parent
            BTNode pq = s;
            BTNode q = s.getLeft();                     // สนใจ Left Subtree
            while (q.getRight() != null) {              // loop หาค่าที่มากที่สุด
                pq = q;
                q = q.getRight();                       // Traverse ไปทางขวาต่อ
            }

            s.setElement(q.getElement());            // แทนที่ค่าที่ต้องการลบด้วย s ที่มากที่สุดของฝั่งซ้าย

            if (pq != s) pq.setRight(q.getLeft());   // สามารถหา s มากสุดของ subtree ซ้ายได้
            else pq.setLeft(q.getLeft());               // ไม่สามารถหา s ใน subtree ด้านซ้าย
        }

        // 1 Child
        else {
            if (s == root) {
                if (s.getLeft() != null) s = s.getLeft();
                else s = s.getRight();
            } else if (parent.getLeft() == s) {
                if (s.getLeft() != null) parent.setLeft(s.getLeft());
                else parent.setLeft(s.getRight());
            } else {
                if (s.getLeft() != null) parent.setRight(s.getLeft());
                else parent.setRight(s.getRight());
            }
        }

    }

    // Recursively
    public void removeRecursive(int element) {

    }

    public void printTree() {
        if (root == null) System.out.println("Tree is Empty");
        else inOrder(getRoot());        // Inorder Traversal
        System.out.println();
    }

    /**
     * Recursive InOrder Traversal
     * @param node
     */
    public void inOrder(BTNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.getElement() + ",");
            inOrder(node.getRight());
        }

    }


}
