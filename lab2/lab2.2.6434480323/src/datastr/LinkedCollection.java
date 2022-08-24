package datastr;

/*
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */

public class LinkedCollection implements Collection {
    private final LinkedNode header = new LinkedNode(null, null);
    private int size;

    public LinkedCollection() {}

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object e) {
        header.next = new LinkedNode(e, header.next);
        ++size;
    }

    public boolean contains(Object e) {
        LinkedNode node = header.next;
        while (node != null) {
            if (node.element.equals(e)) return true;
            node = node.next;
        }
        return false;
    }

    public void remove(Object e) {
        LinkedNode p = header;
        while (p.next != null && !p.next.element.equals(e)) {
            p = p.next;
        }
        if (p.next != null) {
            p.next = p.next.next;
            --size;
        }
    }

    public Object[] toArray() {
        Object[] arr = new Object[size];
        LinkedNode p = header.next;
        int k = 0;
        while (p != null) {
            arr[k++] = p.element;
            p = p.next;
        }
        return arr;
    }

    public boolean equals(LinkedCollection lk) {
        LinkedNode compNode = lk.header.next;

        while (compNode != null) {
            if (!this.contains(compNode.element)) {
                return false;
            }
            compNode = compNode.next;
        }

        return true;
    }

    public boolean containsDup() {
        LinkedNode currentNode, nextNode;

        currentNode = header.next;
        while (currentNode != null) {
            nextNode = currentNode.next;
            while (nextNode != null) {
                if (currentNode.element.equals(nextNode.element)) {
                    return true;
                }
                nextNode = nextNode.next;
            }
            currentNode = currentNode.next;
        }

        return false;
    }

    public void removeDup() {
        LinkedNode currentNode, checkNode;

        currentNode = header.next;
        while (currentNode != null) {
            checkNode = currentNode;

            while (checkNode.next != null) {
                if (checkNode.next.element.equals(currentNode.element)) {
                    checkNode.next = checkNode.next.next;
                    size--;
                } else {
                    checkNode = checkNode.next;
                }
            }
            currentNode = currentNode.next;
        }
    }

    public void removeAll(Object e) {
        LinkedNode node = header.next;

        while (node != null) {
            if (node.next != null && node.next.element.equals(e)) {
                node.next = node.next.next;
                size--;
            } else {
                node = node.next;
            }
        }
    }

    private static class LinkedNode {
        Object element;
        LinkedNode next;

        LinkedNode(Object e, LinkedNode next) {
            this.element = e;
            this.next = next;
        }
    }
}
