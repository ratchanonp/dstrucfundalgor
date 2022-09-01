package datastr;

public class LinkedCollectionWithDup implements Collection {
    private LinkedNode header;
    private int size;

    public LinkedCollectionWithDup() {
        this.header = new LinkedNode(null, null);
        this.size = 0;
    }

    public void add(Object element) {

        LinkedNode newNode = this.findNode(element);

        if (newNode == null) {
            header.next = new LinkedNode(element, header.next);
            ++size;
        } else {
            newNode.cnt++;
        }


    }

    @Override
    public void remove(Object element) {
        LinkedNode p = header;
        while (p.next != null &&
                !p.next.element.equals(element)) {
            p = p.next;
        }
        if (p.next != null) {
            if (p.next.cnt > 1) {
                p.next.cnt--;
            } else {
                p.next = p.next.next;
            }
            --size;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object element) {
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    public LinkedNode findNode(Object element) {
        LinkedNode p = header.next;

        while (p != null) {
            if (p.element.equals(element)) return p;
            p = p.next;
        }

        return null;
    }

    @Override
    public String toString() {
        String result = "";

        LinkedNode node = header.next;
        while (node != null) {
            result += "Value: " + node.element + " Cnt: " + node.cnt + "\n";
            node = node.next;
        }

        return result;
    }

    public static class LinkedNode {
        Object element;
        int cnt;
        LinkedNode next;

        public LinkedNode(Object element, LinkedNode next) {
            this.element = element;
            this.next = next;
            this.cnt = 1;
        }
    }
}
