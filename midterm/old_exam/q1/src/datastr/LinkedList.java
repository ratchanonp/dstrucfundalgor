package datastr;

public class LinkedList implements List {
    private int size;
    private LinkedNode header;

    public LinkedList() {
        size = 0;
        header = new LinkedNode(null, null, null);
        header.prev = header.next = header;
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
        return nodeOf(e) != header;
    }

    private LinkedNode nodeOf(Object e) {
        LinkedNode node = header.next;
        while (node != header && !node.element.equals(e)) {
            node = node.next;
        }
        return node;
    }

    public void add(Object e) {
        addBefore(header, e);
    }

    public void add(int i, Object e) {
        assertInRange(i, size);
        addBefore(nodeAt(i), e);
    }

    private void addBefore(LinkedNode node, Object e) {
        assertNonNull(e);
        LinkedNode prevNode = node.prev;
        LinkedNode newNode = new LinkedNode(e, prevNode, node);
        prevNode.next = node.prev = newNode;
        ++size;
    }

    public void remove(Object e) {
        LinkedNode node = nodeOf(e);
        if (node != header) removeNode(node);
    }

    public void remove(int i) {
        assertInRange(i, size);
        removeNode(nodeAt(i));
    }

    private void removeNode(LinkedNode node) {
        LinkedNode prevNode = node.prev;
        LinkedNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        --size;
    }

    public Object get(int i) {
        assertInRange(i, size - 1);
        return nodeAt(i).element;
    }

    public void set(int i, Object e) {
        assertNonNull(e);
        assertInRange(i, size - 1);
        nodeAt(i).element = e;
    }

    private LinkedNode nodeAt(int i) {
        LinkedNode p = header;
        for (int j = -1; j < i; j++) p = p.next;
        return p;
    }

    @Override
    public String toString() {
        LinkedNode node = header.next;
        StringBuilder result = new StringBuilder();

        result.append("[");
        while(node != header) {
            result.append(node.element);
            if (node.next != header) result.append(", ");
            node = node.next;
        }
        result.append("]");

        return result.toString();
    }

    public void reverse() {
        LinkedNode current = header;
        LinkedNode temp = null;

        while(temp != header) {
            temp = current.next;

            current.next = current.prev;
            current.prev = temp;

            current = temp;
        }
    }

    private static class LinkedNode {
        private Object element;
        private LinkedNode prev;
        private LinkedNode next;

        LinkedNode(Object e, LinkedNode p, LinkedNode n) {
            this.element = e;
            this.prev = p;
            this.next = n;
        }
    }
}
