import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] data) {
        mSortR(data, 0, data.length - 1, data.clone());
        System.out.printf(Arrays.toString(data));
    }

    static void mSortR(int[] data, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mSortR(temp, left, mid, data);
            mSortR(temp, mid + 1, right, data);
            merge(temp, left, mid, right, data);
        }
    }

    static void merge(int[] data, int left, int mid, int right, int[] sorted) {
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid)    {sorted[k] = data[j++]; continue;}
            if (j > right)  {sorted[k] = data[i++]; continue;}
            sorted[k] = data[i] > data[j] ? data[i++] : data[j++];
        }
    }
}
