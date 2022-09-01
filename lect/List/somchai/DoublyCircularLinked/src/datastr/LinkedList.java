package datastr;

public class LinkedList implements List {

    private LinkedNode header;
    private int size;

    public LinkedList() {
        this.header = new LinkedNode(null, null, null);
        header.prev = header.next = header;
    }

    private void addBefore(LinkedNode n, Object e) {
        LinkedNode p = n.prev;
        LinkedNode newNode = new LinkedNode(e, p, n);
        p.next = n.prev = newNode;
        ++size;
    }

    @Override
    public void add(Object element) {
        addBefore(header, element);
    }

    private void removeNode(LinkedNode node) {
        LinkedNode p = node.prev;
        LinkedNode n = node.next;
        p.next = n;
        n.prev = p;
        --size;
    }

    @Override
    public void remove(Object element) {
        LinkedNode q = header.next;

        while (q != header) {
            if (q.element.equals(element)) {
                removeNode(q);
                break;
            }
            q = q.next;
        }

    }

    @Override
    public boolean isEmpty() {
        return header.next == null;
    }

    @Override
    public boolean contains(Object element) {
        return indexOf(element) >= 0;
    }

    @Override
    public int size() {
        return size;
    }

    private LinkedNode nodeAt(int i) {
        LinkedNode p = header;
        for (int j = -1; j < i; j++) {
            p = p.next;
        }
        return p;
    }

    @Override
    public void add(int index, Object e) {
        addBefore(nodeAt(index), e);
    }

    @Override
    public void remove(int index) {

    }

    @Override
    public Object get(int index) {
        return nodeAt(index).element;
    }

    @Override
    public void set(int index, Object e) {
        nodeAt(index).element = e;
    }

    @Override
    public int indexOf(Object e) {
        LinkedNode node = header.next;
        for (int i = 0; i < size; i++) {
            if (node.element.equals((e))) return i;
            node = node.next;
        }

        return -1;
    }

    private static class LinkedNode {
        Object element;
        LinkedNode prev, next;

        public LinkedNode(Object element, LinkedNode prev, LinkedNode next) {
            this.element = element;
            this.prev = prev;
            this.next = next;
        }
    }
}
