package datastr;

public class AVLNode {
    private int LH, RH, W;
    private int element;
    private AVLNode left;
    private AVLNode right;

    AVLNode(int e, AVLNode l, AVLNode r, int lh, int rh, int w) {
        element = e;
        left = l;
        right = r;
        LH = lh;
        RH = rh;
        W = w;
    }

    public AVLNode getLeft() {
        return left;
    }

    public AVLNode getRight() {
        return right;
    }

    public int getElement() {
        return element;
    }

    public int getLH() {
        return LH;
    }

    public int getRH() {
        return RH;
    }

    public int getWeight() {
        return W;
    }

    public void setElement(int e) {
        element = e;
    }
    
    public void setLeft(AVLNode l) {
        left = l;
    }

    public void setRight(AVLNode r) {
        right= r;
    }

    public void setLH(int lh) {
        LH = lh;
    }

    public void setRH(int rh) {
        RH = rh;
    }

    public void setWeight(int w) {
        W = w;
    }
}
