package datastr;

public class SeparateChainingHashMap implements Map {
    private int size;
    private LinkedNode[] table;

    public SeparateChainingHashMap(int cap) {
        table = new LinkedNode[cap];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object get(Object key) {
        LinkedNode node = getNode(key);
        return node == null ? null : node.value;
    }

    public boolean containsKey(Object key) {
        return getNode(key) != null;
    }

    private LinkedNode getNode(Object key) {
        LinkedNode cur = table[h(key)];
        while (cur != null && !cur.key.equals(key)) {
            cur = cur.next;
        }
        return cur;
    }

    private int h(Object x) {
        return Math.abs(x.hashCode()) % table.length;
    }

    public Object put(Object key, Object value) {
        LinkedNode node = getNode(key);

        int h = h(key);
        table[h] = new LinkedNode(key, value, table[h]);
        ++size;

        return null;
    }

    public void remove(Object key) {
        int h = h(key);
        if (table[h] == null) return;
        if (table[h].key.equals(key)) {
            table[h] = table[h].next;
            --size;
        } else {
            LinkedNode prev = table[h];
            while (prev.next != null && !prev.next.key.equals(key)) {
                prev = prev.next;
            }
            if (prev.next != null) {
                prev.next = prev.next.next;
                --size;
            }
        }
    }

    @Override
    public String toString() {
        String result = "";

        for (int i = 0; i < table.length; i++) {
            result += String.format("[%d]", i);

            LinkedNode header = table[i];
            if (header != null) {
                result += " => [";
                while (header != null) {
                    result += header.value;
                    if (header.next != null) result += ", ";
                    header = header.next;
                }
                result += "]";
            }
            result += "\n";
        }

        return result;
    }

    private static class LinkedNode {
        Object key, value;
        LinkedNode next;

        LinkedNode(Object k, Object v, LinkedNode n) {
            key = k;
            value = v;
            next = n;
        }
    }
}
