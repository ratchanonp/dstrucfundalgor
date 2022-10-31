public class BSTree extends BinaryTree {
    int size;

    public BSTree() {
    }

    public static void treeSort(final Object[] data) {
        BSTree t = new BSTree();

        for (int i = 0; i < data.length; i++) {
            t.add(data[i]);
        }

        t.inOrder(new Visitor() {
            int k = 0;

            @Override
            public void visit(Object e) {
                data[k++] = e;
            }
        });
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    int compare(Object a, Object b) {
        return ((Comparable) a).compareTo(b);
    }

    public Object get(Object e) {
        Node node = getNode(root, e);
        return node == null ? null : node.element;
    }

    private Node getNode(Node r, Object e) {
        if (r == null) return null;

        int cmp = compare(e, r.element);

        if (cmp == 0) return r;
        if (cmp < 0) return getNode(r.left, e);
        else return getNode(r.right, e);
    }

    public Object getMin() {
        Node r = root;
        if (r == null) return null;
        while (r.left != null) r = r.left;
        return r.element;
    }

    public Object getMax() {
        Node r = root;
        if (r == null) return null;
        while (r.right != null) r = r.right;
        return r.element;
    }

    public void add(Object e) {
        root = add(root, e);
    }

    Node add(Node r, Object e) {
        if (r == null) {
            r = new Node(e, null, null);
        } else {
            int cmp = compare(e, r.element);
            if (cmp < 0)
                r.left = add(r.left, e);
            else
                r.right = add(r.right, e);
        }

        return r;
    }

    public void remove(Object e) {
        root = remove(root, e);
    }

    Node remove(Node r, Object e) {
        if (r == null) return r;
        else {
            int cmp = compare(e, r.element);
            if (cmp < 0) {
                r.left = remove(r.left, e);
            } else if (cmp > 0) {
                r.right = remove(r.right, e);
            } else {
                if (r.left == null || r.right == null) {
                    r = r.left == null ? r.right : r.left;
                    size--;
                } else {
                    Node m = r.right;
                    while (m.left != null) m = m.left;
                    r.element = m.element;
                    r.right = remove(r.right, m.element);
                }
            }
        }
        return r;
    }
}
