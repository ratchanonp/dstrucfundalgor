package datastr;

public class ArrayList implements List {
    private Object[] elementData;
    private int size;

    public ArrayList(Object[] elementData) {
        this.elementData = elementData;
    }

    @Override
    public void add(Object element) {
        add(size, element);
    }

    @Override
    public void remove(Object element) {
        int i = indexOf(element);
        if (i >= 0) remove(i);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object element) {
        return indexOf(element) != -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(int index, Object e) {
        ensureCapacity(size+1);
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i-1];
        }
        elementData[index] = e;
        size++;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int s = Math.max(capacity, 2 * elementData.length);
            Object[] arr = new Object[s];
            for (int i = 0; i < size; i++)
                arr[i] = elementData[i];
            elementData = arr;
        }
    }

    @Override
    public void remove(int index) {
        for (int i = index+1; i < size; i++) {
            elementData[i-1] = elementData[i];
        }
        size--;
        elementData[index] = null;
    }

    @Override
    public Object get(int index) {
        return elementData[index];
    }

    @Override
    public void set(int index, Object e) {
        elementData[index] = e;
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(e)) return i;
        }
        return -1;
    }
}
