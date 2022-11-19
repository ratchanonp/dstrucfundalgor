/*
 * �ç���ҧ������ : ��Ѻ�Ҩ���
 * http://www.cp.eng.chula.ac.th/~somchai/books
 */
package datastr;

/**
 * ���ʷ�����ҧ�ǡ�����ҡ�Ţ�ٹ�������¡��
 *
 * @author ����� ����Է���ٵ�С��
 */
public class SparseVector {
    private int size;
    private int length;
    private Element[] elementData;
    public SparseVector(int length) {
        this.elementData = new Element[0];
        this.size = 0;
        this.length = length;
    }

    public int length() {
        return length;
    }

    public double get(int index) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].index == index)
                return elementData[i].value;
            if (elementData[i].index > index) break;
        }
        return 0.0;
    }

    public void set(int index, double value) {
        int i = 0;
        for (; i < size; i++)
            if (elementData[i].index >= index) break;
        if (i < size && elementData[i].index == index)
            elementData[i].value = value;
        else
            add(i, index, value);
    }

    void add(int i, int index, double value) {
        if (value != 0) {
            ensureCapacity(size + 1);
            for (int k = size; k > i; k--)
                elementData[k] = elementData[k - 1];
            elementData[i] = new Element(index, value);
            ++size;
        }
    }

    public double dot(SparseVector v2) {
        SparseVector v1 = this;
        double r = 0;
        int i1 = 0, i2 = 0;
        while (i1 < v1.size && i2 < v2.size) {
            Element e1 = v1.elementData[i1];
            Element e2 = v2.elementData[i2];
            if (e1.index < e2.index) i1++;
            else if (e1.index > e2.index) i2++;
            else {
                r += e1.value * e2.value;
                i1++;
                i2++;
            }
        }
        return r;
    }

    public SparseVector add(SparseVector v2) {
        SparseVector v1 = this;
        SparseVector v3 = new SparseVector(v1.length());
        int i1 = 0, i2 = 0, i3 = 0;
        while (i1 < v1.size && i2 < v2.size) {
            Element e1 = v1.elementData[i1], e2 = v2.elementData[i2];
            if (e1.index < e2.index) {
                v3.add(i3++, e1.index, e1.value);
                i1++;
            } else if (e1.index > e2.index) {
                v3.add(i3++, e2.index, e2.value);
                i2++;
            } else {
                v3.add(i3++, e1.index, e1.value + e2.value);
                i1++;
                i2++;
            }
        }
        while (i1 < v1.size) {
            Element e1 = elementData[i1++];
            v3.add(i3++, e1.index, e1.value);
        }
        while (i2 < v2.size) {
            Element e2 = elementData[i2++];
            v3.add(i3++, e2.index, e2.value);
        }
        return v3;
    }

    private void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int s = Math.max(capacity, 2 * elementData.length);
            Element[] arr = new Element[s];
            for (int i = 0; i < size; i++)
                arr[i] = elementData[i];
            elementData = arr;
        }
    }

    private static class Element {
        int index;
        double value;

        Element(int i, double v) {
            this.index = i;
            this.value = v;
        }
    }
}
