import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        Object[] objects = new Object[10];

        for (int i = 0; i < 10; i++) {
            objects[i] = random.nextInt(50);
        }

        BinaryHeap binaryHeap = new BinaryHeap(objects);
        System.out.println(binaryHeap);
    }
}
