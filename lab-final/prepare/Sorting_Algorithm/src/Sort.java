public class Sort {


    public static void SelectionSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int maxIndex = i;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[maxIndex]) maxIndex = j;
            }

            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }
    }

    public static void BubbleSort(int[] arr) {
        for (int i = arr.length; i > 1; i--) {
            for (int j = 0; j < i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void MergeSort(int[] arr) {
        mSortR(arr, 0, arr.length - 1, arr.clone());
    }

    private static void mSortR(int[] arr, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            mSortR(temp, left, mid, arr);
            mSortR(temp, mid + 1, right, arr);
            merge(temp, left, mid, right, arr);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp) {
        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                temp[k] = arr[j++];
                continue;
            }
            if (j > right) {
                temp[k] = arr[i++];
                continue;
            }
            temp[k] = arr[i] < arr[j] ? arr[i++] : arr[j++];
        }
    }


    public static void QuickSort(int[] arr) {
        qSortR(arr, 0, arr.length - 1);
    }

    private static void qSortR(int[] arr, int left, int right) {
        if (left < right) {
            int j = partition(arr, left, right);
            qSortR(arr, left, j - 1);
            qSortR(arr, j + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left, j = right + 1;

        while (i < j) {
            while (arr[--j] > pivot);
            while (arr[++i] < pivot) if (i == right) break;
            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[left] = arr[j];
        arr[j] = pivot;

        return j;
    }
}
