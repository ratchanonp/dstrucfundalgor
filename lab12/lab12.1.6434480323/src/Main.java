import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] data = {15,9,7,16,31,2,20,25,17,12};
        System.out.println("Quick Sort");
        QuickSort.quickSort(data);

        int[] data2 = {5,2,12,9,1,8,7,18};
        System.out.println("Merge Sort");
        MergeSort.mergeSort(data2);
    }
}