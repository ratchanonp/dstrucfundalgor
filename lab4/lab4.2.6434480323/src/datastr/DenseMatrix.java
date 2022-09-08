package datastr;

public class DenseMatrix implements Matrix {

    DenseVector[] rows;
    int r, c;

    public DenseMatrix(int r, int c) {
        rows = new DenseVector[r];

        for (int i = 0; i < r; i++) {
            rows[i] = new DenseVector(c);
        }

        this.r = r;
        this.c = c;
    }

    @Override
    public int numRows() {
        return this.r;
    }

    @Override
    public int numCols() {
        return this.c;
    }

    @Override
    public double get(int r, int c) {
        return rows[r].get(c);
    }

    @Override
    public void set(int r, int c, double v) {
        rows[r].set(c, v);
    }

    @Override
    public Matrix add(Matrix v) throws Exception {
        if (this.numRows() != v.numRows() || this.numCols() != v.numCols())
            throw new Exception("Not same dimension");

        Matrix result = new DenseMatrix(this.numRows(), this.numCols());
        for (int i = 0; i < this.numRows(); i++) {
            for (int j = 0; j < this.numCols(); j++) {
                result.set(i, j, this.get(i, j) + v.get(i, j));
            }
        }

        return result;
    }

    @Override
    public Vector multiply(Vector v) throws Exception {
       if (this.numCols() != v.length()) throw new Exception("Incompatibility for multiplication");

       Vector result = new DenseVector(v.length());
        for (int i = 0; i < this.numRows(); i++) {
            double sum = 0;
            for (int j = 0; j < v.length(); j++) {
                sum += this.get(i,j) * v.get(j);
            }
            result.set(i, sum);
        }
       
       return result;
    }

    @Override
    public Matrix multiply(Matrix m) throws Exception {

        if (this.numCols() != m.numRows()) throw new Exception("Incompatibility for multiplication");

        Matrix result = new DenseMatrix(this.numRows(), m.numCols());
        for (int i = 0; i < this.numRows(); i++) {
            for (int j = 0; j < m.numCols(); j++) {
                double sum = 0;
                for (int k = 0; k < m.numRows(); k++) {
                    sum += this.get(i, k) * m.get(k, j);
                }
                result.set(i, j, sum);
            }
        }

        return result;
    }

    @Override
    public String toString() {
        String result = "";
        for (int i = 0; i < this.numRows(); i++) {
            for (int j = 0; j < this.numCols(); j++) {
                result += String.format("%4.1f", this.get(i,j)) + "\t";
            }
            result += "\n";
        }

        return result;
    }
}
