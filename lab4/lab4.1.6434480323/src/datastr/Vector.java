package datastr;

public interface Vector {
    // ข้อ 1
    /**
     * ส่งมิติ (dimension) ของเวกเตอร์คืน
     * @return มิติ (dimension) ของเวกเตอร์
     */
    public int length();

    /**
     * ส่งขนาด (magnitude) ของเวกเตอร์คืน
     * @return ขนาด (magnitude) ของเวกเตอร์
     */
    public double magnitude();

    /**
     * คืนค่า element ที่ index ของ implicit parameter
     * @param index ตำแหน่ง
     * @return element ที่ index ของ implicit parameter
     */
    public double get(int index);

    /**
     * แก้ค่า element ที่ index ของ implicit parameter เป็น value
     * @param index ตำแหน่ง
     * @param value ค่าใหม่
     */
    public void set (int index, double value);

    /**
     * คืน Vector ที่เป็นผลบวกของ implicit parameter และ explicit parameter โดยจะ throws exception เมื่อไม่สามารถบวกเวกตอร์ได้ (มิติของเวกเตอร์ไม่เท่ากัน)
     * @param v explicit parameter
     * @return Vector ที่เป็นผลบวกของ implicit parameter และ explicit parameter
     * @throws Exception เมื่อไม่สามารถบวกเวกตอร์ได้ (มิติของเวกเตอร์ไม่เท่ากัน)
     */
    public Vector add(Vector v) throws Exception;

    /**
     * คืน Vector ที่เป็นผลลบของ implicit parameter และ explicit parameter โดยจะ throws exception เมื่อไม่สามารถลบเวกเตอร์ได้ (มิติของเวกเตอร์ไม่เท่ากัน)
     * @param v explicit parameter
     * @return ผลลบของ implicit parameter และ explicit parameter
     * @throws Exception เมื่อไม่สามารถลบเวกเตอร์ได้ (มิติของเวกเตอร์ไม่เท่ากัน)
     */
    public Vector subtract(Vector v) throws Exception;


    /**
     * คืนจำนวนจริงที่เป็น dot product ของ implicit parameter และ explicit parameter โดยจะ throws exception เมื่อไม่สามารถหา dot product ได้ (มิติของเวกเตอร์ไม่เท่ากัน)
     * @param v explicit parameter
     * @return dot product ของ implicit parameter และ explicit parameter
     * @throws Exception เมื่อไม่สามารถหา dot product ได้ (มิติของเวกเตอร์ไม่เท่ากัน)
     */
    public double dot(Vector v) throws Exception;

    /**
     * คืน Vector ที่เป็นผลคูณของ implicit parameter กับค่าคงที่ c
     * @param c ค่าคงที่
     * @return ผลคูณของ implicit parameter กับค่าคงที่ c
     */
    public Vector multiply(double c);

    // ข้อ 2
    /**
     * คืน Vector ที่เป็นผลคูณของ implicit parameter (Vector) ด้วย explicit parameter (Matrix) โดยจะ throws exception เมื่อไม่สามารถคูณได้ (incompatibility for multiplication)
     * @param m explicit parameter (Matrix)
     * @return ผลคูณของ implicit parameter (Vector) ด้วย explicit parameter (Matrix)
     * @throws Exception เมื่อไม่สามารถคูณได้ (incompatibility for multiplication)
     */
    public Vector multiply(Matrix m) throws Exception;
}
