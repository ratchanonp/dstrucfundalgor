package datastr;

public class LinkedCollection implements Collection {

    private int size;
    private LinkedNode header;

    public LinkedCollection() {
        this.size = 0;
        this.header = new LinkedNode(null, null);
    }


    @Override
    public void add(Object e) {
        if (e == null) throw new IllegalArgumentException();
        header.next = new LinkedNode(e, header.next);
        size++;
    }

    @Override
    public void remove(Object element) {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object e) {
        LinkedNode node = header.next;
        while (node != null && !node.element.equals(e)) {
            node = node.next;
        }

        return node!=null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    public static class LinkedNode {
        private Object element;
        private LinkedNode next;

        LinkedNode(Object e, LinkedNode n) {
            element = e;
            next = n;
        }
    }
}
