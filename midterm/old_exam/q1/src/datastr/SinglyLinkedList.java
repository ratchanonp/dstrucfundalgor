package datastr;

public class SinglyLinkedList implements List {
    private int size;
    private LinkedNode header;

    public SinglyLinkedList() {
        size = 0;
        header = new LinkedNode(null, null);
    }

    private static void assertNonNull(Object e) {
        if (e == null) throw new IllegalArgumentException();
    }

    private static void assertInRange(int i, int max) {
        if (i < 0 || i > max)
            throw new IllegalArgumentException();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object e) {
        LinkedNode node = header.next;
        while (node != null && !node.element.equals(e)) {
            node = node.next;
        }
        return node != null;
    }

    public void add(Object e) {
        add(size, e);
    }

    public void remove(Object e) {
        LinkedNode p = header;
        while (p.next != null && !p.next.element.equals(e)) {
            p = p.next;
        }
        removeAfter(p);
    }

    private void removeAfter(LinkedNode p) {
        if (p.next != null) {
            p.next = p.next.next;
            --size;
        }
    }

    private LinkedNode nodeAt(int i) {
        LinkedNode p = header;
        for (int j = -1; j < i; j++) p = p.next;
        return p;
    }

    public Object get(int i) {
        assertInRange(i, size-1);
        return nodeAt(i).element;
    }
    public void set(int i, Object e) {
        assertNonNull(e);
        assertInRange(i, size-1);
        nodeAt(i).element = e;
    }
    public void add(int i, Object e) {
        assertNonNull(e);
        assertInRange(i, size);
        LinkedNode p = nodeAt(i-1);
        p.next = new LinkedNode(e, p.next);
        ++size;
    }
    public void remove(int i) {
        assertInRange(i, size-1);
        LinkedNode p = nodeAt(i-1);
        removeAfter(p);
    }

    @Override
    public String toString() {
        LinkedNode node = header.next;
        StringBuilder result = new StringBuilder();

        result.append("[");
        while(node != null) {
            result.append(node.element);
            if (node.next != null) result.append(", ");
            node = node.next;
        }
        result.append("]");

        return result.toString();
    }

    public void reverse() {
        LinkedNode prev = null;
        LinkedNode current = header.next;
        LinkedNode next = null;

        while (current != null) {
            next = current.next;

            current.next = prev;
            prev = current;

            current = next;
        }

        header.next = prev;
    }

    private static class LinkedNode {
        private Object element;
        private LinkedNode next;

        LinkedNode(Object e, LinkedNode n) {
            this.element = e;
            this.next = n;
        }
    }
}
