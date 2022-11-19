import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] data) {
        qSortR(data, 0, data.length - 1);
        System.out.println(Arrays.toString(data));
    }

    static void qSortR(int[] data,int left, int right) {
        if (left < right) {
            int j = partition(data, left, right);
            qSortR(data, left, j - 1);
            qSortR(data, j + 1, right);
        }
    }

    static int partition(int[] data,int left,int right) {
        int pivot = data[left];
        int i = left, j = right + 1;

        while(i < j) {
            while (pivot > data[--j]);
            while (data[++i] > pivot) if (i == right) break;
            if (i < j) swap(data, i, j);
        }

        swap(data, left, j);
        return j;
    }

    static void swap(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
}
