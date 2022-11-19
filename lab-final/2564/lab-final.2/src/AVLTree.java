/**
 * เพื่อเขียนโปรแกรมโครงสร้างข้อมูลแบบ AVLTree โดยใช้ AVLNode ในการเก็บข้อมูล และมีรายละเอียดของ method ต่างๆ
 */

public class AVLTree {
    AVLNode root;

    public AVLTree() {}

    private void updateW(AVLNode node) {
        node.setHeight();
        node.setWeight();
    }

    /**
     * ปรับสมดุลของ AVL tree โดยเรียกใช้ method ที่ใช้หมุน:
     * @param r node
     * @return node หลังหมุน
     */
    private AVLNode rotate(AVLNode r) {
        if (r == null) return r;

        updateW(r);
        if (r.weight == -2) {
            if (r.left.weight == 1)     r = doubleLeftRotate(r);
            else                        r = singleLeftRotate(r);
        } else if (r.weight == 2) {
            if (r.right.weight == -1)   r = doubleRightRotate(r);
            else                        r = singleRightRotate(r);
        }

        updateW(r);
        return r;
    }

    private AVLNode singleRightRotate(AVLNode r) {
        //System.out.println("singleRightRotate");
        r = rotateRightChild(r);
        return r;
    }
    private AVLNode singleLeftRotate(AVLNode r) {
        //System.out.println("singleLeftRotate");
        r = rotateLeftChild(r);
        return r;
    }
    private AVLNode doubleRightRotate(AVLNode r) {
        //System.out.println("doubleRightRotate");
        r.right = rotateLeftChild(r.right);
        r = rotateRightChild(r);
        return r;
    }
    private AVLNode doubleLeftRotate(AVLNode r) {
        //System.out.println("doubleLeftRotate");
        r.left = rotateRightChild(r.left);
        r = rotateLeftChild(r);
        return r;
    }

    /**
     * เพิ่มโหนดข้อมูลเข้าไปใน AVL Tree
     * @param value ค่า
     */
    public void add(int value) {
        // System.out.println("Add : " + value);
        root = add(root, value);
    }

    private AVLNode add(AVLNode r, int value) {
        if (r == null) {
            r = new AVLNode(value, null, null);
        } else {
            if (value < r.value) r.left = add(r.left, value);
            else if (value > r.value) r.right = add(r.right, value);
        }

        r = rotate(r);
        return r;
    }

    /**
     * แสดงต้นไม้แบบ Preorder ออกทางจอภาพ
     */
    public void printTree() {
        preOrder(root);
        System.out.println();
    }

    public void preOrder(AVLNode r) {
        if (r == null) return;

        System.out.print(r.value + " ");
        preOrder(r.left);
        preOrder(r.right);
    }

    /**
     * ลบข้อมูลจำนวนเต็มที่เป็น โหนดแม่ ของโหนดที่มีค่าเป็น e ออกจาก AVLTree ตามหลักการลบข้อมูลของ AVL Tree ที่สอนไป
     * @param e
     */
    public void remove(Object e) {
        int value = (Integer) e;
        root = removeParent(root, value);
    }

    // Helper Method สำหรับ ลบข้อมูลจำนวนเต็มที่เป็น โหนดแม่ ของโหนดที่มีค่าเป็น e
    private AVLNode removeParent(AVLNode r, int value) {
        if (r == null) return r;

        if (value < r.value && r.left.value != value) r.left = removeParent(r.left, value);
        else if (value > r.value && r.right.value != value) r.right = removeParent(r.right, value);
        else {
            if (r.left == null || r.right == null) {
                r = r.left == null ? r.right : r.left;
            } else {
                AVLNode m = r.right;
                while(m.left != null) m = m.left;
                r.value = m.value;
                r.right = remove(r.right, m.value);
            }
        }

        r = rotate(r);
        return r;
    }

    // Remove ธรรมดา
    private AVLNode remove(AVLNode r, int value) {
        if (r == null) return r;

        if (value < r.value) r.left = remove(r.left, value);
        else if (value > r.value) r.right = remove(r.right, value);
        else {
            if (r.left == null || r.right == null) {
                r = r.left == null ? r.right : r.left;
            } else {
                AVLNode m = r.right;
                while(m.left != null) m = m.left;
                r.value = m.value;
                r.right = remove(r.right, m.value);
            }
        }

        r = rotate(r);
        return r;
    }


    // Helper Method for rotate AJ.Somchai
    private AVLNode rotateLeftChild(AVLNode r) {
        AVLNode newRoot = r.left;
        r.left = newRoot.right;
        newRoot.right = r;

        updateW(newRoot.right);
        updateW(newRoot);

        return newRoot;
    }

    private AVLNode rotateRightChild(AVLNode r) {
        AVLNode newRoot = r.right;
        r.right = newRoot.left;
        newRoot.left = r;

        updateW(newRoot.left);
        updateW(newRoot);

        return newRoot;
    }
}
