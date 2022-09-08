package datastr;

public interface Matrix {
    /**
     * คืนค่าเป็นจำนวน row
     * @return จำนวน row
     */
    public int numRows();

    /**
     * คืนค่าเป็นจำนวน column
     * @return จำนวน column
     */
    public int numCols();

    /**
     * คืนค่า element ที่ row r , column c ในเมทริกซ์
     * @param r row
     * @param c column
     * @return element ที่ row r , column c
     */
    public double get(int r, int c);

    /**
     * แก้ค่า element ที่ ที่ row r , column c ในเมทริกซ์ เป็น v
     * @param r row
     * @param c column
     * @param v ค่า
     */
    public void set(int r, int c, double v);

    /**
     * คืน Matrix ที่เป็นผลบวกของ implicit parameter และ explicit parameter โดยจะ throws exception เมื่อไม่สามารถบวกเมทริกซ์ได้ (มิติของเมทริกซ์ไม่เท่ากัน)
     * @param v explicit parameter
     * @return Matrix ที่เป็นผลบวกของ implicit parameter และ explicit parameter
     * @throws Exception เมื่อไม่สามารถบวกเมทริกซ์ได้ (มิติของเมทริกซ์ไม่เท่ากัน)
     */
    public Matrix add(Matrix v) throws Exception;

    /**
     * ที่คืน Matrix ที่เป็นผลคูณของ implicit parameter และ explicit parameter โดยจะ throws exception เมื่อไม่สามารถคูณเมทริกซ์ได้ (incompatibility for multiplication)
     * @param v explicit parameter
     * @return Matrix ที่เป็นผลคูณของ Matrix implicit parameter และ Vector explicit parameter
     * @throws Exception เมื่อไม่สามารถคูณเมทริกซ์ได้ (incompatibility for multiplication)
     */
    public Vector multiply(Vector v) throws Exception;

    /**
     * ที่คืน Matrix ที่เป็นผลคูณของ implicit parameter และ explicit parameter โดยจะ throws exception เมื่อไม่สามารถคูณเมทริกซ์ได้ (incompatibility for multiplication)
     * @param m explicit parameter
     * @return Matrix ที่เป็นผลคูณของ Matrix implicit parameter และ Matrix explicit parameter
     * @throws Exception เมื่อไม่สามารถคูณเมทริกซ์ได้ (incompatibility for multiplication)
     */
    public Matrix multiply(Matrix m) throws Exception;
}
