package exercise;

import datastr.LinkedCollectionWithDup;

public class Main {
    public static void main(String[] args) {
        LinkedCollectionWithDup collectionWithDup = new LinkedCollectionWithDup();

        for (int i = 0; i < 10; i++) {
            collectionWithDup.add(i);
            collectionWithDup.add(i);
        }

        collectionWithDup.remove(1);
//        collectionWithDup.remove(1);

        System.out.println(collectionWithDup);
    }
}
