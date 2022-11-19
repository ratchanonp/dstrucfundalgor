package lab;

import datastr.SeparateChainingModified;

public class SparseMtx {

    private int nRow, nCol;                 // เก็บจำนวน Row Column ไว้ตรวจสอบตอน Add
    private SeparateChainingModified data;  // Separate Chaining ที่เอาไว้เก็บ SparseMatrix

    /**
     * Constructor สำหรับสร้าง SparseMatrix เปล่าเอาไว้เพิ่มค่า
     * @param nRow จำนวนแถว
     * @param nCol จำนวนหลัก
     */
    public SparseMtx(int nRow, int nCol) {
        this.nRow = nRow;
        this.nCol = nCol;

        this.data = new SeparateChainingModified(Math.min(nRow, nCol));
    }

    /**
     * Constructor ที่รับพารามิเตอร์เป็น array 2 มิติของ double แล้วมาสร้างเป็น object ในคลาสนี้
     * @param m array 2 มิติของ double
     */
    public SparseMtx(double[][] m) {
        this.nRow = m.length;
        this.nCol = m[0].length;

        // TODO: Convert 2D Array to Separate Chaining Hashmap
        this.data = new SeparateChainingModified(nRow);

        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                if (m[i][j] != 0) {
                    data.add(new MatrixElement(i, j, m[i][j]));
                }
            }
        }
    }

    /**
     * Method ช่วยในการดึงค่าจาก Matrix ตำแหน่งที่ Row Column
     * @param row ตำแหน่งแถว
     * @param col ตำแหน่งหลัก
     * @return ค่าที่แถวและหลักนั้น
     */
    private double get(int row, int col) {
        MatrixElement ref = new MatrixElement(row, col);

        // Get แล้วไม่ null
        if (data.getByKey(ref) instanceof MatrixElement matrixElement) {
            return matrixElement.value;
        }

        // Get แล้วได้ null
        return 0;
    }

    /**
     * Method to2Darray() ที่ return array 2 มิติของ double ที่แทน matrix เดียวกับ object ที่เป็น implicit parameter
     * @return array 2 มิติของ double ที่แทน matrix
     */
    public double[][] to2Darray() {
        double[][] m = new double[nRow][nCol];

        // TODO : Convert Separate Chaining Hashmap to 2D Array;
        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                m[i][j] = this.get(i, j);
            }
        }

        return m;
    }

    /**
     * Method add(SparseMtx m) ที่ return ผลบวกของ m กับ implicit parameter (ห้ามแปลงกลับไปเป็น array เพื่อทำการบวก) เมื่อขนาดของ matrix ทั้งสองเท่ากัน
     * @param m matrix อีกอัน
     * @return matrix ผลบวกของ m กับ implicit parameter
     */
    public SparseMtx add(SparseMtx m) {
        if (this.nRow != m.nRow || this.nCol != m.nCol) throw new IllegalArgumentException("Not same Dimension");

        SparseMtx result = new SparseMtx(this.nRow, this.nCol);             // SparseMatrix ผลลัพธ์

        for (int i = 0; i < nRow; i++) {
            for (int j = 0; j < nCol; j++) {
                double m1v = this.get(i, j);
                double m2v = m.get(i, j);
                double ans = m1v + m2v;

                MatrixElement ansElement = new MatrixElement(i, j , ans);

                // นำมาบวกกันและผลลัพธ์ไม่ใช่ 0 นำไปเก็บใน SparseMatrix ผลลัพธ์
                if (ans != 0) {
                    result.data.add(ansElement);
                }
            }
        }

        return result;
    }

    /**
     * Class Matrix Element สำหรับการเก็บค่าใน Separate Chaining
     */
    private static class MatrixElement {
        int row, col;
        double value;

        // Constructor เอาไว้สร้าง Key สำหรับหาค่า
        public MatrixElement(int row, int col) {
            this.row = row;
            this.col = col;
        }

        // Main Constructor เอาไว้เก็บข้อมูล
        public MatrixElement(int row, int col, double value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }

        // Equal เอาไว้หาค่าใน LinkedList จาก Row กับ Column
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof MatrixElement that)) return false;

            if (row != that.row) return false;
            return col == that.col;
        }

        // Hashcode สำหรับเอาไปใส่ใน Separate Chaining
        @Override
        public int hashCode() {
            int result = row;
            result = 31 * result + col;
            return result;
        }
    }
}
