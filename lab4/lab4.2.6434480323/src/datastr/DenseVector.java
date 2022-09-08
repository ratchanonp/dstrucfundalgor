package datastr;

public class DenseVector implements Vector {

    double[] values;
    int length;

    public DenseVector(int length) {
        this.length = length;
        values = new double[length];
    }

    @Override
    public int length() {
        return this.length;
    }

    @Override
    public double magnitude() {
        double sum_square = 0;
        for (double value : values) sum_square += value * value;

        return Math.sqrt(sum_square);
    }

    @Override
    public double get(int index) {
        return values[index];
    }

    @Override
    public void set(int index, double value) {
        values[index] = value;
    }

    @Override
    public DenseVector add(Vector v) throws Exception {
        if (this.length() != v.length()) throw new Exception("Not same length");

        DenseVector result = new DenseVector(this.length());
        for (int i = 0; i < this.length(); i++) {
            result.set(i, this.get(i) + v.get(i));
        }

        return result;
    }

    @Override
    public DenseVector subtract(Vector v) throws Exception {
        if (this.length() != v.length()) throw new IllegalArgumentException("Not same length");

        DenseVector result = new DenseVector(this.length());
        for (int i = 0; i < this.length(); i++) {
            result.set(i, this.get(i) - v.get(i));
        }

        return result;
    }

    @Override
    public double dot(Vector v) throws Exception {
        if (this.length() != v.length()) throw new IllegalArgumentException("Not same length");

        double result = 0;
        for (int i = 0; i < this.length(); i++) {
            result += this.get(i) * v.get(i);
        }

        return result;
    }

    @Override
    public Vector multiply(double c) {
        Vector result = new DenseVector(this.length());

        for (int i = 0; i < this.length(); i++) {
            result.set(i, c * this.get(i));
        }

        return result;
    }

    @Override
    public Vector multiply(Matrix m) throws Exception {
        if (this.length() != m.numRows()) throw new Exception("Incompatibility for multiplication");

        Vector result = new DenseVector(this.length());
        for (int i = 0; i < this.length(); i++) {
            double sum = 0;
            for (int j = 0; j < m.numRows(); j++) {
                sum += this.get(i) * m.get(j, i);
            }
            result.set(i, sum);
        }

        return result;
    }

    @Override
    public String toString() {
        String result = "[ ";

        for (double value : values) {
            result += value + " ";
        }
        result += "]";

        return result;
    }
}
