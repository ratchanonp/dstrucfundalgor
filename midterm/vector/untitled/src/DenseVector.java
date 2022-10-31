import java.util.Arrays;

public class DenseVector {

    public static void main(String[] args) {
        int size = 10;
        int[] denseVector = new int[size];

        denseVector[1] = 3;
        denseVector[2] = 6;
        denseVector[5] = 8;

        Element[] sparseVector = new Element[3];

        sparseVector[0] = new Element(1, 3);
        sparseVector[1] = new Element(2, 6);
        sparseVector[2] = new Element(5,8);

        int j = 0;
        System.out.print("Sparse Vector : [");
        for (int i = 0; i < size; i++) {
            if (j < sparseVector.length && sparseVector[j].index == i) System.out.print(sparseVector[j++].value);
            else System.out.print(0);

            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");

        System.out.println("Dense Vector  : " + Arrays.toString(denseVector));
    }
}
