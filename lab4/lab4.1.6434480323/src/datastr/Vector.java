package datastr;

public interface Vector {
    public int length();
    public double magnitude();
    public double get(int index);
    public void set (int index, double value);
    public Vector add(Vector v) throws Exception;
    public Vector subtract(Vector v) throws Exception;
    public double dot(Vector V) throws Exception;
    public Vector multiply(double c);


}
