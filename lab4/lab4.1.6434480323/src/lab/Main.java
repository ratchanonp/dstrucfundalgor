package lab;

import datastr.DenseVector;
import datastr.SparseVector;

public class Main {
    public static void main(String[] args) {
        DenseVector v1 = new DenseVector(10);
        SparseVector v2 = new SparseVector(10);

        v1.set(0, 5.0);
        v1.set(1, 2.0);
        v1.set(2, 9.0);
        v1.set(3, 4.0);
        v1.set(4, 4.0);
        v1.set(5, 1.0);
        v1.set(6, 5.0);
        v1.set(7, 4.0);
        v1.set(8, 1.0);
        v1.set(9, 0.0);

        v2.set(0, 1.0);
        v2.set(4, 9.0);
        v2.set(5, 6.0);
        v2.set(6, 5.0);
        v2.set(9, 9.0);

        System.out.println("v1 \t\t = " + v1);
        System.out.println("0.5*v1 \t = " + v1.multiply(0.5));
        System.out.println("v2 \t\t = " + v2);
        System.out.println("0.5*v2 \t = " + v2.multiply(0.5));

        try {
            System.out.println("v1+v2 \t = " + v1.add(v2));
            System.out.println("v1-v2 \t = " + v1.subtract(v2));
            System.out.println("v1.v2 \t = " + v1.dot(v2));
            System.out.println("v2.v1 \t = " + v2.dot(v1));
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
