package datastr;

class BST {
    private BTNode root;

    BST(){
        this.root=null;
    }

    /**
     * @return the root
     */
    protected BTNode getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    protected void setRoot(BTNode root) {
        this.root = root;
    }

    BTNode add(BTNode r, int newElement) {
        if (r == null) {
            r = new BTNode(newElement, null, null);
        } else {
            if (newElement < r.element)
                r.left = add(r.left, newElement);
            else
                r.right = add(r.right, newElement);
        }
        return r;
    }

    BTNode remove(BTNode r, int newElement) {
        if (r == null) return r;
        if (newElement < r.element) r.left = remove(r.left, newElement);
        else if(newElement > r.element) r.right = remove(r.right, newElement);
        else {
            if (r.left == null || r.right == null) {
                r = r.left == null ? r.right : r.left;
            } else {
                BTNode m = r.right;
                while (m.left != null) m = m.left;
                r.element = m.element;
                r.right = remove(r.right, m.element);
            }
        }
        return r;
    }


    public void printTree() {
        inOrder(getRoot());
        System.out.println();
    }

    public void inOrder(BTNode r) {
        if (r == null) return;

        inOrder(r.left);
        System.out.print(r.element+",");
        inOrder(r.right);
    }
}
