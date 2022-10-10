package lab;

import datastr.BST;

public class Main {
    public static void main(String[] args) {
        BST tree = new BST();

        tree.add(3);
        tree.add(1);
        tree.add(2);
        tree.add(8);
        tree.add(15);
        tree.printTree();

        System.out.println();

        BST tree2 = new BST();
        tree2.add(8);
        tree2.add(4);
        tree2.add(7);
        tree2.add(40);
        tree2.add(15);
        tree2.add(13);
        tree2.add(13);
        tree2.printTree();
    }
}
