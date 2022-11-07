package lab;

import datastr.Heap;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] data = {20,9,32,6,15,25,50,5,8,13,18};

        System.out.println("Data : " + Arrays.toString(data));
        Heap.createHeap(data);
        System.out.println("Heap : " + Arrays.toString(data));

    }
}
