package lab;

import datastr.DenseMatrix;
import datastr.DenseVector;
import datastr.Matrix;
import datastr.Vector;

public class Test {
    public static void main(String[] args) {
        Vector vector = new DenseVector(3);
        Matrix matrix = new DenseMatrix(3, 3);

        // Set Vector Value
        vector.set(0, 1);
        vector.set(1, 2);
        vector.set(2, 3);

        // Set Matrix Value
        matrix.set(0, 0, 1);
        matrix.set(0, 1, 2);
        matrix.set(0, 2, 3);
        matrix.set(1, 0, 4);
        matrix.set(1, 1, 5);
        matrix.set(1, 2, 6);
        matrix.set(2, 0, 7);
        matrix.set(2, 1, 8);
        matrix.set(2, 2, 9);

        try {
            System.out.println(matrix.multiply(vector));
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
