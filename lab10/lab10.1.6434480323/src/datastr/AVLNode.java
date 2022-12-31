package datastr;

public class AVLNode extends BTNode {
    private int height;

    public AVLNode(int element, BTNode left, BTNode right) {
        super(element, left, right);
        setHeight();
    }

    public static int numNode(BTNode r) {
        if (r == null) return 0;
        return 1 + numNode(r.left) + numNode(r.right);
    }

    public void setHeight() {
        height = 1 + Math.max(height(left), height(right));
    }

    public int height(BTNode n){
        return (n == null ? -1 : ((AVLNode) n).height);
    }

    public int balanceValue(){
        return height(right) - height(left);
    }
}
