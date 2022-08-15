package Collection;

public class ArrayCollection implements Collection {
    private Object[] elementData;
    private int size;

    public ArrayCollection() {
        elementData = new Object[2];
        size = 0;
    }

    @Override
    public void add(Object e) {
        if (e==null) throw new IllegalArgumentException();
        ensureCapacity(size + 1);
        elementData[size++] = e;
    }

    @Override
    public void remove(Object e) {
        int i = indexOf(e);
        if (i != -1){
            elementData[i] = elementData[--size];
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

    private void ensureCapacity(int capacity){
        if (capacity > elementData.length) {
            int s = Math.max(capacity, 2 * elementData.length);
            Object[] arr = new Object[s];
            for (int i = 0; i < size;i++) arr[i] = elementData[i];  // Loop copy data to new object arr
            elementData = arr;                                      // Assign new object arr to instance
        }
    }

    private int indexOf(Object e){
        for (int i = 0; i < size;i++){
            if (elementData[i].equals(e)){                          // Warning!! : Compare operation
                return i;
            }
        }

        return -1;
    }

    @Override
    public boolean equals(Object x) {
        Object e;                                                   // Reduce Allocate
        if (x instanceof ArrayCollection){
            ArrayCollection x1 = new ArrayCollection();
            for (int i = 0; i < ((ArrayCollection) x).size; i++) x1.add(((ArrayCollection) x).elementData[i]);
            for (int i = 0; i < size; i++) {
                e = elementData[i];
                if (x1.indexOf(e) != -1) x1.remove(e);
                else return false;
            }
            return x1.isEmpty();
        } else return false;
    }

    public Object[] toArray() {
        Object[] a = new Object[size];
        for (int i = 0; i < size; i++) {
            a[i] = elementData[i];
        }
        return a;
    }
}
