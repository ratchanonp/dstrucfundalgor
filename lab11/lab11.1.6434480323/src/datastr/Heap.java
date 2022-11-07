package datastr;

import java.util.Arrays;

public class Heap {

    private int[] elementData;
    private int size;

    public Heap() {}    // Empty Constructor for allocation

    /**
     * Heap Adjust แบบ fixDown แบบอจ.สมชาย
     * @param k
     */
    private void fixDown(int k) {
        int c;
        while ((c = 2 * k + 1) < size) {                                    // Loop เมื่อยังมีลูกซ้าย
            if (c + 1 < size && elementData[c + 1] > elementData[c]) c++;   // เมื่อมีลูกขวาและลูกทางขวา > ลูกทางซ้าย
            if (!(elementData[c] > elementData[k])) break;                  // Break เมื่อลูกมากกว่าพ่อ

            // Swap
            int temp = elementData[k];
            elementData[k] = elementData[c];
            elementData[c] = temp;

            k = c;
        }
    }

    /**
     * สร้าง Binary Heap แบบค่อยๆปรับ
     * @param data array ที่ต้องการจะปรับเป็น Binary Heap
     */
    public static void createHeap(int[] data) {
        Heap heap = new Heap();
        heap.elementData = data.clone();                                          // Copy ข้อมูลเข้า heap elementData
        heap.size = data.length;                                                  // ค่า size ใส่ใน Object Heap

        for (int i = heap.size - 1; i >= 0; i--) heap.fixDown(i);                 // ปรับ Heap แบบ FixDown ลงมาเรื่อยๆ

        System.arraycopy(heap.elementData, 0, data, 0, heap.size);   // Copy ข้อมูลจาก Heap เข้่า Array เดิม
    }
}
