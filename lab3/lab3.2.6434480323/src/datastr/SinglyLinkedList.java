package datastr;

/*
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */
public class SinglyLinkedList implements List {
    private LinkedNode header;
    private int size;
    public SinglyLinkedList() {
        header = new LinkedNode(null, null);
        size = 0;
    }

    public boolean isEmpty() {
        return header.next == null;
    }

    public int size() {
        return size;
    }

    public boolean contains(Object e) {
        return indexOf(e) >= 0;
    }

    public void add(Object e) {
        add(size, e);
    }

    public void add(int i, Object e) {
        LinkedNode p = nodeAt(i - 1);
        p.next = new LinkedNode(e, p.next);
        ++size;
    }

    private LinkedNode nodeAt(int i) {
        LinkedNode p = header;
        for (int j = -1; j < i; j++) p = p.next;
        return p;
    }

    private void removeAfter(LinkedNode p) {
        if (p.next != null) {
            p.next = p.next.next;
            --size;
        }
    }

    public void remove(Object e) {
        LinkedNode p = header;
        while (p.next != null && !p.next.element.equals(e))
            p = p.next;
        removeAfter(p);
    }

    public void remove(int i) {
        LinkedNode p = nodeAt(i - 1);
        removeAfter(p);
    }

    public Object get(int i) {
        return nodeAt(i).element;
    }

    public void set(int i, Object e) {
        nodeAt(i).element = e;
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        LinkedNode p = header.next;
        for (int i = 0; i < size; i++) {
            arr[i] = p.element;
            p = p.next;
        }
        return arr;
    }

    public int indexOf(Object e) {
        LinkedNode node = header.next;
        for (int i = 0; i < size; i++) {
            if (node.element.equals((e))) return i;
            node = node.next;
        }

        return -1;
    }

    /* Lab3 add */
    public void swap(int i, int j) {
        if(i > size || j > size) return;

        LinkedNode nodeI = nodeAt(i);
        LinkedNode nodeJ = nodeAt(j);

        if (nodeI.element != null && nodeJ.element != null) {
            Object tempObj = nodeI.element;
            nodeI.element = nodeJ.element;
            nodeJ.element = tempObj;
        }
    }

    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            this.swap(i, size - i - 1);
        }
    }

    public void removeRange(int i, int j) {
        nodeAt(i - 1).next = nodeAt(j).next;
    }

    @Override
    public String toString() {
        String result = "";
        LinkedNode node = header.next;

        while (node != null) {
            result += node.element;
            if (node.next != null) result += ",";
            node = node.next;
        }

        return result;
    }

    private static class LinkedNode {
        Object element;
        LinkedNode next;

        LinkedNode(Object e, LinkedNode n) {
            this.element = e;
            this.next = n;
        }
    }
}
