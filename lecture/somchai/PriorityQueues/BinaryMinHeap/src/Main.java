import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Object[] objects = new Object[10];

        for (int i = 0; i < 10; i++) {
            objects[i] = random.nextInt(50);
        }

        BinaryMinHeap binaryHeap = new BinaryMinHeap(objects);

        BinaryMinHeap.heapSort(objects);
        System.out.println(Arrays.toString(objects));
        System.out.println(BinaryMinHeap.select(objects, 3));
    }
}
