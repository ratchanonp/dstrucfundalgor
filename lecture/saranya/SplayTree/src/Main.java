import datastr.SplayTree;

public class Main {
    public static void main(String[] args) {
        SplayTree t = new SplayTree();

        t.add(2);
        t.printTree();
        t.add(10);
        t.printTree();
        t.add(1);
        t.printTree();
        t.add(5);
        t.printTree();
        t.add(7);
        t.printTree();
        t.add(15);
        t.printTree();
        t.add(10);
        t.printTree();
        t.find(5);
        t.printTree();
        t.find(8);
        t.printTree();
//        t.findMin();
//        t.printTree();
//        t.findMax();
//        t.printTree();
        t.remove(15);
        t.printTree();
        t.remove(20);
        t.printTree();
    }
}
