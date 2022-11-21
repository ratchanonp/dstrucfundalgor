package datastr;

public class SinglyLinkedList implements List {
    private static class LinkedNode {
        Object element;
        LinkedNode next;
        LinkedNode(Object e, LinkedNode n) {
            this.element = e;
            this.next = n;
        }
    }
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
    public int indexOf(Object e) {
        LinkedNode q = header.next;
        for (int i=0; i<size; i++) {
            if (q.element.equals(e)) return i;
            q = q.next;
        }
        return -1;
    }
    public void add(Object e) {
        add(size, e);
    }
    public void add(int i, Object e) {
        LinkedNode p = nodeAt(i-1);
        p.next = new LinkedNode(e, p.next);
        ++size;
    }
    private LinkedNode nodeAt(int i) {
        LinkedNode p = header;
        for (int j = -1; j < i; j++) p = p.next;
        return p;
    }
    public Object get(int i) {
        return nodeAt(i).element;
    }
    public void set(int i, Object e) {
        nodeAt(i).element = e;
    }

    public ArrayQueue toQueue() {
        ArrayQueue result = new ArrayQueue();

        LinkedNode p = header.next;
        while(p != null) {
            result.enqueue(p.element);
            p = p.next;
        }

        return result;
    }

    public void print() {
        LinkedNode p = header.next;

        while(p != null) {
            System.out.println(p.element);
            p = p.next;
        }
    }
}