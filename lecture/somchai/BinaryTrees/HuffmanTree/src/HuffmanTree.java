public class HuffmanTree extends BinaryTree implements Comparable<Object>{

    public static HuffmanTree coding(int[] freq) {
        BinaryMinHeap h = new BinaryMinHeap(freq.length);
        for (int i = 0; i < freq.length; i++) {
            h.enqueue(new HuffmanTree(freq[i], null, null));
        }

        for (int i = 0; i < freq.length - 1; i++) {
            HuffmanTree t1 = (HuffmanTree) h.dequeue();
            HuffmanTree t2 = (HuffmanTree) h.dequeue();
            int f = t1.freq() + t2.freq();
            h.enqueue(new HuffmanTree(f, t1.root, t2.root));
        }
        return (HuffmanTree) h.dequeue();
    }

    public HuffmanTree(int freq, Node left, Node right) {
        root = new Node(freq, left, right);
    }

    @Override
    public int compareTo(Object o) {
        return freq() - ((HuffmanTree) o).freq();
    }

    private int freq() {
        return (Integer) root.element;
    }
}
