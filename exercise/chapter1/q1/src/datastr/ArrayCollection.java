package datastr;

import java.util.Arrays;

public class ArrayCollection implements Collection {

    private Object[] elementData;
    private int size;

    public ArrayCollection() {
        elementData = new Object[100];
        size = 0;
    }

    @Override
    public void add(Object e) {
        if (e == null) throw new IllegalArgumentException();
        ensureCapacity(size + 1);   //Ensure capacity if necessary
        elementData[size++] = e;
    }

    @Override
    public void remove(Object e) {
        int i = indexOf(e);
        if (i != -1) {
            elementData[i] = elementData[--size];   // Copy ค่าจาก Element ตัวหลังสุดมาใส่
            elementData[size] = null;
        }
    }

    @Override
    public boolean contains(Object e) {
        return indexOf(e) != -1;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    // Helper Method
    private int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(e)) return i;
        }
        return -1;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newLength = Math.max(capacity, 2 * elementData.length);
            Object[] newElementData = new Object[newLength];
            for (int i = 0; i < size; i++) newElementData[i] = elementData[i];
            elementData = newElementData;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArrayCollection that)) return false;
        Object[] thatArr = that.toArray();
        nextElement:
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < thatArr.length; j++) {
                if (elementData[i].equals(thatArr[j])) {
                    thatArr[j] = null;
                    continue nextElement;
                }
            }
        }

        for (int i = 0; i < thatArr.length; i++) {
            if (thatArr[i] != null) return false;
        }
        return true;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        for (int i = 0; i < size; i++) {
            arr[i] = elementData[i];
        }
        return arr;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (int i = 0; i < size; i++) {
            result.append(elementData[i]);
            if (i + 1 < size) result.append(",");
        }
        result.append("]");
        return result.toString();
    }

    // 11.1
    public boolean containsDup() {
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (elementData[j].equals(elementData[i])) return true;
            }
        }

        return false;
    }

    // 11.2
    public void clear() {
        elementData = new Object[10];
        size = 0;
    }

    // 11.3
    public int frequency(Object e) {
        int freq = 0;
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(e)) ++freq;
        }
        return freq;
    }

    // 11.4
    public void removeAll(Object e) {
        int i = 0;
        while (i < size) {
            if (elementData[i].equals(e)) {
                elementData[i] = elementData[--size];
            }

            if (!elementData[i].equals(e)) {
                i++;
            }
        }
    }

    //  11.5
    public void removeDup() {
        boolean[] isDup = new boolean[size];
        int uniqueCount = 0;

        for (int i = 0; i < size; i++) {
            if (!isDup[i]) {
                for (int j = i + 1; j < size; j++) {
                    if (elementData[j].equals(elementData[i])) {
                        isDup[j] = true;
                    }
                }
            }
            if (!isDup[i]) {
                uniqueCount++;
            }
        }

        Object[] removedDup = new Object[uniqueCount];
        int j = 0;
        for (int i = 0; i < size; i++) {
            if (!isDup[i]) removedDup[j++] = elementData[i];
        }

        elementData = removedDup;
        size = uniqueCount;
    }

    // 11.6
    public void trimToSize() {
        Object[] trim = new Object[size];
        for (int i = 0; i < size; i++) {
            trim[i] = elementData[i];
        }

        System.out.println("Element Data Before Trim : " + elementData.length);
        elementData = trim;
        System.out.println("Element Data After Trim : " + elementData.length);
    }

    // 11.7
    public boolean containsAll(ArrayCollection c) {
        boolean[] isContains = new boolean[c.size];

        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < c.size; j++) {
                if (this.elementData[i].equals(c.elementData[j])) {
                    isContains[j] = true;
                }
            }
        }

        for (int i = 0; i < c.size; i++) {
            if (!isContains[i]) return false;
        }

        return true;
    }

    public Object mode() {
        ArrayCollection uniqueCol = new ArrayCollection();
        int[] freq = new int[size];

        for (int i = 0; i < size; i++) {
            int index = uniqueCol.indexOf(elementData[i]);
            if (index == -1) {
                uniqueCol.add(elementData[i]);
                freq[uniqueCol.size - 1] = 1;
            } else {
                freq[index]++;
            }
        }

        int highestFreqIndex = 0, highestFreq = 0;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > highestFreq) {
                highestFreq = freq[i];
                highestFreqIndex = i;
            }
        }

        // System.out.println(uniqueCol);
        // System.out.println(Arrays.toString(freq));

        return uniqueCol.elementData[highestFreqIndex];
    }

    /**
     * 11.9 copy constructor
     * @param c ArrayCollection to copy
     */
    public ArrayCollection(ArrayCollection c) {
        elementData = c.elementData;
        size = c.size;
    }

    /**
     * 11.10 Constructor with initial capacity
     * @param capacity elementData length
     */
    public ArrayCollection(int capacity) {
        elementData = new Object[capacity];
        size = 0;
    }
}
