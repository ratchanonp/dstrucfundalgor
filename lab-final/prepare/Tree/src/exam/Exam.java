package exam;

import datastr.AVLTree;

public class Exam {
    public static void main(String[] args) {
        System.out.println("========== [Tree1] ==========");
        AVLTree tree = new AVLTree();
        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.add(4);
        tree.add(8);
        tree.add(15);
        tree.printTree();
        tree.remove(3);
        tree.printTree();
    }
}
