package datastr;

class BTNode {
    BTNode left;
    BTNode right;
    int element;

    BTNode(int element, BTNode left, BTNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }

    /**
     * @return the element
     */
    public int getElement() {
        return element;
    }

    /**
     * @param element the element to set
     */
    public void setElement(int element) {
        this.element = element;
    }

    /**
     * @return the left
     */
    public BTNode getLeft() {
        return left;
    }

    /**
     * @param left the left to set
     */
    public void setLeft(BTNode left) {
        this.left = left;
    }

    /**
     * @return the right
     */
    public BTNode getRight() {
        return right;
    }

    /**
     * @param right the right to set
     */
    public void setRight(BTNode right) {
        this.right = right;
    }
}
