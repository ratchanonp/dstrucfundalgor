package Main;

import datastr.SparseVector;

public class Main {
    public static void main(String[] args) {
        dotExample();
        addExample();
    }

    private static void dotExample() {
        SparseVector v1 = new SparseVector(7);
        SparseVector v2 = new SparseVector(7);

        v1.set(1, 3);
        v1.set(5, 4);

        v2.set(1, 6);
        v2.set(5, 8);


        System.out.println(v1);
        System.out.println(v2);
        System.out.println("v1 dot v2 : " + v1.dot(v2));
    }

    private static void addExample() {
        SparseVector v1 = new SparseVector(7);
        SparseVector v2 = new SparseVector(7);

        v1.set(1, 3);
        v1.set(4, 1);
        v1.set(5, 4);

        v2.set(1, 6);
        v2.set(2, 3);
        v2.set(5, 3);

        System.out.println(v1);
        System.out.println(v2);
        System.out.println("v1 add v2 : "+v1.add(v2));
    }
}
