package lab;

import datastr.AVLTree;

public class Main {
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

        System.out.println("========== [Tree2] ==========");
        AVLTree tree2 = new AVLTree();
        tree2.add(8);
        tree2.add(4);
        tree2.add(7);
        tree2.add(40);
        tree2.add(15);
        tree2.add(13);
        tree2.add(13);
        tree2.printTree();
        tree2.remove(40);
        tree2.printTree();
    }
}
