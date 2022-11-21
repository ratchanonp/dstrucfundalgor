package exam;

import datastr.HashVector;

public class Main {
    public static void main(String[] args) {
        double[] vector1 = {0, 2, 0, 0, 5};
        double[] vector2 = {0, 1, 0, 0, 2};

        HashVector hVector1 = new HashVector(vector1);
        HashVector hVector2 = new HashVector(vector2);

        HashVector h1add2 = hVector1.add(hVector2);
        HashVector h1Mul2 = hVector1.multiply(2);

        printVector(h1add2);
        printVector(h1Mul2);
        System.out.println(hVector1.dot(hVector2));
    }

    private static void printVector(HashVector hashVector) {
        for (int i = 0; i < hashVector.size; i++) {
            System.out.print(hashVector.get(i) + " ");
        }
        System.out.println();
    }
}
