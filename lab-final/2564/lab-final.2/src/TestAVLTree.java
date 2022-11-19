/**
 * สร้างคลาสชื่อ TestAVLTree เพื่อสร้าง main method เพื่อตรวจสอบการทำงานของ AVLTree
 */

public class TestAVLTree {
    public static void main(String[] args) {
        int[] data = {4, 8, 7, 5, 6, 10, 2, 3, 9};

        AVLTree tree = new AVLTree();
        for (int value : data) tree.add(value);     // เพิ่มข้อมูล 4 8 7 5 6 10 2 3 และ 9 ตามลำดับ
        tree.printTree();                           // แสดงผล AVL Tree ทางจอภาพโดยใช้ printTree
        tree.remove(8);                             // แสดงผล AVL Tree ทางจอภาพโดยใช้ printTree
        tree.printTree();                           // แสดงผล AVL Tree ทางจอภาพโดยใช้ printTree
    }
}
