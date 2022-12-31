package lab;

import datastr.AVLTree;

import java.util.Arrays;

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
        tree.printDetail();

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
        tree2.printDetail();

        System.out.println("========== [Tree Test] ==========");
        AVLTree tree3 = new AVLTree();
        tree3.add(1);
        tree3.add(2);
        tree3.add(3);
        tree3.add(6);
        tree3.add(8);
        tree3.add(4);
        tree3.add(15);
        tree3.add(14);
        tree3.printTree();
        tree3.remove(40);
        tree3.printTree();
        tree3.printDetail();

        System.out.println(Arrays.toString(tree3.toArrays()));
    }
}
