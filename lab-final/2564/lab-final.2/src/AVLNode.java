/**
 * เพื่อเก็บข้อมูลที่จำเป็นสำหรับ AVL Tree Node สามารถสมมติให้ข้อมูลเป็น variable ประเภท int ได้
 */

public class AVLNode {
    public int value;
    public AVLNode left;
    public AVLNode right;

    public int height;
    public int weight;

    public AVLNode(int value, AVLNode left, AVLNode right) {
        this.value = value;
        this.left = left;
        this.right = right;

        setHeight();
        setWeight();
    }

    public int height(AVLNode node) {
        if (node == null) return -1;
        return node.height;
    }

    public void setHeight() {
        height = 1 + Math.max(height(left), height(right));
    }

    public void setWeight() {
        weight = height(right) - height(left);
    }
}
