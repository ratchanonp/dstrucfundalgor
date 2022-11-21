package datastr;

public interface List extends Collection {
    public void add(int index, Object e);
    public Object get(int index);
    public void set(int index, Object e);
    public int indexOf(Object e);
}