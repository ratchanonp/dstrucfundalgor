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

    /**
     * Method สำหรับเพิ่ม node ลงไปใน BST
     * @param newElement ค่าที่จะเพิ่มลงไป
     */
    public void add(int newElement) {
        BTNode newNode = new BTNode(newElement, null, null);                      // สร้าง node ใหม่มีค่า newElement

        // ตรวจสอบว่าต้นไม้นี้ว่างไหม
        if (getRoot() == null) setRoot(newNode);                                            // ต้นไม้ว่างเพิ่มที่ root ได้เลย
        else {
            BTNode r = getRoot(), parent = null;                                            // r ใข้ในการ Traverse parent ใช้การจำ parent

            // loop จนกว่าจะเจอ parent node ที่จะเอาไปเพิ่ม แล้วจำค่าในตัวแปร parent
            while (r != null) {
                if      (newElement < r.getElement())   {parent = r; r = r.getLeft();}      // ค่ามากกว่า ไปทางซ้าย
                else if (newElement > r.getElement())   {parent = r; r = r.getRight();}     // ค่าน้อยกว่า เดินไปทางขวา
                else return;                                                                // กรณ๊ค่าเท่ากันแสดงว่ามีค่านั้นอยู่ใน Tree เรียบร้อยแล้ว
            }

            // ตรวจสอบว่าจะเพิ่ม node ใหม่ไปยังทางซ้ายหรือทางขวาของ parent node
            if (newElement < parent.getElement()) parent.setLeft(newNode);                  // ถ้าค่าน้อยกว่า ให้เพิ่มไปทางซ้าย
            else parent.setRight(newNode);                                                  // ถ้าค่ามากกว่า ให้เพิ่มไปทางขวา
        }
    }

    /**
     * Print ต้นไม้
     * หากต้นไม้ว่างไม่มีข้อมูลที่ตำแหน่งรากให้ print "Tree is Empty"
     * หากต้นไม้ไม่ว่างให้ print ค่าของต้นไม้โดย Traverse ไปในต้นไม้แบบ In-Order
     */
    public void printTree() {
        BTNode r = getRoot();
        if (r == null) System.out.println("Tree is Empty");
        else inOrder(r);
        System.out.println(); //ขึ้นบรรทัดใหม่
    }

    /**
     * Recursive In-Order Tree Traversal
     * @param node node ที่จะ print ค่า
     */
    private void inOrder(BTNode node) {
        if (node != null) {
            inOrder(node.getLeft());
            System.out.print(node.element + ",");
            inOrder(node.getRight());
        }
    }


}
