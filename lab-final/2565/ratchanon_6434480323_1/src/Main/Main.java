package Main;

import datastr.ArrayQueue;
import datastr.Queue;
import datastr.SinglyLinkedList;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;

        /*
            วนรับชื่อจากผู้ใช้จนกว่าผู้ใช้ใส่ X โดยเก็บชื่อที่รับมาใน ArrayQueue
            จากนั้นให้ใช้ method toList ที่แปลง queue เป็น list
            และพิมพ์ค่าใน list เรียงจากหัวลิสต์ไปจนหมด
         */
        ArrayQueue queue = new ArrayQueue();

        System.out.println("Enter name. Stop with X");
        // วนรับชื่อจากผู้ใช้จนกว่าผู้ใช้ใส่ X
        do {
            input = scanner.nextLine().strip();
            if (!input.equals("X")) queue.enqueue(input); // โดยเก็บชื่อที่รับมาใน ArrayQueue
        } while (!input.equals("X"));

        SinglyLinkedList QToL = queue.toList();     // ให้ใช้ method toList ที่แปลง queue เป็น list

        System.out.println("List:");
        QToL.print();                               // พิมพ์ค่าใน list เรียงจากหัวลิสต์ไปจนหมด

        /*
            วนรับชื่อจากผู้ใช้จนกว่าผู้ใช้ใส่ X โดยเก็บชื่อที่รับมาใน SinglyLinkedList
            จากนั้นให้ใช้ method toQueue ที่แปลง list เป็น queue
            และดึงค่าใน queue ออกมาพิมพ์ตามลำดับ
         */
        SinglyLinkedList list = new SinglyLinkedList();

        System.out.println("\nEnter name. Stop with X");
        // วนรับชื่อจากผู้ใช้จนกว่าผู้ใช้ใส่ X
        do {
            input = scanner.nextLine().strip();
            if (!input.equals("X")) list.add(input);        // เก็บชื่อที่รับมาใน SinglyLinkedList
        } while (!input.equals("X"));


        Queue LToQ = list.toQueue();                // ให้ใช้ method toQueue ที่แปลง list เป็น queue

        System.out.println("Queue:");
        while(!LToQ.isEmpty()) {
            System.out.println(LToQ.dequeue());     // ดึงค่าใน queue ออกมาพิมพ์ตามลำดับ
        }

    }
}
