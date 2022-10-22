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
     * BST remove method without recursive
     * @param element ค่าที่ต้องการลบ
     */
    public void remove(int element) {

        /* Step 1 : หา node ที่ต้องการลบ และ parent ของ node */
        BTNode s = root, p = null;
        while (s != null && s.getElement() != element) {
            p = s;

            if (element < s.getElement()) s = s.getLeft();
            else s = s.getRight();
        }

        /* Step 1.5 : Traverse จนถึง node ลึกสุดของ BST แล้วไม่พบ */
        if (s == null) {
            //System.out.println("Node not founded");
            return;
        }

        /* Step 2 : ขั้นการลบ
        * มี 3 เงื่อนไข :
        * ไม่มี child node
        * มี child node 1 / 2 อัน
        * */


        /* 2.1 ไม่ม่ี Child Node */
        if (s.getLeft() == null && s.getRight() == null) {
            if (s == root) root = null;
            else if (p.getLeft() == s) p.setLeft(null);
            else p.setRight(null);
        }

        /* 2.2 มี Child Node 2 Node
        * หา node q สำหรับไปแทนที่ s และ parent ของ node q สำหรับลบ node นั้น
        * */
        else if (s.getLeft() != null && s.getRight() != null) {
            BTNode pq = s;
            BTNode q = s.getLeft();                     // สนใจ Left Subtree

            while (q.getRight() != null) {              // While loop หาค่าที่มากที่สุด
                pq = q;
                q = q.getRight();                       // Traverse ไปทางขวาต่อ
            }

            s.setElement(q.getElement());                           // แทนที่ค่าที่ต้องการลบด้วย s ที่มากที่สุดของฝั่งซ้าย

            if (pq != s)    pq.setRight(q.getLeft());               // สามารถหา s มากสุดของ subtree ซ้ายได้
            else            pq.setLeft(q.getLeft());                // ไม่สามารถหา s ใน subtree ด้านซ้าย
        }

        /* 2.3 มี Child Node 1 Node */
        else {
            if (s == root) {
                if (s.getLeft() != null) s = s.getLeft();
                else s = s.getRight();
            } else if (p.getLeft() == s) {
                if (s.getLeft() != null) p.setLeft(s.getLeft());
                else p.setLeft(s.getRight());
            } else {
                if (s.getLeft() != null) p.setRight(s.getLeft());
                else p.setRight(s.getRight());
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
