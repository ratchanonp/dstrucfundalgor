package lab;

import datastr.SinglyLinkedList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();
        Random rand = new Random();

        for (int i = 0; i < 100; i++) singlyLinkedList.add(i);

        System.out.println("Initial list");
        System.out.println(singlyLinkedList);

        singlyLinkedList.reverse();
        System.out.println("Reverse");
        System.out.println(singlyLinkedList);

        //  int i = 3, j = 96;
        int i = rand.nextInt(100);
        int j = rand.nextInt(100);
        singlyLinkedList.removeRange(Math.min(i, j), Math.max(i, j));
        System.out.println("Remove " + Math.min(i, j) + ", " + Math.max(i, j));
        System.out.println(singlyLinkedList);
    }
}
