import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {7, 4, 6, 3, 8, 2, 1};

//        Sort.SelectionSort(arr);
//        Sort.BubbleSort(arr);
//        Sort.MergeSort(arr);
        Sort.QuickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
