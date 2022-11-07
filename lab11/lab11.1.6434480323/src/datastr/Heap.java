package datastr;

import java.util.Arrays;

public class Heap {

    private int[] elementData;
    private int size;

    public Heap(int cap) {
        elementData = new int[cap];
    }

    private int dequeue() {
        int max = elementData[0];
        elementData[0] = elementData[--size];
        if (size > 1) fixDown(0);
        return max;
    }

    private void fixDown(int k) {
        int c;
        while ((c = 2 * k + 1) < size) {
            if (c + 1 < size && elementData[c + 1] > elementData[c]) c++;
            if (!(elementData[c] > elementData[k])) break;

            // Swap
            int temp = elementData[k];
            elementData[k] = elementData[c];
            elementData[c] = temp;

            k = c;
        }
    }


    public static void createHeap(int[] d) {
        Heap h = new Heap(0);
        h.elementData = d.clone();
        h.size = d.length;
        for (int i = h.size - 1; i >= 0; i--) h.fixDown(i);

        if (h.size >= 0) System.arraycopy(h.elementData, 0, d, 0, h.size);
    }
}
