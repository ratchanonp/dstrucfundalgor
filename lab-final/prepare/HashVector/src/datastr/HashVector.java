package datastr;

public class HashVector {

    private LinearProbingHashMap data;
    public int size;

    public HashVector(int size) {
        this.size = size;
        this.data = new LinearProbingHashMap(size / 2);
    }

    public HashVector(double[] vector) {
        this.size = vector.length;
        this.data = new LinearProbingHashMap(vector.length / 2);

        for (int i = 0; i < vector.length; i++) {
            set(i, vector[i]);
        }
    }

    public double get(int pos) {
        if (data.get(pos) instanceof Double value) return value;
        return 0;
    }

    public void set(int pos, double val) {
        if (this.get(pos) != 0 && val == 0) data.remove(pos);
        if (val == 0) return;

        data.put(pos, val);
    }

    public HashVector add(HashVector v) {
        if (this.size != v.size) throw new IllegalArgumentException("Not same Dimension");

        HashVector result = new HashVector(size);
        for (int i = 0; i < size; i++) {
            result.set(i, this.get(i) + v.get(i));
        }

        return result;
    }

    public HashVector multiply(double c) {
        HashVector result = new HashVector(size);
        if (c == 0) return result; // อะไรคูณ 0 ก็ได้ 0

        for (int i = 0; i < size; i++) {
            result.set(i, get(i) * c);
        }
        return result;
    }

    public double dot(HashVector v) {
        double result = 0;
        for (int i = 0; i < size; i++) result += this.get(i) * v.get(i);
        return result;
    }
}
