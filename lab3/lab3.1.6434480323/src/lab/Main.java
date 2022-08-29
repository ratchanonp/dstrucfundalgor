package lab;

import datastr.ArrayList;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        ArrayList arrList = new ArrayList(100);

        for (int i = 0; i < 100; i++) {
            arrList.add(i);
        }

        System.out.println("Initial list");
        System.out.println(arrList);

        arrList.reverse();
        System.out.println("Reverse");
        System.out.println(arrList);

        //int i = 3, j = 96;
        int i = rand.nextInt(100);
        int j = rand.nextInt(100);
        arrList.removeRange(Math.min(i, j), Math.max(i, j));
        System.out.println("Remove " + Math.min(i, j) + ", " + Math.max(i, j));
        System.out.println(arrList);
    }
}
