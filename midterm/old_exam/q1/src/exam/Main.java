package exam;

import datastr.LinkedList;
import datastr.SinglyLinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        singlyLinkedList.add(1);
        singlyLinkedList.add(2);
        singlyLinkedList.add(3);

        System.out.println(linkedList);
        System.out.println(singlyLinkedList);

        singlyLinkedList.reverse();
        System.out.println(singlyLinkedList);

        linkedList.reverse();
        System.out.println(linkedList);
    }
}
