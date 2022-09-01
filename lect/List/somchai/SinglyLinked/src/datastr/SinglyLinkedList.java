package datastr;

public class SinglyLinkedList implements List {

    private final LinkedNode header = new LinkedNode(null, null);
    private int size;

    public SinglyLinkedList() {
    }


    @Override
    public void add(Object element) {
        add(size, element);
    }

    @Override
    public void remove(Object element) {
        LinkedNode p = header;
        while(p.next != null && !p.next.element.equals(element)) p = p.next;
        removeAfter(p);
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

    @Override
    public void add(int index, Object e) {
        LinkedNode p = nodeAt(index - 1);
        p.next = new LinkedNode(e, p.next);
        ++size;
    }

    private LinkedNode nodeAt(int i) {
        LinkedNode p = header;
        for (int j = -1; j < i; j++) {
            p = p.next;
        }
        return p;
    }

    private void removeAfter(LinkedNode p){
        if (p.next != null) {
            p.next = p.next.next;
        }
        --size;
    }

    @Override
    public void remove(int index) {
        LinkedNode p = nodeAt(index - 1);
        removeAfter(p);
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
        LinkedNode next;

        public LinkedNode(Object element, LinkedNode n) {
            this.element = element;
            this.next = n;
        }
    }
}
