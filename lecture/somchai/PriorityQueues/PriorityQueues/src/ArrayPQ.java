import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ArrayPQ implements PriorityQueue{

    private ArrayList<Object> list = new ArrayList<>(10);

    @Override
    public Object dequeue() {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public void enqueue(Object e) {
        list.add(e);
    }

    @Override
    public Object peek() {
        return list.get(maxIndex());
    }

    private int maxIndex() {
        if (isEmpty()) throw new NoSuchElementException();
        int max = 0;
        for (int i = 0; i < size(); i++) {
            Comparable d = (Comparable) list.get(i);
            if (d.compareTo(list.get(max)) < 0) max = i;
        }
        return max;
    }
}
